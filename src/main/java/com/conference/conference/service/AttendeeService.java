package com.conference.conference.service;

import com.conference.conference.entity.Attendee;
import org.springframework.stereotype.Service;

@Service
public interface AttendeeService {
    public Attendee registerAttendee(Attendee attendee);
}
