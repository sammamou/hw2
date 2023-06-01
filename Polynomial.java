public class Polynomial extends Function {
    protected double[] coefficients;

    public Polynomial(double[] liste, int n){
        coefficients = liste;
    }
    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }


    @Override
    public double valueAt(double x) {
        double result = 0;
        double power = 1;

        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * power;
            power *= x;
        }
        if (Math.floor(result) == result) {
            return (int)result;
        } else {
            return result;
        }

    }

    @Override
    public String toString() {
        String expression = "";

        for (int i = coefficients.length - 1; i >= 0; i--) {
            double coefficient = coefficients[i];

            if (coefficient != 0) {
                if (!expression.isEmpty()) {
                    if (coefficient > 0) {
                        expression += " + ";
                    } else {
                        expression += " - ";
                        coefficient = -coefficient;
                    }
                }

                if (i == 0 || coefficient != 1) {
                    if (Math.floor(coefficient) == coefficient) {
                        expression += (int)coefficient;
                    }else {
                        expression += coefficient;
                    }
                }

                if (i > 0) {
                    expression += "x";

                    if (i > 1) {
                        expression += "^" + i;
                    }
                }
            }
        }

        return "(" + expression + ")";
    }

    @Override
    public Function derivative() {
        int n;
        if(coefficients.length == 0){
            n = 0;
        }else{
            n = coefficients.length - 1;
        }
        double[] derivativeCoefficients = new double[n];

        for (int i = 0; i < n; i++) {
            derivativeCoefficients[i] = coefficients[i + 1] * (i + 1);
        }

        return new Polynomial(derivativeCoefficients);
    }
}
