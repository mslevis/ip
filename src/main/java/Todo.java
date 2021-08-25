public class Todo extends Task{
    public Todo(String description) {
        super(description);
    }

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    String printFormat() {
        String[] info = {"T", this.isDone ? "1" : "0", this.description};
        return String.join(" | ", info);
    }
}