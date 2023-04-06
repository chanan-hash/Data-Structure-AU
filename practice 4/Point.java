public class Point {

    // Data
    private double _x;
    private double _y;

    // constructors
    public Point(double x, double y) {
        this._x = x;
        this._y = y;
    }

    // copy constructor
    public Point(Point p) {
        this._x = p._x;
        this._y = p._y;
    }


    public double getX() {
        return this._x;
    }

    public void setX(double x) {
        this._x = x;
    }

    public double getY() {
        return _y;
    }

    public void setY(double y) {
        this._y = y;
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + _x +
                ", y=" + _y +
                '}';
    }

    // functions
    public double x() {
        return _x;
    }

    public double y() {
        return _y;
    }
}