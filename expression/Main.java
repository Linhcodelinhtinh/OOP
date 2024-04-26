package OOP.expression;

public class Main {
    public static void main(String[] args) {
        Numeral one = new Numeral(1);
        Numeral two = new Numeral(2);
        Square s = new Square(two);
        System.out.println(s + "= " + s.evaluate());
    }
}
