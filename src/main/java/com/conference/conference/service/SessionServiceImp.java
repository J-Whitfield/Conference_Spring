package com.conference.conference.service;

import com.conference.conference.DTO.AddAttendeeRequest;
import com.conference.conference.entity.Attendee;
import com.conference.conference.entity.AttendeeSession;
import com.conference.conference.entity.Session;
import com.conference.conference.repository.AttendeeSessionRepository;
import com.conference.conference.repository.SessionRepository;
import com.conference.conference.repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.UUID;

@Service
public class SessionServiceImp implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;


    private SecureRandom random = new SecureRandom();

    @Override
    public Session createSession(Session session){
        String attendeeId = UUID.randomUUID().toString();
        session.setId(attendeeId);
        sessionRepository.save(session);
        return session;
    }
}