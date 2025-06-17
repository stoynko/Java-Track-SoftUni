package E_Polymorphism.L02_Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public Double getArea() {
        return super.getArea();
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Double getWidth() {
        return this.width;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * (this.height + this.width);
    }

    @Override
    public Double calculateArea() {
        return this.height * this.width;
    }
}
