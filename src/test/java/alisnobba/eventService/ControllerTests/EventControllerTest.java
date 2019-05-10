package alisnobba.eventService.ControllerTests;

import alisnobba.eventService.TestUtils.TestEvents;
import alisnobba.eventService.controller.EventController;
import alisnobba.eventService.model.Event;
import alisnobba.eventService.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
public class EventControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void postingProduct_savesTheProduct() throws Exception{
        Event event = TestEvents.getEvents().get(0);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(event));
        mockMvc.perform(builder).andExpect(status().isOk());
        verify(eventService, times(1)).save(any(Event.class));
    }




    @Test
    public void findEventByUserId_returnsEventsWithThatUserId() throws Exception {
        //arrange
        List<Event> events = new ArrayList<>();

        events.add(TestEvents.getEvents().get(0));
        events.add(TestEvents.getEvents().get(1));

        when(eventService.findByUserId("1b468f7d-79e8-40c1-80a2-0dd7226e7771")).thenReturn(events);

        mockMvc.perform(MockMvcRequestBuilders.get("/events/user/1b468f7d-79e8-40c1-80a2-0dd7226e7771"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].userId", is("1b468f7d-79e8-40c1-80a2-0dd7226e7771")))
                .andExpect(jsonPath("$[1].userId", is("1b468f7d-79e8-40c1-80a2-0dd7226e7771")));


        verify(eventService, times(1)).findByUserId("1b468f7d-79e8-40c1-80a2-0dd7226e7771");
        verifyNoMoreInteractions(eventService);
    }

    public static List<Event> getEvents(){
        List<Event> events = new ArrayList<Event>();
        events.add(new Event("promotion-viewed","1b468f7d-79e8-40c1-80a2-0dd7226e7771",1544401072,"homepage.topnav"));
        events.add(new Event("promotion-saved","1b468f7d-79e8-40c1-80a2-0dd7226e7771",1544401072,"homepage.topnav"));
        events.add(new Event("promotion-viewed","1b468f7d-79e8-40c1-80a2-0dd7226e7773",1544401072,"homepage.topnav"));
        events.add(new Event("promotion-viewed","1b468f7d-79e8-40c1-80a2-0dd7226e7774",1544401072,"homepage.topnav"));
        events.add(new Event("promotion-viewed","1b468f7d-79e8-40c1-80a2-0dd7226e7775",1544401072,"homepage.topnav"));
        return events;
    }

    @Test
    public void findEventAll_returnsEventsAll() throws Exception {
        //arrange
        List<Event> events = new ArrayList<>();

        events.add(TestEvents.getEvents().get(0));
        events.add(TestEvents.getEvents().get(1));
        events.add(TestEvents.getEvents().get(2));
        events.add(TestEvents.getEvents().get(3));
        events.add(TestEvents.getEvents().get(4));


        when(eventService.findAll()).thenReturn(events);

        mockMvc.perform(MockMvcRequestBuilders.get("/events/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)));


        verify(eventService, times(1)).findAll();
        verifyNoMoreInteractions(eventService);
    }
}
