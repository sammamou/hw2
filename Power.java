public class Power extends MultiProduct {
    private Function base;
    private int exponent;

    public Power(Function base, int exponent) {
        super(base, exponent);
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        if(exponent ==0){
            return new Constant(1).toString();
        } else if (exponent < 0) {
            return new Constant(0).toString();
        } else {
            return "(" + base.toString() + "^" + exponent +")";
        }
    }
    @Override
    public double valueAt(double x) {
        if (exponent>=0) {
            return Math.pow(base.valueAt(x), exponent);
        }else {
            return 0;
        }
    }

    @Override
    public Function derivative() {
        Function baseDerivative = base.derivative();
        Function exponentMinusOne = new Power(base, exponent - 1);

        return new MultiProduct(new Constant(exponent),exponentMinusOne,baseDerivative);
    }
}