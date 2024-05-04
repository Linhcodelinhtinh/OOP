package OOP.expression;

public class Main {
    public static void main(String[] args) {
        Numeral one = new Numeral(1);
        Numeral two = new Numeral(2);
        Square s = new Square(two);
        Expressions e = new Addition(one, s);
        System.out.println(e + "= " + e.evaluate());
    }
}
