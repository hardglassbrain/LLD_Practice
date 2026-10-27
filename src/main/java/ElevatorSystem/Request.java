package ElevatorSystem;

public class Request {
    int floor;
    Direction direction;

    public Request(int floor, Direction direction){
        this.floor = floor;
        this.direction = direction;
    }

    public Request(int floor){
        this.floor = floor;
    }

    public int getFloor(){
        return this.floor;
    }
}
