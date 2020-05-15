package com.telstra.codechallenge.git;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
@JsonIgnoreProperties(ignoreUnknown = true)

public class model {
    private Long watchers_count;
    private String html_url;
    private String language;
    private String description;
    private String name;

    @Autowired
    public model() {

    }

    public model(Long watchers_count, String html_url, String language, String description, String name) {
        this.watchers_count = watchers_count;
        this.html_url = html_url;
        this.language = language;
        this.description = description;
        this.name = name;
    }

    public Long getWatchers_count() {
        return watchers_count;
    }

    public void setWatchers_count(Long watchers_count) {
        this.watchers_count = watchers_count;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        model model = (model) o;
        return Objects.equals(watchers_count, model.watchers_count) &&
                Objects.equals(html_url, model.html_url) &&
                Objects.equals(language, model.language) &&
                Objects.equals(description, model.description) &&
                Objects.equals(name, model.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(watchers_count, html_url, language, description, name);
    }

    @Override
    public String toString() {
        return "model{" +
                "watchers_count=" + watchers_count +
                ", html_url='" + html_url + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }









}
