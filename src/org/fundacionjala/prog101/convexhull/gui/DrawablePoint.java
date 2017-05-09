package org.fundacionjala.prog101.convexhull.gui;

import org.fundacionjala.prog101.convexhull.Point;

import java.awt.*;

/**
 * Created by AbelBarrientos on 5/9/2017.
 */
public class DrawablePoint{
    private final Point point;
    private ConvexHullPanel container;

    public DrawablePoint(Point point)
    {
        this.point = point;
    }

    public void draw(Graphics g)
    {
        Point center = container.getCenter();
        g.drawOval(point.getX() + center.getX(), center.getY() - point.getY(), 3, 3);
    }

    public void setContainer(ConvexHullPanel container) {
        this.container = container;
    }
}
