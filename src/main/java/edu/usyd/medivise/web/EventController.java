package edu.usyd.medivise.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.usyd.medivise.dao.EventDao;
import edu.usyd.medivise.domain.Event;


@Controller
@RequestMapping(value = "userEvents")
public class EventController {
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppContext.xml");
    private static String username;
    String userPage = "/userPersonal";
    
    /************************************************************************
     * Title: userHome
     * Views the user's home page
     ***********************************************************************/
    @RequestMapping(value = {"","/"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String userHome(Map<String, List> model, HttpSession session) {
        if (session.getAttribute("username") == null) // Kick user to home page if not logged in
            return "redirect:/home";

        EventDao eventDao = (EventDao) context.getBean("eventDao");
        if (eventDao.eventsExists(session.getAttribute("username").toString()) == false) model.put("events", null);
        else {
            List<Event> events = eventDao.selectAllEvent(session.getAttribute("username").toString());

            // Logic for recent events //
            List<Event> recentEvents = new ArrayList<>();

            int iterator = 0;
            Date todays_date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH,3);
            Date beyond_date = cal.getTime();
            for(Event e:events){
                Date eventDate = e.getEventDate();
                if(eventDate.after(todays_date) && eventDate.before(beyond_date))
                    recentEvents.add(events.get(iterator));
                iterator++;
            }
            model.put("events", recentEvents);
        }
        return userPage;
    }
    
    /************************************************************************
     * Title: likedEvent
     * Handles the liked events
     ***********************************************************************/
    @RequestMapping(value = "likedEvent")
    public String likedEvent(HttpSession session, @RequestParam("it") String it){
        int id = Integer.parseInt(it); // Parsed from HTML form
        String username = session.getAttribute("username").toString();
        List<Event> event = (List<Event>) session.getAttribute("eventsList");
        EventDao eventDao = (EventDao) context.getBean("eventDao");
        try {
            Event eventSelected = eventDao.getEventById(id);
            /*
            int eventID = event.get(id).getId();
            String eventName = event.get(id).getEventName();
            Date eventDate = event.get(id).getEventDate();
            String eventDescription = event.get(id).getEventDescription();
            String author = event.get(id).getEventAuthor();
            */
            
         // Create event object
            Event createdNewEvent = new Event(eventSelected.getId(), eventSelected.getEventName(), eventSelected.getEventDate(), eventSelected.getEventDescription(), username, eventSelected.getEventAuthor()); 
            
            // User doesn't have event, proceed with steps
            if(!eventDao.hasEvent(createdNewEvent.getEventName(), username, createdNewEvent.getEventAuthor())) {
                eventDao.insertEvent(createdNewEvent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database connection could not be established");
            return "databaseError";
        }

        return "redirect:/userEvents";
    }
    
    /************************************************************************
     * Title: createEvent -- GET and POST methods
     * Handles the creation of events
     ***********************************************************************/
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String createEvent(Map<String, Object> model, HttpSession session){
        if (session.getAttribute("username") == null) // Kick user to home page if not logged in
            return "redirect:/home";

        Event event = new Event();
        model.put("event", event);
        model.put("username", session.getAttribute("username"));
        return "createEvent";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String createEvent(@ModelAttribute("event") Event event, Map<String, String> model, HttpSession session){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppContext.xml"); // New AppContext pointing to xml config
        EventDao eventDao = (EventDao) context.getBean("eventDao"); // bean
        String username = session.getAttribute("username").toString();
        event.setEventAuthor(username);
        event.setUsername(username);
        // Check for event duplication and event name empty
        if (eventDao.hasEvent(event.getEventName(),event.getUsername(),event.getEventAuthor())) model.put("isDuplicate", "true");
        //else model.put("isDuplicate", "false");
        if (event.getEventName() == "") model.put("eNameEmpty", "true"); // Check if event name is empty
        //else model.put("eNameEmpty", "false");
        if(model.get("eNameEmpty") == "true" || model.get("isDuplicate") == "true")
            return "createEvent"; // return to same page with error if empty

        // Proceed if above conditions are met
        else {
            try { // catch occurs when HSQLDB is not established
                int id = eventDao.countEvents()+1;

                //formate the date but do they really formatted?
                Date eventDateFormatted = new Date();

                Event e = new Event(id, event.getEventName(), eventDateFormatted, event.getEventDescription(), event.getUsername(), event.getEventAuthor());
                eventDao.insertEvent(e);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Database connection could not be established");
                return "databaseError";
            }
        }

        return "redirect:/userEvents";
    }
    
}