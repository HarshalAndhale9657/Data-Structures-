
public class abstract1 {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.eat();
        h.walk();
        h.changeColor();
        System.out.println(h.color);

        Chicken ch = new Chicken();
        ch.eat();
        ch.walk();
        ch.changeColor();
        System.out.println(ch.color);

    }

}

abstract class Animal {
    String color;

    Animal() {
        color = "brown";
    }

    void eat() {
        System.out.println("animal eats");

    }

    abstract void walk();

}

class Horse extends Animal {

    void changeColor() {
        color = "dark brown";
    }

    void walk() {
        System.out.println("walks on 4 legs");
    }
}

class Chicken extends Animal {
    void changeColor() {
        color = "white";
    }

    void walk() {
        System.out.println("walks on 4 legs");
    }

}
