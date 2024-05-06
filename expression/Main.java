package OOP.expression;

public class Main {
    public static void main(String[] args) {
        Expressions three = new Numeral(3);
        Numeral two = new Numeral(2);
        Square s = new Square(two);
        Expressions e = new Addition(three, s);
        System.out.println(e + "= " + e.evaluate());
    }
}
