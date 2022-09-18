public class Assignment {
    private String name;
    private String course;
    private Date dueDate;
    private boolean completed = false;


    private int type;
    int difficultly;

    public Assignment() {
    }

    public Assignment(String name, String course, Date dueDate, int type, int difficultly) {
        this.name = name;
        this.course = course;
        this.dueDate = dueDate;
        this.type = type;
        this.difficultly = difficultly;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setDifficultly(int difficultly) {
        this.difficultly = difficultly;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public Date getDate() {
        return dueDate;
    }

    public boolean getCompleted() {
        return completed;
    }

    public int getType() {
        return type;
    }

    public int getDifficultly() {
        return difficultly;
    }

}
