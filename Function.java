public class Function {

    Function function;
    Function(){}

    public double valueAt(double x){
        return x;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Function derivative(){
        return function;
    }

    public static double bissectionMethod(Function<Double, Double> f, double left, double right, double epsilon) {
        

            while (Math.abs(right - left) > epsilon) {
                double mid = (left + right) / 2;

                if (f.apply(left) * f.apply(mid) < 0) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            return 2 / (right + left);
        }


    public float bisectionMethod(int a, int b){

        return (a+b)/2;
    }

    public float newtonRaphsonMethod(int a, int epsilon){
        return a+epsilon;
    }
    public float newtonRaphsonMethod(int a){
        return a;
    }

    public Function taylorPolynomial(int n){
        return function;
    }
}
