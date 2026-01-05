
public class inheritance {
    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.eat();
        

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

// derived class
class Fish extends Animal{
    int fins;
    void swim(){
        System.out.println("swims in water");
    }
}
