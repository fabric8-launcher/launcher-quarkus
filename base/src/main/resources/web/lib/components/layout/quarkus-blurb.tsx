import * as React from 'react';
import { useLocalStorage } from '@rehooks/local-storage';
import './quarkus-blurb.scss';
import { useAnalytics } from '../../core/analytics';
import { Alert, Button, Form, Modal } from 'react-bootstrap';

export function QuarkusBlurb() {
  const analytics = useAnalytics();
  const [ notAgain, setNotAgain ] = useLocalStorage<boolean>('quarkus-blurb-visible-v1', false);
  const [ visible, setVisible ] = React.useState<boolean>(true);
  const [ notAgainCheckboxValue, setNotAgainCheckboxValue ] = React.useState<boolean>(false);
  const close = (notAgain?: boolean) => {
    analytics.event('Click', { label: 'Close', element: 'blurb'});
    setNotAgain(notAgain || false);
    setVisible(false);
  };
  const missingFeatureLinkClick = () => {
    analytics.event('Click', { label: 'Missing a feature?', element: 'blurb' });
  };
  const foundBugLinkClick = () => {
    analytics.event('Click', { label: 'Found a bug?', element: 'blurb' });
  };
  return (
    <>
      {visible && !notAgain && (
        <Modal
          onHide={close}
          className="quarkus-blurb code-quarkus-modal"
          show={true}
          aria-label="Holy Supersonic Atoms..."
        >
          <Modal.Header>This page will help you bootstrap your Quarkus application and discover its extension ecosystem.</Modal.Header>
          <Modal.Body>
            <p>Think of Quarkus extensions as your project dependencies. Extensions configure, boot and integrate a framework or technology into your Quarkus application. They also do all of the heavy
              lifting of providing the right information to GraalVM for your application to compile natively.</p>
            <br/>
            <p className="desktop-only">Explore the wide breadth of technologies Quarkus applications can be made with.</p>
            <Alert className="mobile-only quarkus-blurb" variant="warning">
              <p>On mobile devices, you can explore the list of Quarkus extensions.</p>
              <p><b>If you wish to generate code, try it with your desktop browser... </b></p>
            </Alert>
            <br/>
            <p className="desktop-only"><b>Generate your application!</b></p>
            <br/>
            <p>[<a href="https://github.com/quarkusio/code.quarkus.io/issues/new?labels=feature&template=feature_request.md" onClick={missingFeatureLinkClick} target="_blank" rel="noopener noreferrer">Missing
              a feature?</a> <a href="https://github.com/quarkusio/code.quarkus.io/issues/new?labels=bug&template=bug_report.md" target="_blank" rel="noopener noreferrer" onClick={foundBugLinkClick}>Found
              a bug?</a> We are listening for feedback]</p>
          </Modal.Body>
          <Modal.Footer>
            <Form.Check
              className="blurb-not-again-checkbox"
              custom
              inline
              label="Don't show this message again"
              type={'checkbox'}
              checked={notAgainCheckboxValue}
              onChange={() => setNotAgainCheckboxValue(!notAgainCheckboxValue)}
              id="blurb-not-again-checkbox"
            />
            <Button key="close" variant="secondary" aria-label="Close the introduction modal" onClick={() => close(notAgainCheckboxValue)}>
              Let's start coding!
            </Button>
          </Modal.Footer>
        </Modal>
      )}
    </>
  );
}