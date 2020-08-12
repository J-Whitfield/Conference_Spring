package com.conference.conference.entity;

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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendee_id")
    Attendee attendee;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    Session session;


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
