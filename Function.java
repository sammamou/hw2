public class Function {

    protected Function function;
    Function(){}

    public Function getFunction() {
        return function;
    }

    public double valueAt(double x){
        if (Math.floor(x) == x) {
            return (int)x;
        } else {
            return x;
        }
    }


    public Function derivative(){
        return function;
    }

    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a;
        double right = b;

        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            double fLeft = valueAt(left);
            double fMid = valueAt(mid);

            if (fLeft * fMid > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left + right) / 2;
    }

    public double bisectionMethod(double a, double b){

        return bisectionMethod(a, b,1e-5);
    }

    public double newtonRaphsonMethod(double a, double epsilon) {
        double x = a;
        double error = 1000000000 ;

        while (error > epsilon) {
            double fx = valueAt(x);
            double fpx = derivative().valueAt(x);

            if (fpx == 0) {
                break;
            }

            double newX = x - (fx / fpx);
            error = Math.abs(newX - x);
            x = newX;
        }

        return x;
    }



    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, 1e-5);
    }

   /*public Function taylorPolynomial(int n) {
        Function polynomial = new Function();
        Function currentTerm = this;
        Function termi;

        for (int i = 1; i <= n; i++) {
            Function temp;
            int finalI = i;
            termi = new Function() {
                @Override
                public double valueAt(double x) {
                    return currentTerm.valueAt(0) / factorial(finalI);
                }
            };

            for (int j = 1; j <= i; j++) {
                Function finalTermi = termi;
                temp = new Function() {
                    @Override
                    public double valueAt(double x) {
                        return finalTermi.valueAt(0) * currentTerm.derivative().valueAt(0);
                    }
                };
                termi = temp;
            }

            Function finalTermi1 = termi;
            Function finalPolynomial = polynomial;
            polynomial = new Function() {
                @Override
                public double valueAt(double x) {
                    return finalPolynomial.valueAt(0) + finalTermi1.valueAt(0);
                }
            };
        }

        return polynomial;

     }*/

    public Function taylorPolynomial(int n) {
        Function taylorpolynomial = new Function();
        Function temp = this;
        if (n == 0){
            return new Constant(temp.valueAt(0));
        }
        double[] listeMekadmim = new double[n+1];
        for (int i = 0; i <= n; i++) {
            double x = temp.valueAt(0);
            double rslt = x / factorial(i);
            listeMekadmim[i] = rslt;
            temp = temp.derivative();
        }
        taylorpolynomial = new Polynomial(listeMekadmim,n+1);
        return taylorpolynomial;
    }


    public double factorial(int n) {
        double result = 1;
        if(n == 0){
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
