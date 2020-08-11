package com.conference.conference.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Attendee {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="attendee_id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "User_Sessions",
            joinColumns = { @JoinColumn(name = "attendee_id") },
            inverseJoinColumns = { @JoinColumn(name = "session_id") }
    )
    @Column(name="name")
    public Set<Session> sessions;

    @Column(length = 2000)
    private String title;
    private String company;

    public Attendee() {
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

    public Set<Session> getSessionList() {
        return sessions;
    }

    public void setSessionList(Set<Session> sessionList) {
        this.sessions = sessions;
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
}
