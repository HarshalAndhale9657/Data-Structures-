public class hierarchialInheritance {
    public static void main(String[] args) {
        
    }
}

// base class
class Animal {
    String color;

    void eat() {
        System.out.println("eats");
    }
    void breath() {
        System.out.println("breaths");
    }
}

class Mammal extends Animal {
    void walk(){
        System.out.println("can walk");
    }
}

class Fish extends Animal {
    void swim(){
        System.out.println("can swim in water");
    }
}

class Bird extends Animal {
    void fly(){
        System.out.println("can fly");
    }
}
