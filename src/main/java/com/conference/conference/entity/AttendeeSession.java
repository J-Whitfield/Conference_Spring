package com.conference.conference.entity;

import javax.persistence.*;

@Entity
@IdClass(AttendeeSessionId.class)
public class AttendeeSession {
    @Id
    @Column(name="attendee_id")
    private long attendeeId;
    @Id
    @Column(name="session_id")
    private long SessionId;
    @Column("IS_PRESENTER")
    private boolean isPresenter;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="attendee_id", referencedColumnName="attendee_id")
    private Employee employee;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="session_id", referencedColumnName="session_id")
    private Project project;
}
