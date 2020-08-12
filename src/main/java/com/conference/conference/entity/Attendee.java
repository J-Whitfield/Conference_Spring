package com.conference.conference.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Attendee implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="attendee_id")
    private String id;

    @Column(name = "attendee_name", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "attendee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<AttendeeSession> attendeeSessions;

    @Column(length = 2000)
    private String title;
    private String company;

    public Attendee() {
    }

    public Attendee(String name, String title,
                    String company, AttendeeSession... attendeeSessions) {
        this.name = name;
        for(AttendeeSession attendeeSession : attendeeSessions) attendeeSession.setAttendee(this);
        this.attendeeSessions = Stream.of(attendeeSessions).collect(Collectors.toSet());
    }

    public Attendee(AttendeeSession... attendeeSessions) {
        for(AttendeeSession attendeeSession : attendeeSessions) attendeeSession.setAttendee(this);
        this.attendeeSessions = Stream.of(attendeeSessions).collect(Collectors.toSet());
    }

    public Attendee(String name, String title,
                       String company) {
        this.name = name;
        this.title = title;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Set<AttendeeSession> getAttendeeSessions() {
        return attendeeSessions;
    }

    public void setAttendeeSessions(Set<AttendeeSession> attendeeSessions) {
        this.attendeeSessions = attendeeSessions;
    }
}
