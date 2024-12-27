// Базовый интерфейс
interface Component {
    void operation();
}

// Конкретный компонент
class ConcreteComponent implements Component {
    public void operation() {
        System.out.println("ConcreteComponent: Операция");
    }
}

// Декоратор
class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

// Конкретный декоратор
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        addedBehavior();
    }

    private void addedBehavior() {
        System.out.println("ConcreteDecorator: Добавленное поведение");
    }
}

// Пример использования
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component decoratedComponent = new ConcreteDecorator(component);
        decoratedComponent.operation();  // Выводит: "ConcreteComponent: Операция" и "ConcreteDecorator: Добавленное поведение"
    }
}
