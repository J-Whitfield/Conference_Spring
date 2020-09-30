package com.conference.conference.repository;

import com.conference.conference.entity.Attendee;
import com.conference.conference.entity.AttendeeSession;
import com.conference.conference.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendeeSessionRepository extends CrudRepository<AttendeeSession, Long> {
    List<AttendeeSession> findAll();
    List<AttendeeSession> findAttendeeSessionsByAttendee_Name(String name);

}
