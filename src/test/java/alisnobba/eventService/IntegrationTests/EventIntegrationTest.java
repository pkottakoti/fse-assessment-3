package alisnobba.eventService.IntegrationTests;

import alisnobba.eventService.TestUtils.TestEvents;
import alisnobba.eventService.model.Event;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class EventIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp(){


        //act
        restTemplate.postForEntity("/events", TestEvents.getEvents().get(0),String.class);
        restTemplate.postForEntity("/events", TestEvents.getEvents().get(1),String.class);
        restTemplate.postForEntity("/events", TestEvents.getEvents().get(2),String.class);
        restTemplate.postForEntity("/events", TestEvents.getEvents().get(3),String.class);
        restTemplate.postForEntity("/events", TestEvents.getEvents().get(4),String.class);
    }

    @After
    public void tearDown(){

    }

    @Test
    public void postingEvent_savesTheEvent() throws JsonProcessingException {
        //act
        ResponseEntity<String> response = restTemplate.postForEntity("/events", TestEvents.getEvents().get(0),String.class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("saved");
    }

    @Test
    public void searchForEventByUserId_returnsEventsWithMatchingUserIds() throws Exception {

        //act
        ResponseEntity<Event[]> response = restTemplate.getForEntity("/events/user/1b468f7d-79e8-40c1-80a2-0dd7226e7775", Event[].class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        for (Event event : response.getBody()) {
            assertThat(event.getUserId()).contains("1b468f7d-79e8-40c1-80a2-0dd7226e7775");
        }
    }
    @Test
    public void searchForEventofAll_returnsAllEvents() throws Exception {

        //act
        ResponseEntity<Event[]> response = restTemplate.getForEntity("/events/all", Event[].class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        int i=0;
        for (Event event : response.getBody()) {
            assertThat(event.getUserId()).contains(TestEvents.getEvents().get(i).getUserId());
            i=i+1;
        }
    }


}




