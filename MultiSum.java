public class MultiSum extends Function {
    private Function[] operands;

    public MultiSum(Function... operands) {
        this.operands = operands;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < operands.length; i++) {
            result += operands[i].toString();
            if (i < operands.length - 1) {
                result += " + ";
            }
        }
        return "(" + result + ")";
    }

    @Override
    public double valueAt(double x) {
        double result = 1.0;
        for (Function operand : operands) {
            result += operand.valueAt(x);
        }
        return result;
    }

    @Override
    public Function derivative() {
        Function[] derivatives = new Function[operands.length];
        for (int i = 0; i < operands.length; i++) {
            derivatives[i] = operands[i].derivative();
        }
        return new MultiSum(derivatives);
    }
}