package com.conference.conference.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class AttendeeSession implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="attendee_session_id")
    private String id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="attendant_id", referencedColumnName="attendee_id"),
            @JoinColumn(name="attendant_name", referencedColumnName="attendee_name")
    })
    Attendee attendee;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="session_tracking_id", referencedColumnName="session_id"),
            @JoinColumn(name="name", referencedColumnName="presentation_name")
    })
    Session session;

    @JsonIgnore
    private boolean isPresenter;

    public AttendeeSession() {
    }

    public AttendeeSession(Attendee attendee, Session session) {
        this.session = session;
        this.attendee = attendee;
    }

    public Attendee getAttendee() {
        return attendee;
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
