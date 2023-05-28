public class Constant extends Function{
    private int x;

    Constant(int x){
        this.x= x;
    }

    public int getX() {
        return x;
    }

    @Override
    public double valueAt(double x) {
        return this.getX();
    }
}
