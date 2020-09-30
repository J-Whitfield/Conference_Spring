package com.conference.conference.web;

import com.conference.conference.entity.Attendee;
import com.conference.conference.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK, classes={Controller.class})
public class ControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    AttendeeServiceImp attendeeService;

    @MockBean
    SessionServiceImp sessionService;

    @MockBean
    AttendeeSessionServiceImp attendeesessionService;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void registerAttendee() throws Exception {
        String payload = "{ \"name\":\"jay\",  \"company\":\"c1\",  \"title\":\"engineer\" }";
        mockMvc.perform(post("/app/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(payload));
    }

    @Test
    public void createSession() throws Exception {
        String payload = "{ \"presenter\":\"stacey\",  \"location\":\"philly\",  \"time\":\"11\", \"nameOfPresentation\":\"South\" }";
        mockMvc.perform(post("/app/createSession")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(payload));
    }

    @Test
    public void addAttendee() throws Exception {
        String payload = "{ \"sessionPresenter\":\"stacey\",  \"sessionName\":\"philly\",  \"attendeeName\":\"11\", \"attendeeCompany\":\"C1\" }";
        mockMvc.perform(post("/app/addAttendee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(payload));
    }

    @Test
    public void getSessionAttendess() throws Exception {
        mockMvc.perform(get("/app/sessionAttendees/{id}","north")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void attendeeSchedule() throws Exception {
        mockMvc.perform(get("/app/attendeeSchedule/{id}","north")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
