package com.conference.conference.repository;

import com.conference.conference.entity.Attendee;
import com.conference.conference.entity.AttendeeSession;
import com.conference.conference.entity.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttendeeSessionRepository extends CrudRepository<AttendeeSession, Long> {
    List<AttendeeSession> findAll();

}
