
import java.util.HashMap;

public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.

    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );
    static HashMap<String, Operator> operators = new HashMap();

    static {
        operators.put("+", new AdditionOperator());
        operators.put("-", new SubtractionOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivisionOperator());
        operators.put("^", new PowerOperator());
        operators.put("(", new OpenPara());
        operators.put(")", new ClosePara());
        operators.put("#", new PoundSigh());
        operators.put("!", new Exclamation());
    }

    public abstract int priority();

    public abstract Operand execute(Operand op1, Operand op2);

    public abstract String getValue();

    public static boolean check(String token) {
        return operators.containsKey(token);
    }

    private static class AdditionOperator extends Operator {

        public String getValue() {
            return "+";
        }

        public int priority() {
            return 2;
        }

        public Operand execute(Operand op1, Operand op2) {
            return new Operand(op1.getValue() + op2.getValue());
        }
    }

    private static class SubtractionOperator extends Operator {

        public String getValue() {
            return "-";
        }

        public int priority() {
            return 2;
        }

        public Operand execute(Operand op1, Operand op2) {
            return new Operand(op1.getValue() - op2.getValue());
        }
    }

    private static class MultiplyOperator extends Operator {

        public String getValue() {
            return "*";
        }

        public int priority() {
            return 3;
        }

        public Operand execute(Operand op1, Operand op2) {
            return new Operand(op1.getValue() * op2.getValue());
        }
    }

    private static class DivisionOperator extends Operator {

        public String getValue() {
            return "/";
        }

        public int priority() {
            return 3;
        }

        public Operand execute(Operand op1, Operand op2) {
            return new Operand(op1.getValue() / op2.getValue());
        }
    }

    private static class PowerOperator extends Operator {

        public String getValue() {
            return "^";
        }

        public int priority() {
            return 4;
        }

        public Operand execute(Operand op1, Operand op2) {
            return new Operand((int) (Math.pow(op1.getValue(), op2.getValue())));
        }
    }

    private static class OpenPara extends Operator {

        public String getValue() {
            return "(";
        }

        public int priority() {
            return -1;
        }

        public Operand execute(Operand op1, Operand op2) {
            return new Operand("");
        }
    }

    private static class ClosePara extends Operator {

        public String getValue() {
            return ")";
        }

        public int priority() {
            return -1;
        }

        public Operand execute(Operand op1, Operand op2) {
            return new Operand("");
        }
    }

    private static class PoundSigh extends Operator {

        public String getValue() {
            return "#";
        }

        public int priority() {
            return 0;
        }

        public Operand execute(Operand op1, Operand op2) {
            return new Operand("");
        }
    }

    private static class Exclamation extends Operator {

        public String getValue() {
            return "！";
        }

        public int priority() {
            return 1;
        }

        public Operand execute(Operand op1, Operand op2) {
            return new Operand("");
        }
    }

}
