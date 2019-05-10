package alisnobba.eventService.TestUtils;

import alisnobba.eventService.model.Event;

import java.util.ArrayList;
import java.util.List;

public class TestEvents {


    public static List<Event> getEvents(){
        List<Event> events = new ArrayList<Event>();
        events.add(new Event("promotion-viewed","1b468f7d-79e8-40c1-80a2-0dd7226e7771",1544401072,"homepage.topnav"));
        events.add(new Event("promotion-saved","1b468f7d-79e8-40c1-80a2-0dd7226e7771",1544401072,"homepage.topnav"));
        events.add(new Event("promotion-viewed","1b468f7d-79e8-40c1-80a2-0dd7226e7773",1544401072,"homepage.topnav"));
        events.add(new Event("promotion-viewed","1b468f7d-79e8-40c1-80a2-0dd7226e7774",1544401072,"homepage.topnav"));
        events.add(new Event("promotion-viewed","1b468f7d-79e8-40c1-80a2-0dd7226e7775",1544401072,"homepage.topnav"));
        return events;
    }
}
//{
//        type: 'promotion-viewed', // i.e., the user clicked on a "house ad" (an internal ad) on the site
//        userId: '1b468f7d-79e8-40c1-80a2-0dd7226e7771', // let's assume this system uses GUIDs
//        timestamp: 1544401072, // unix epoch time "yyyy-MM-dd HH:mm:ss"
//        context: 'homepage.topnav', // which view did this event take place in?
//        }
