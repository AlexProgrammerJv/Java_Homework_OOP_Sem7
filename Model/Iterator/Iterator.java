package Model.Iterator;

import Model.Event.Event;

import java.util.List;

public class Iterator implements java.util.Iterator<Event> {

    List<Event> eventsList;
    int count;

    public Iterator(List<Event> eventsList) {
        this.eventsList = eventsList;
        this.count = 0;
    }

    public boolean hasNext(){
        return count < eventsList.size();
    }

    public Event next(){
        return eventsList.get(count++);
    }

}
