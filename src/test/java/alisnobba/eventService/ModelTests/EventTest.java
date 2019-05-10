package alisnobba.eventService.ModelTests;
import alisnobba.eventService.model.Event;

import org.junit.Test;

import java.time.Duration;

public class EventTest {
    @Test
    public void getPrettyDurationTest() {
        Event myEvent = new Event("promotion-viewed", "1b468f7d-79e8-40c1-80a2-0dd7226e7771", 1544401072, "homepage.topnav");
        String result = myEvent.getUserId();
        String expectedResult = "1b468f7d-79e8-40c1-80a2-0dd7226e7771";
        junit.framework.Assert.assertEquals("user id is saved to databse", result, expectedResult);
    }
}



