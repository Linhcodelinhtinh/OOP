package OOP.expression;

//import OOP.Expressions;

public class Numeral extends Expressions {
    private int value;

    public Numeral(int value) {
        this.value = value;
    }

    public int evaluate() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(value);
    }

}
