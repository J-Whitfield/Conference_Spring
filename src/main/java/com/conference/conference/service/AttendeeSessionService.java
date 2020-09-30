package com.conference.conference.service;

import com.conference.conference.DTO.AddAttendeeRequest;
import com.conference.conference.entity.AttendeeSession;
import com.conference.conference.entity.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendeeSessionService {
    public void addAttendeeToSession(AddAttendeeRequest request);
    public List<AttendeeSession> getSessionAttendees(String nameOfPresentation);
    public List<Session> getAttendeeSchedule(String name);
    }
