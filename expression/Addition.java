package OOP.expression;

//import java.beans.Expression;

public class Addition extends Expressions{
    private Expressions left, right;
    public Addition(Expressions left, Expressions right) {
        this.left = left;
        this.right = right;
    }
    public int evaluate(){
        int tmp1 = left.evaluate();
        int tmp2 = right.evaluate();
        return tmp1 + tmp2;
    }
    public String toString(){
        return left.toString() + " + " + right.toString();
    }
}
