package alisnobba.eventService.RepositoryTests;

import alisnobba.eventService.TestUtils.TestEvents;
import alisnobba.eventService.model.Event;
import alisnobba.eventService.repository.EventRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private EventRepository eventRepository;

    TestEvents testEvents;

    @Test
    public void repoSavesInDB() throws Exception {
        Event event = TestEvents.getEvents().get(0);

        String id = testEntityManager.persistAndGetId(event, String.class);
        Event foundEvent = eventRepository.findById(id).orElse(null);
        assertThat(foundEvent.getUserId()).isEqualTo(event.getUserId());
    }

    @Test
    public void findEventByUserId_returnsWithThatUserId(){
        String userId="1b468f7d-79e8-40c1-80a2-0dd7226e7771";

        int size = eventRepository.findByUserId(userId).size();
        assertThat(size==2);

    }
    @Test
    public void findEventAll_returnAll(){

        int size = eventRepository.findAll().size();
        assertThat(size==5);

    }
}

