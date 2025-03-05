package D_OOP.E_Polymorphism.L02_Shapes;

public class Circle extends Shape{

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public Double getArea() {
        return super.getArea();
    }

    public final Double getRadius() {
        return this.radius;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(this.radius, this.radius);
    }
}
