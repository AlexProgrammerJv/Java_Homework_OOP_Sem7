package Model.Event;

import java.io.*;
import java.util.Date;

public class EventFunctional {

    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    EventsPlanner eventsPlanner;
    Date date;

    public EventFunctional() {
        this.eventsPlanner = new EventsPlanner();
    }

    public void addEvent(Event event){
         eventsPlanner.addEvent(event);
    }

    public String printEvents(){
        StringBuilder listEvents = new StringBuilder();
        listEvents.append("Список всех мероприятий:");
        for (Event event : eventsPlanner) {
            listEvents.append("\n" + event);
        }
        return listEvents.toString();
    }

    public void sortByDate(){
        eventsPlanner.sortByDate();
    }

    public void saveInFile(Event event, String nameFile)  {
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(nameFile));
            objectOutputStream.writeObject(event);
            objectOutputStream.close();
            System.out.println("Файл загружен!");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка, файл не загружен!");
        }
    }

    public Event loadAFile(String nameFile){
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(nameFile));
            Event eventRestored = (Event) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Файл восстановлен!");
            return eventRestored;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Ошибка, файл не заргужен!");
        }
    }

    public String printEventsInRangeDate(String startDate,String finishDate){
        this.sortByDate();
        Date minRange = new Date(startDate);
        Date maxRange = new Date(finishDate);
        StringBuilder printRangeDate = new StringBuilder();
        printRangeDate.append("Список событий в диапазоне от "+ startDate + " до" + finishDate);
        for (Event event : eventsPlanner) {
            if(event.getLocalDate().getTime() >= minRange.getTime() &&
               event.getLocalDate().getTime() <= maxRange.getTime() ){
                printRangeDate.append("\n" + event);
            }
        }
        return printRangeDate.toString();
    }
}
