package Presenter;

import Model.Event.Event;
import Model.Event.EventFunctional;

public class Presenter {

    EventFunctional eventFunctional;

    public Presenter() {
        eventFunctional = new EventFunctional();
    }

    public void addEvent(Event event){
        eventFunctional.addEvent(event);
        showInfo("Мероприятие добавлено!");
    }

    public void printEvents(){
        System.out.println(eventFunctional.printEvents());
    }

    public void saveInFile(Event event, String nameFile){
        this.addEvent(event);
        eventFunctional.saveInFile(event,nameFile);
    }

    public void sortByDate(){
        eventFunctional.sortByDate();
    }

    public void printEventsInRangeDate(String startDate,String finishDate){
        System.out.println(eventFunctional.printEventsInRangeDate(startDate,finishDate));
    }

    public void showInfo(String message){
        System.out.println(message);
    }

}

