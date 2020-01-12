package com.bengodwinweb;

public class Point {
    private int x;
    private int y;

    public double distance() {
        return this.distance(0, 0);
    }

    public double distance(Point point2) {
        return this.distance(point2.getX(), point2.getY());
    }

    public double distance(int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
    }

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
