package com.conference.conference.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Session {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "presenter", nullable = false)
    private String presenter;

    @ManyToMany(mappedBy="sessions")
    public Set<Attendee> attendeeList;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    Set<AttendeeSession> attendeeSessions;

    @Column(length = 2000)
    private String location;
    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

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

    public Set<Attendee> getAttendeeList() {
        return attendeeList;
    }

    public void setAttendeeList(Set<Attendee> attendeeList) {
        this.attendeeList = attendeeList;
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
}
