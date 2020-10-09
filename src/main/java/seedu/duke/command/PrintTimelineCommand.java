package seedu.duke.command;

import seedu.duke.DukeException;
import seedu.duke.Storage;
import seedu.duke.calendar.CalendarItem;
import seedu.duke.calendar.CalendarList;
import seedu.duke.calendar.task.Task;
import seedu.duke.calendar.task.Todo;


public class PrintTimelineCommand extends Command {
    public PrintTimelineCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(CalendarList calendarList, Storage storage) throws DukeException {
        CalendarList taskList = new CalendarList();
        CalendarList eventList = new CalendarList();
        CalendarList todoList = new CalendarList();

        for (int i = 0; i < calendarList.getTotalItems(); i++) {
            CalendarItem temp = calendarList.getItem(i);
            if (temp instanceof Task) {
                if (temp instanceof Todo) {
                    todoList.addItem(temp);
                } else {
                    taskList.addItem(temp);
                }
            } else {
                eventList.addItem(temp);
            }

        }

        CalendarList sortedList = sortByDate(taskList);
        System.out.println("Here is your timeline:");
        int numberOfItems = sortedList.getTotalItems();
        System.out.println("Timeline \n|");
        for (int i = 0; i < numberOfItems; i++) {
            if (i == 0 || (sortedList.getItem(i - 1).getDate() != sortedList.getItem(i).getDate())) {
                System.out.println("|__ " + sortedList.getItem(i).getTime());
            }
            System.out.println("|        |__ " + sortedList.getItem(i).toString());
        }
    }

    public CalendarList sortByDate(CalendarList calendarList) {
        CalendarList sortingList = calendarList;

        for (int i = 0; i < calendarList.getTotalItems(); i++) {
            for (int j = i + 1; j < calendarList.getTotalItems(); j++) {
                if (calendarList.getItem(i).getDate() != null && calendarList.getItem(j).getDate() != null) {
                    if (calendarList.getItem(j).getTime().isBefore(calendarList.getItem(i).getTime())) {
                        sortingList.swapTasks(i, j);
                    }
                }
            }
        }
        return sortingList;
    }
}
