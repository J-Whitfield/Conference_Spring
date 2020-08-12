package com.conference.conference.service;

import com.conference.conference.DTO.AddAttendeeRequest;
import com.conference.conference.entity.AttendeeSession;

import java.util.List;

public interface AttendeeSessionService {
    public void addAttendeeToSession(AddAttendeeRequest request);
    public List<AttendeeSession> getSessionAttendees(String nameOfPresentation);
    }
