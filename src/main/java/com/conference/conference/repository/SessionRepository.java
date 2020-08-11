package com.conference.conference.repository;

import com.conference.conference.entity.Attendee;
import com.conference.conference.entity.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Long> {
    List<Session> findByNameAndPresenter(String name, String presenter);

}
