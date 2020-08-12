package com.conference.conference.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Session implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="session_id")
    private String id;

    @Column(name = "presenter", nullable = false)
    private String presenter;

    @JsonIgnore
    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<AttendeeSession> attendeeSessions;

    @Column(length = 2000)
    private String location;

    private String time;


    @Column(name = "presentation_name", nullable = false)
    private String nameOfPresentation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNameOfPresentation() {
        return nameOfPresentation;
    }

    public void setNameOfPresentation(String nameOfPresentation) {
        this.nameOfPresentation = nameOfPresentation;
    }
}
