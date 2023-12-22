package io.quarkus.code.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@JsonInclude(Include.NON_NULL)
public record CodeQuarkusExtension(
    String id,
    @Deprecated
    String shortId,
    String version,
    String name,
    String description,
    String shortName,
    String category,
    List<String> tags,
    Set<String> keywords,
    @Deprecated
    boolean providesExampleCode,
    boolean providesCode,
    String guide,
    int order,
    boolean platform,
    String bom
) {

    public ExtensionRef toExtensionRef() {
        return new ExtensionRef(id, version, platform);
    }

    @JsonCreator
    public static Builder builder() {
        return new Builder();
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CodeQuarkusExtension that = (CodeQuarkusExtension) o;
        return providesExampleCode == that.providesExampleCode && providesCode == that.providesCode && order == that.order
               && platform == that.platform && Objects.equals(id, that.id) && Objects.equals(shortId,
                that.shortId) && Objects.equals(version, that.version) && Objects.equals(name, that.name)
               && Objects.equals(description, that.description) && Objects.equals(shortName, that.shortName)
               && Objects.equals(category, that.category) && Objects.equals(tags, that.tags)
               && Objects.equals(keywords, that.keywords) && Objects.equals(guide, that.guide)
               && Objects.equals(bom, that.bom);
    }

    @Override public int hashCode() {
        return Objects.hash(id, shortId, version, name, description, shortName, category, tags, keywords, providesExampleCode,
                providesCode, guide, order, platform, bom);
    }

    public static class Builder {
        private String id;
        private String shortId;
        private String version;
        private String name;
        private String description;
        private String shortName = "";
        private String category;
        private List<String> tags;
        private Set<String> keywords;
        private boolean providesExampleCode;
        private boolean providesCode;
        private String guide;
        private int order;
        private boolean platform;
        private String bom;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder shortId(String shortId) {
            this.shortId = shortId;
            return this;
        }

        public Builder version(String version) {
            this.version = version;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder shortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder keywords(Set<String> keywords) {
            this.keywords = keywords;
            return this;
        }

        public Builder providesExampleCode(boolean providesExampleCode) {
            this.providesExampleCode = providesExampleCode;
            return this;
        }

        public Builder providesCode(boolean providesCode) {
            this.providesCode = providesCode;
            return this;
        }

        public Builder guide(String guide) {
            this.guide = guide;
            return this;
        }

        public Builder order(int order) {
            this.order = order;
            return this;
        }

        public Builder platform(boolean platform) {
            this.platform = platform;
            return this;
        }

        public Builder bom(String bom) {
            this.bom = bom;
            return this;
        }

        public CodeQuarkusExtension build() {
            return new CodeQuarkusExtension(
                id,
                shortId,
                version,
                name,
                description,
                shortName,
                category,
                tags,
                keywords,
                providesExampleCode,
                providesCode,
                guide,
                order,
                platform,
                bom
            );
        }
    }
}
