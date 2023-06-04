public class MultiProduct extends Function {
    private Function[] factors;
    public MultiProduct(Function a, Function b,Function... factors) {
        this.factors = addElementToArray(factors, a, b);
    }
    public static Function[] addElementToArray(Function[] array, Function a, Function b) {
        Function[] newArray = new Function[array.length + 2];
        System.arraycopy(array, 0, newArray, 2, array.length);
        newArray[0] = a;
        newArray[1] = b;
        return newArray;
    }

    public MultiProduct(Function f, double element){
    }

    @Override
    public double valueAt(double x) {
        double result = 1.0;
        for (Function factor : factors) {
            result *= factor.valueAt(x);
        }
        return result;
    }

    @Override
    public String toString() {
        String expression = "";

        for (Function factor : factors) {
            String factorExpression = factor.toString();


            if (!expression.isEmpty()) {
                expression += " * ";
            }

            expression += factorExpression;

        }

        return "(" + String.valueOf(expression) + ")";
    }


    /*
    @Override
    public Function derivative() {
        int length = factors.length;
        Function[] derivatives = new Function[length];

        for (int i = 0; i < factors.length; i++) {
            derivatives[i] = factors[i].derivative();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j != i) {
                    derivatives[i] = new MultiProduct(derivatives[i],factors[j]);
                }
            }
        }
        Function a = derivatives[0];
        Function b = derivatives[1];
        derivatives = removeFirstTwoElements(derivatives);
        Function derivativeResult = new MultiSum(a, b,derivatives);
        return derivativeResult;
    }*/
    @Override
    public Function derivative() {
        int length = factors.length;
        Function[] derivatives = new Function[length];

        for (int i = 0; i < factors.length; i++) {
            derivatives[i] = factors[i].derivative();
        }

        for (int i = 0; i < length; i++) {
            Function[] numderive = new Function[length];
            int index = 0;
            numderive[index] = factors[i].derivative();
            for (int j = 0; j < length; j++) {
                if (j != i) {
                    index++;
                    numderive[index] = factors[j];
                }

            }
            Function a = numderive[0];
            Function b = numderive[1];
            numderive = removeFirstTwoElements(numderive);
            derivatives[i] = new MultiProduct(a, b,numderive);
        }
        Function a = derivatives[0];
        Function b = derivatives[1];
        derivatives = removeFirstTwoElements(derivatives);
        Function derivativeResult = new MultiSum(a, b,derivatives);
        return derivativeResult;
    }

    public static Function[] removeFirstTwoElements(Function[] array) {
        Function[] newArray = new Function[array.length - 2];
        System.arraycopy(array, 2, newArray, 0, array.length - 2);
        return newArray;
    }


}