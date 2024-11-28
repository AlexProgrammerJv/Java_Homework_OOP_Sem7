package Model.Comporator;

import Model.Event.Event;

import java.util.Comparator;

public class CompareByDate implements Comparator<Event> {

    @Override
    public int compare(Event o1, Event o2) {
        return o1.getLocalDate().compareTo(o2.getLocalDate());
    }
}
