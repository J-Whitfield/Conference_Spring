package com.conference.conference.web;

import com.conference.conference.DTO.AddAttendeeRequest;
import com.conference.conference.entity.Attendee;
import com.conference.conference.entity.Session;
import com.conference.conference.service.AttendeeServiceImp;
import com.conference.conference.service.SessionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@RequestMapping("/app")
public class Controller {

    @Autowired
    private AttendeeServiceImp attendeeServiceImp;

    @Autowired
    private SessionServiceImp sessionServiceImp;

    @PostMapping(path= "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Attendee registerAttendee(@RequestBody Attendee attendee){
        attendeeServiceImp.registerAttendee(attendee);
        return attendee;
    }

    @PostMapping(path= "/createSession", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Session registerAttendee(@RequestBody Session session){
        sessionServiceImp.createSession(session);
        return session;
    }

    @PostMapping(path= "/addAttendee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AddAttendeeRequest addAttendee(@RequestBody AddAttendeeRequest request){
        sessionServiceImp.addAttendeeToSession(request);
        return request;
    }

}
