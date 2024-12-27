import java.util.ArrayList;
import java.util.List;

// Интерфейс наблюдателя
interface Observer {
    void update(String message);
}

// Конкретный наблюдатель
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " получил сообщение: " + message);
    }
}

// Интерфейс субъекта
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

// Конкретный субъект
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}

// Использование
public class ObserverExample {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        
        Observer observer1 = new ConcreteObserver("Наблюдатель 1");
        Observer observer2 = new ConcreteObserver("Наблюдатель 2");

        subject.attach(observer1);
        subject.attach(observer2);

        subject.setMessage("Привет, наблюдатели!");
    }
}
