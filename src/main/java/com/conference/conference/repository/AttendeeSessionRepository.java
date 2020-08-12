package com.conference.conference.repository;

import com.conference.conference.entity.AttendeeSession;
import org.springframework.data.repository.CrudRepository;

public interface AttendeeSessionRepository extends CrudRepository<AttendeeSession, Long> {
}
