package Model.Event;

import Model.Comporator.CompareByDate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventsPlanner implements Iterable<Event>{

    List<Event> eventsList;

    public EventsPlanner() {
        this.eventsList = new ArrayList<>();
    }

    public List<Event> getEventsList() {
        return new ArrayList<>(eventsList);
    }

    public void addEvent(Event event){
        eventsList.add(event);
    }

    @Override
    public Iterator<Event> iterator() {
        return new Model.Iterator.Iterator(eventsList);
    }

    public void sortByDate(){
        eventsList.sort(new CompareByDate());
    }
}
