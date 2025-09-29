package test;

public class Classroom {
    private String roomName;
    private int capacity;

    public Classroom(String roomName, int capacity) {
        this.roomName = roomName;
        this.capacity = capacity;
    }

    public String getRoomName() { return roomName; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return roomName + " (Capacity: " + capacity + ")";
    }
}


