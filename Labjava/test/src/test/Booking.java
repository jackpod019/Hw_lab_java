package test;

import java.time.LocalDateTime;

public class Booking {
    private Teacher teacher;
    private Classroom classroom;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean fullTerm;

    public Booking(Teacher teacher, Classroom classroom, 
                   LocalDateTime startTime, LocalDateTime endTime, 
                   boolean fullTerm) {
        this.teacher = teacher;
        this.classroom = classroom;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fullTerm = fullTerm;
    }

    public Teacher getTeacher() { return teacher; }
    public Classroom getClassroom() { return classroom; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public boolean isFullTerm() { return fullTerm; }

    @Override
    public String toString() {
        return teacher.getName() + " booked " + classroom.getRoomName() +
               " from " + startTime + " to " + endTime +
               (fullTerm ? " [Full Term]" : "");
    }
}

