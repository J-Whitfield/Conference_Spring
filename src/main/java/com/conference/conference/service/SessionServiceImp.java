package com.conference.conference.service;

import com.conference.conference.DTO.AddAttendeeRequest;
import com.conference.conference.entity.Attendee;
import com.conference.conference.entity.Session;
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

    @Autowired
    private AttendeeRepository attendeeRepository;

    private SecureRandom random = new SecureRandom();

    @Override
    public Session createSession(Session session){
        String attendeeId = UUID.randomUUID().toString();
        session.setId(attendeeId);
        sessionRepository.save(session);
        return session;
    }

    @Override
    public void addAttendeeToSession(AddAttendeeRequest request){
        Session session = new Session();
        Attendee attendee = new Attendee();
        session = sessionRepository.findByNameAndPresenter(request.getSessionName(),request.getSessionPresenter()).get(0);
        System.out.println(request.getAttendeeName());
        System.out.println(request.getAttendeeCompany());
        attendee = attendeeRepository.findByNameAndCompany(request.getAttendeeName(),request.getAttendeeCompany()).get(0);
        session.attendeeList.add(attendee);
        attendee.sessions.add(session);
        sessionRepository.save(session);

    }
}