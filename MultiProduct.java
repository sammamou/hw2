public class MultiProduct extends Function {
    private Function[] factors;
    private Variable x; // Variable symbolique

    public MultiProduct(Function... factors) {
        this.factors = factors;
        this.x = new Variable("x"); // Création de la variable symbolique
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
        Function derivativeResult = new MultiSum(derivatives);
        return derivativeResult;
    }


}
