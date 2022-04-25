package com.icloud.refactoring._06_mutable_data._01_split_variable;

public class Rectangle {

    /**
     * 둘레
     */
    private double perimeter;

    /**
     * 넓이
     */
    private double area;

    public void updateGeometry(double height, double width) {
        final double perimeter = 2 * (height + width);
        System.out.println("Perimeter: " + perimeter);
        this.perimeter = perimeter;

        final double area = height * width;
        System.out.println("Area: " + area);
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}
