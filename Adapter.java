// Интерфейс, который ожидает клиентский код
interface Target {
    void request();
}

// Реализация интерфейса Target
class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("ConcreteTarget: Handling request.");
    }
}

// Класс, который нужно адаптировать
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee: Specific request.");
    }
}

// Адаптер, который преобразует интерфейс Adaptee в интерфейс Target
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// Пример использования
public class AdapterPatternExample {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        adapter.request();
    }
}
