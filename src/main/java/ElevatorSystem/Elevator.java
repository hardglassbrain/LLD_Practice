package ElevatorSystem;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Elevator {
    int floor;
    Direction direction;
    Status status;
    Set<Request> requests;

    public Elevator(){
        direction = Direction.IDLE;
        status = Status.IN_SERVICE;
        requests = new HashSet<>();
    }

    public boolean addRequest(Request request){
        return requests.add(request);
    }

    public void step(){
        //Case:1 - Nothing to do
        if(requests.isEmpty()) {
            direction = Direction.IDLE;
            return;
        }
        //Case:2 - Pick direction if idle
        if(direction == Direction.IDLE){
            Request nearest_req = findNearestRequest();
            direction = nearest_req.getFloor() > floor ? Direction.UP : Direction.DOWN;
        }

        //Case: 3 - Stop at current floor ?
        Optional<Request> stop = requests.stream().filter(e -> e.getFloor()==floor).findFirst();
        if(stop.isPresent()){
            requests.remove(stop.get());
            stop();
            return;
        }

        //Reverse if no more request ahead
        Optional<Request> anyMoreRequestAhead = requests.stream().filter(e -> e.getFloor()>floor).findAny();
        if(!anyMoreRequestAhead.isPresent()){
            direction = direction == Direction.UP ? Direction.DOWN:Direction.UP;
            return;
        }

        if(direction ==Direction.UP && floor<9) floor++;
        else if(direction ==Direction.DOWN && floor > 0) floor--;


    }

    private Request findNearestRequest() {
        Optional<Request> nearestRequest = requests.stream().min(Comparator.comparingInt(e ->Math.abs(floor-e.getFloor())));
        return nearestRequest.get();
    }

    public int getFloor(){
        return floor;
    }

    public Direction getDirection(){
        return direction;
    }

    public void stop(){
        //stop at the floor
    }
}
