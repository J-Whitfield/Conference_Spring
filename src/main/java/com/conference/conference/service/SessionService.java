package com.conference.conference.service;

import com.conference.conference.DTO.AddAttendeeRequest;
import com.conference.conference.entity.Attendee;
import com.conference.conference.entity.Session;

public interface SessionService {
    public Session createSession(Session session);
    public void addAttendeeToSession(AddAttendeeRequest request);
}
