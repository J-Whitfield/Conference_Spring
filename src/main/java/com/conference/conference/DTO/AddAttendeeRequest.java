package com.conference.conference.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAttendeeRequest {
    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionPresenter() {
        return sessionPresenter;
    }

    public void setSessionPresenter(String sessionPresenter) {
        this.sessionPresenter = sessionPresenter;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public String getAttendeeCompany() {
        return attendeeCompany;
    }

    public void setAttendeeCompany(String attendeeCompany) {
        this.attendeeCompany = attendeeCompany;
    }
    @JsonProperty("sessionName")
    private String sessionName;
    @JsonProperty("sessionPresenter")
    private String sessionPresenter;
    @JsonProperty("attendeeName")
    private String attendeeName;
    @JsonProperty("attendeeCompany")
    private String attendeeCompany;


}
