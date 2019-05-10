package alisnobba.eventService.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.sql.Date;


//{
//        type: 'promotion-viewed', // i.e., the user clicked on a "house ad" (an internal ad) on the site
//        userId: '1b468f7d-79e8-40c1-80a2-0dd7226e7771', // let's assume this system uses GUIDs
//        timestamp: 1544401072, // unix epoch time
//        context: 'homepage.topnav', // which view did this event take place in?
//        }

public class Event implements Serializable {
    @Id
    private String id;
    private String type;
    private String userId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    private String context;
    public Event(String id, String type, String userId, Date date, String context) {
        this.id = id;
        this.type = type;
        this.userId = userId;
        this.date = date;
        this.context = context;
    }
    public Event(String type, String userId, Date date, String context) {
        this.type = type;
        this.userId = userId;
        this.date = date;
        this.context = context;
    }
    public Event(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

}

