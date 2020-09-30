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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        session = sessionRepository.findByNameOfPresentationAndPresenter(request.getSessionName(),request.getSessionPresenter()).get(0);
        attendee = attendeeRepository.findByNameAndCompany(request.getAttendeeName(),request.getAttendeeCompany()).get(0);
        AttendeeSession attendeeSession = new AttendeeSession(attendee,session);
        attendeeSessionRepository.save(attendeeSession);

    }

    @Override
    public List<AttendeeSession> getSessionAttendees(String nameOfPresentation){

        List <AttendeeSession> list;
        list = attendeeSessionRepository.findAll();
        List <AttendeeSession> results = list.stream()
                .filter(a -> a.getSession().getNameOfPresentation().equals(nameOfPresentation))
                .collect(Collectors.toList());
        System.out.println("Print Value:                " + list.get(0).getSession().getNameOfPresentation());
        return results;
    }

    @Override
    public List<Session> getAttendeeSchedule(String name){

        List <AttendeeSession> list;
        list = attendeeSessionRepository.findAttendeeSessionsByAttendee_Name(name);
        List <Session> sessionlist = new ArrayList<>();

        for(AttendeeSession object : list){
            Session temp = object.getSession();
            sessionlist.add(temp);
        }
        return sessionlist;
    }


}
