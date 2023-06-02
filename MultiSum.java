public class MultiSum extends Function {
    private Function[] operands;

    public MultiSum(Function a, Function b,Function... operands) {
        this.operands = addElementToArray(operands, a, b);
    }
    public static Function[] addElementToArray(Function[] array, Function a, Function b) {
        Function[] newArray = new Function[array.length + 2];
        System.arraycopy(array, 0, newArray, 2, array.length);
        newArray[0] = a;
        newArray[1] = b;
        return newArray;
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
        double result = 0.0;
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
        Function a = derivatives[0];
        Function b = derivatives[1];
        derivatives = removeFirstTwoElements(derivatives);
        return new MultiSum(a, b ,derivatives);
    }

    public static Function[] removeFirstTwoElements(Function[] array) {
        Function[] newArray = new Function[array.length - 2];
        System.arraycopy(array, 2, newArray, 0, array.length - 2);
        return newArray;
    }
}