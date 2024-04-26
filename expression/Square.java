package OOP.expression;

public class Square extends Expressions {
    private Expressions expression;
    public Square(Expressions expression) {
        this.expression = expression;
    }

    public int evaluate() {
        int tmp = expression.evaluate();
        return tmp * tmp;
    }
    public String toString() {
        // e + "^2"
        return expression + "^2 ";
    }
}
