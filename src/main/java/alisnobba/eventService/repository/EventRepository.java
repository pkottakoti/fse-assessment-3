package alisnobba.eventService.repository;

import alisnobba.eventService.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface EventRepository extends MongoRepository<Event,String> {
   List<Event> findAll();
   List<Event> findByUserId(String userId);


}
//## Stories
//        - As an end-user (i.e., using the web reservation app), my user actions are reported in the background.
//        - As a reporting user, I can request a list of user events (for all users) that took place within a given timeframe.
//        - As a reporting user, I can request a list of all user events for a single user, specified by their user id.



