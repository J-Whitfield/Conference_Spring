package com.conference.conference.repository;

import com.conference.conference.entity.Attendee;
import com.conference.conference.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
    List<Session> findByNameOfPresentationAndPresenter(String nameOfPresentation, String presenter);

}
