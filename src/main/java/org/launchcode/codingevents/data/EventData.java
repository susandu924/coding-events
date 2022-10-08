package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

//    need a place to put events. static class! encapsulation,
//    behavior of storing event objects by creating event data class, uses eventdata vs using static list
    private static final Map<Integer, Event> events = new HashMap<>();
//    final means it cant change, data can change but map itself cant change
//    map is interface that allows store things as key:value pairs map object store integer, event pairs.
//    retrieve an event object just using its is
//    code to interface types whenever possible

//    get all events
    public static Collection<Event> getAll(){
        return events.values();
//        collection is an interface extends the Iterable<E> looping over our collection. if .values returned a list, will loop.
    }
//    get a single event
    public static Event getById(int id)
    {
        return events.get(id);
    }//    add an event
    public static void add(Event event){
        events.put(event.getId(), event);
    }
//    remove an event
    public static void remove(int id){
        events.remove(id);
//        extracts a single id from the events map
    }


}
