package codegym.todo;

public class Entry {
    private static int count = 1;
    private int priority;
    private String notes;
    private final int id;

    public Entry(int priority, String notes){
        id = count++;
        this.priority = priority;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
