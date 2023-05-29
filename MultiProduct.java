public class MultiProduct extends Function {
    private Function[] factors;

    public MultiProduct(Function... factors) {
        this.factors = factors;
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

            if (!factorExpression.isEmpty()) {
                if (!expression.isEmpty()) {
                    expression += " * ";
                }

                expression += factorExpression;
            }
        }

        return expression;
    }

    @Override
    public Function derivative() {
        int length = factors.length;
        Function[] derivatives = new Function[length];

        for (int i = 0; i < length; i++) {
            Function[] otherOperands = new Function[length - 1];
            int index = 0;
            for (int j = 0; j < length; j++) {
                if (j != i) {
                    otherOperands[index++] = factors[j];
                }
            }
            Function derivative = new MultiProduct(otherOperands).derivative();

            // Multiplication manuelle de la dérivée avec l'opérande
            for (int j = 0; j < length; j++) {
                if (j != i) {
                    derivative = new Product(derivative, factors[j]);
                }
            }
            derivatives[i] = derivative;
        }

        Function derivative = derivatives[0];
        for (int i = 1; i < length; i++) {
            derivative = new MultiSum(derivative, derivatives[i]);
        }

        return derivative;
    }
}
