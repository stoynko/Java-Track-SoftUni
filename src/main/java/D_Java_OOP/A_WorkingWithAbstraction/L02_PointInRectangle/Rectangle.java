package D_Java_OOP.A_WorkingWithAbstraction.L02_PointInRectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX() &&
                point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();
    }
}
