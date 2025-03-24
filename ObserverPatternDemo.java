import java.util.ArrayList;
import java.util.List;

// Abstract Observer class
abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

// Subject class
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Concrete Observer - Binary Representation
class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}

// Concrete Observer - Octal Representation
class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}

// Concrete Observer - Hexadecimal Representation
class HexaObserver extends Observer {
    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}

// Main class
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);

        // Removing one observer (Octal)
        System.out.println("\nDetaching Octal Observer...");
        subject.detach(octalObserver);

        System.out.println("\nSecond state change: 10 (Octal Observer won't be notified)");
        subject.setState(10);

        // Attaching Octal Observer again
        System.out.println("\nAttaching Octal Observer again...");
        subject.attach(octalObserver);

        System.out.println("\nThird state change: 20 (All observers will be notified)");
        subject.setState(20);
    }
}
