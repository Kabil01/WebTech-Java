class Shape {
    void draw() {
        System.out.println("Drawing a generic shape");
    }

    double calculateArea() {
        System.out.println("Calculating area of a generic shape");
        return 0.0;
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    double getRadius() {
        return radius;
    }
}

class Cylinder extends Circle {
    private double height;

    Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    double calculateArea() {
        // Calculate the total surface area of the cylinder
        double baseArea = super.calculateArea();
        double lateralSurfaceArea = 2 * Math.PI * super.getRadius() * height;
        double totalSurfaceArea = 2 * baseArea + lateralSurfaceArea;
        return totalSurfaceArea;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape genericShape = new Shape();
        Circle circle = new Circle(3.0);
        Cylinder cylinder = new Cylinder(2.0, 4.0);

        genericShape.draw();
        System.out.println("Area of generic shape: " + genericShape.calculateArea());

        circle.draw();
        System.out.println("Area of the circle: " + circle.calculateArea());

        cylinder.draw();
        System.out.println("Total surface area of the cylinder: " + cylinder.calculateArea());
    }
}

