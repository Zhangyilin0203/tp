package seedu.duke.calendar.event;

import seedu.duke.calendar.CalendarItem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event in the event list.
 */
public abstract class Event extends CalendarItem {
    protected LocalDate date;
    protected LocalTime time;
    protected String venue;
    protected boolean isOver;

    /**
     * A constructor for events.
     *
     * @param date  date of the event
     * @param time  time of the event
     * @param venue venue of the event
     */
    public Event(LocalDate date, LocalTime time, String venue) {
        this.date = date;
        this.time = time;
        this.venue = venue;
    }


    /**
     * Describe the event.
     *
     * @return a string containing the information about the event
     */
    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy E")) + " "
                + time.format(DateTimeFormatter.ofPattern("h:mma"))
                + " (" + venue + ")";
    }

    @Override
    public String getDescription() {
        return " (" + venue + ")";
    }


    public abstract String getType();

    public LocalDate getDate() {
        return date;
    }

    public void markAsOver() {
        isOver = true;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getVenue() {
        return venue;
    }

    public boolean isOver() {
        return isOver;
    }
}
