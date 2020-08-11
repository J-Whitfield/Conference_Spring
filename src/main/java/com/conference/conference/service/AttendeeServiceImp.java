package com.conference.conference.service;

import com.conference.conference.entity.Attendee;
import com.conference.conference.repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

@Service
public class AttendeeServiceImp implements AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    private SecureRandom random = new SecureRandom();

    @Override
    public Attendee registerAttendee(Attendee attendee){
        String attendeeId = UUID.randomUUID().toString();
        attendee.setId(attendeeId);
        attendeeRepository.save(attendee);
        return attendee;
    }
}
