public class OOPS {
    public static void main(String[] args) {

        Pen p1 = new Pen(); // created a pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.color);
        p1.setTip(5);
        System.out.println(p1.tip);

        BankAccount myAcc = new BankAccount();
        myAcc.username = "Harshal";
        System.out.println(myAcc.username);
        // myAcc.password = "qwerty"; ------> not possible cause password have private
        // access modifier
        myAcc.setPasssword("asdfghjkl");
       

    }

}

class BankAccount {
    public String username;
    private String password;

    public void setPasssword(String pwd) {
        password = pwd;
    }

}

class Pen {

    // attributes or properties
    String color;
    int tip;

    // functions
    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }

}