public class Terrain extends Treillis{

    public Terrain(double xMin, double xMax, double yMin, double yMax) {
    }

    private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;

    public double getxMax() {
        return xMax;
    }

    public double getxMin() {
        return xMin;
    }

    public double getyMax() {
        return yMax;
    }

    public double getyMin() {
        return yMin;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
    }

    public void setyMax(double yMax) {
        this.yMax = yMax;
    }

    public void setyMin(double yMin) {
        this.yMin = yMin;
    }
}
