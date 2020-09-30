package com.conference.conference.repository;

import com.conference.conference.entity.Attendee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AttendeeRepository extends CrudRepository<Attendee, Long> {

    List<Attendee> findByNameAndCompany(String name, String company);
}
