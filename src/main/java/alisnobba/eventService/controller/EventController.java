package alisnobba.eventService.controller;

import alisnobba.eventService.model.Event;
import alisnobba.eventService.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EventController {
    EventService eventService;
    public EventController(EventService eventService){
        this.eventService=eventService;
    }

    @PostMapping("/events")
    public void saveEvent(Event event){
        eventService.save(event);
    }

    @GetMapping("/events/all")
    public List<Event> getAllEvents(){
        return eventService.findAll();
    }

    @GetMapping("/events/user/{userId")
    public List<Event> getEventByUserId(@PathVariable String userId){
        return eventService.findByUserId(userId);
    }

}
