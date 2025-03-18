package D_OOP.A_WorkingWithAbstraction.E04_TrafficLights;

public class TrafficLight {

    private TrafficSignal signal;

    public TrafficLight(TrafficSignal signal) {
        this.signal = signal;
    }

    public void changeSignal() {
        switch (signal) {
            case RED -> signal = TrafficSignal.GREEN;
            case YELLOW -> signal = TrafficSignal.RED;
            case GREEN -> signal = TrafficSignal.YELLOW;
        }
    }

    public TrafficSignal getColor() {
        return signal;
    }

    public void setSignal(TrafficSignal signal) {
        this.signal = signal;
    }
}
