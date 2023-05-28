public class Constant extends Function{
    private double x;

    Constant(double x){
        this.x= x;
    }

    public double getX() {
        return x;
    }

    @Override
    public double valueAt(double x) {
        return this.getX();
    }

    @Override
    public String toString() {
        return "(" +getX()+ ")";
    }

    @Override
    public String derivative() {
        return "0";
    }

    @Override
    public String taylorPolynomial(int n) {
        return "(" +getX()+ ")";
    }
}
