package alisnobba.eventService.service;

import alisnobba.eventService.model.Event;
import alisnobba.eventService.repository.EventRepository;

import java.util.List;

public class EventService {

    EventRepository eventRepository;

    EventService(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }


    public void save(Event event){
        eventRepository.save(event);

    }

    public List<Event> findByUserId(String userId){
        return  eventRepository.findByUserId(userId);
    }

    public List<Event> findAll(){
        return eventRepository.findAll();
    }


}
//## Stories
//        - As an end-user (i.e., using the web reservation app), my user actions are reported in the background.
//        - As a reporting user, I can request a list of user events (for all users) that took place within a given timeframe.
//        - As a reporting user, I can request a list of all user events for a single user, specified by their user id.