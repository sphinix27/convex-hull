package org.fundacionjala.prog101.convexhull.gui;

import org.fundacionjala.prog101.convexhull.Point;

import java.awt.*;

/**
 * Created by AbelBarrientos on 5/9/2017.
 */
public class DrawableLine{
    private final Point start;
    private final Point end;
    private ConvexHullPanel container;

    public DrawableLine(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public void draw(Graphics g)
    {
        Point center = container.getCenter();
        g.drawLine(start.x + center.getX(), center.getY() - start.y, end.x + center.getX(), center.getY() - end.y);
    }

    public void setContainer(ConvexHullPanel container)
    {
        this.container = container;
    }
}
