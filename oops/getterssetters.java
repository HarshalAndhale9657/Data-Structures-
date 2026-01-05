
public class getterssetters {
    public static void main(String[] args) {

        Pen p1 = new Pen(); // created a pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.getcolor());
        p1.setTip(5);
        System.out.println(p1.getTip());

        p1.setColor("yellow");
        System.out.println(p1.getcolor());

    }

}

class Pen {
    private String color;
    private int tip;

    // setters
    void setColor(String newColor) {
        color = newColor;
    }
    void setTip(int newTip) {
        tip = newTip;
    }

    
    // getters
    String getcolor() {
        return this.color;
    }
    int getTip() {
        return this.tip;
    }

}
