package edu.usyd.medivise.dao;

import java.util.List;

import edu.usyd.medivise.domain.Event;

public interface EventDao {
	
	 void insertEvent(Event event);
	    void createEventTable();
	    void dropEventTable();
	    boolean eventsExists(String username);
	    int countEvents();
	    boolean eventsExists();
	    boolean hasEvent(String eventname, String username, String creator);
	    List<Event> selectRecentEvent(String username);
	    List<Event> selectAllEvent(String username);
	    List<Event> selectAllEvents();
	    Event getEventById(int id);

}
