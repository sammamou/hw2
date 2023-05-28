public class Function {

    String f;
    Function(){}

    public double valueAt(double x){
        return x;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String derivative(){
        return f;
    }

    public float bisectionMethod(int a, int b, int epsilon){
        return (a+b)/2;
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

    public String taylorPolynomial(int n){
        return f;
    }
}
