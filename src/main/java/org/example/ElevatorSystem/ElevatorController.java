package org.example.ElevatorSystem;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ElevatorController {
    List<Elevator> elevators;

    public ElevatorController(List<Elevator> elevators){
        this.elevators = elevators;
    }

    public boolean requestElevator(Request request){
        if(request.getFloor()<0 || request.getFloor()>9) return false;

        Elevator best = selectBestElevator(request);

        return best.addRequest(request);
    }

    private Elevator selectBestElevator(Request request) {
        int floor = request.getFloor();
        Direction direction = request.direction;

        Elevator best = findMovingTowards(floor,direction);
        if(best!=null) return best;
        best = findNearestIdle(floor);
        if(best!=null) return best;
        return findNearest(floor);


    }

    private Elevator findNearest(int floor) {
        Optional<Elevator> best = elevators.stream().min(Comparator.comparingInt(e -> Math.abs(e.getFloor()-floor)));
        return best.orElse(null);
    }

    private Elevator findNearestIdle(int floor) {
        Optional<Elevator> best = elevators.stream().filter(e -> e.direction==Direction.IDLE).min(Comparator.comparingInt(e -> Math.abs(e.getFloor()-floor)));
        return best.orElse(null);
    }

    private Elevator findMovingTowards(int floor, Direction direction) {

        Optional<Elevator> best = elevators.stream().filter(e -> e.direction==direction).min(Comparator.comparingInt(e -> Math.abs(e.getFloor() - floor)));
        return best.orElse(null);
    }

    public void step(){
        for(Elevator e:  elevators) e.step();
    }


}
