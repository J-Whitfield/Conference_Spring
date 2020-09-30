package com.conference.conference.service;

import com.conference.conference.DTO.AddAttendeeRequest;
import com.conference.conference.entity.Attendee;
import com.conference.conference.entity.Session;
import org.springframework.stereotype.Service;

@Service
public interface SessionService {
    public Session createSession(Session session);
}
