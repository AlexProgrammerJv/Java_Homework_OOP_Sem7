package View;

import Model.Event.Event;
import Presenter.Presenter;

import java.util.Scanner;

public class Console {
    Presenter presenter;
    Scanner scanner;
    boolean exit;

    public Console() {
        this.presenter = new Presenter();
        this.exit = true;
    }

    public void start() {
        while (exit) {
            System.out.println("Здравствуйте! Вы открыли записную книжку, выбирите действие: \n" +
                    "1. Добавить запись \n" +
                    "2. Вывести все записи \n" +
                    "3. Сохранить и загрузить в файл \n" +
                    "4. Сортировать по дате \n" +
                    "5. Найти запись на определенную дату \n" +
                    "6. Выйти из программы");
            scanner = new Scanner(System.in);
            String used = scanner.nextLine();
            switch (used) {
                case "1":
                    System.out.println("Введите дату");
                    System.out.println("Пример: Год/Месяц/День");
                    String date = scanner.nextLine();
                    System.out.println("Ввевдите время");
                    String time = scanner.nextLine();
                    System.out.println("Введите событие");
                    String event = scanner.nextLine();
                    presenter.addEvent(new Event(date, time, event));
                    scanner.nextLine();
                    break;
                case "2":
                    presenter.printEvents();
                    break;
                case "3":
                    System.out.println("Введите дату");
                    System.out.println("Пример: Год/Месяц/День");
                    String dateInFile = scanner.nextLine();
                    System.out.println("Ввевдите время");
                    String timeInFile = scanner.nextLine();
                    System.out.println("Введите событие");
                    String eventInFile = scanner.nextLine();
                    System.out.println("Введите название файла \n " +
                                       "Пример: Event.txt");
                    String nameFile = scanner.nextLine();
                    presenter.saveInFile(new Event(dateInFile, timeInFile, eventInFile), nameFile);
                    scanner.nextLine();
                    break;
                case "4":
                    presenter.sortByDate();
                    presenter.printEvents();
                    break;
                case "5":
                    System.out.println("Введите начало периода");
                    System.out.println("Пример: Год/Месяц/День");
                    String startDate = scanner.nextLine();
                    System.out.println("Введите конец периода");
                    System.out.println("Пример: Год/Месяц/День");
                    String finishDate = scanner.nextLine();
                    presenter.printEventsInRangeDate(startDate, finishDate);
                    break;
                case "6":
                    exit = false;
                    break;
                default:
                    System.out.println("Неккоректный ввод данных! Повторите снова!");
                    break;
            }
        }
    }
}
