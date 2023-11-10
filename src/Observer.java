import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String Message);
}


class Notify{
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

