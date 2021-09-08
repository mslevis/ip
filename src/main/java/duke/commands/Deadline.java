package duke.commands;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Encapsulates a Deadline object that implements a Task and has a deadline.
 *
 * @author Owen Tan
 * @version duke.Duke Level-9
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * Constructor for Deadline.
     *
     * @param description Description to be stored in Deadline.
     * @param by Deadline.
     */
    public Deadline(String description, LocalDateTime by) {
        this(description, false, by, "");
    }

    /**
     * Constructor for Deadline.
     *
     * @param description Description to be stored in Deadline.
     * @param isDone Boolean that represents Deadline completion status.
     * @param by Deadline.
     */
    public Deadline(String description, boolean isDone, LocalDateTime by) {
        this(description, isDone, by, "");
    }

    /**
     * Constructor for Deadline.
     *
     * @param description Description to be stored.
     * @param isDone Boolean that represents Deadline completion status.
     * @param by Deadline.
     * @param notes A string representation of notes.
     */
    public Deadline(String description, boolean isDone, LocalDateTime by, String notes) {
        super(description, isDone, notes);
        this.by = by;
    }

    /**
     * Returns a string representation of Deadline.
     *
     * @return A string representation of Deadline.
     */
    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        String dateString = by.format(format);
        return "[D]" + super.toString() + " (by: " + dateString + ")";
    }

    /**
     * Returns a string formatted for saving purposes.
     *
     * @return A string representation of Deadline for saving.
     */
    @Override
    public String printInSaveFormat() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        String dateString = by.format(format);
        String[] info = {"D", isDone ? "1" : "0", description, dateString};
        return String.join(" | ", info);
    }
}
