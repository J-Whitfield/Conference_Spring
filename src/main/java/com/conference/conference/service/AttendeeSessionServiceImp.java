package com.conference.conference.service;

import com.conference.conference.DTO.AddAttendeeRequest;
import com.conference.conference.entity.Attendee;
import com.conference.conference.entity.AttendeeSession;
import com.conference.conference.entity.Session;
import com.conference.conference.repository.AttendeeRepository;
import com.conference.conference.repository.AttendeeSessionRepository;
import com.conference.conference.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendeeSessionServiceImp implements AttendeeSessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private AttendeeRepository attendeeRepository;

    @Autowired
    private AttendeeSessionRepository attendeeSessionRepository;

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
        //attendee.attendeeSessions.add(new AttendeeSession(session));
        AttendeeSession attendeeSession = new AttendeeSession(attendee,session);
        attendeeSessionRepository.save(attendeeSession);
        // attendeeRepository.save(new Attendee(attendee.getName(), attendee.getTitle(), attendee.getCompany(), new AttendeeSession(session)));
        // sessionRepository.save(session);

    }
}
