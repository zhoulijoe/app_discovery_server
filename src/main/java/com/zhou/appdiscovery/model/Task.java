package com.zhou.appdiscovery.model;

import org.springframework.data.annotation.Id;

public class Task {

    @Id
    private String id;

    private String summary;

    public Task(String summary) {
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
