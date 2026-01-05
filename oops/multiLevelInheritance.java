public class multiLevelInheritance {
    public static void main(String[] args) {
        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs=4;
        System.out.println(dobby.legs);
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
    int legs;
}

class Dog extends Mammal{
    void bark(){
        System.out.println("can bark");
    }


}
