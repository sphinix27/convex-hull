package org.fundacionjala.prog101.convexhull.gui;

import org.fundacionjala.prog101.convexhull.Line;
import org.fundacionjala.prog101.convexhull.Point;
import org.fundacionjala.prog101.convexhull.PointSet;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by AbelBarrientos on 5/5/2017.
 */
public class ConvexHullPanel extends javax.swing.JPanel {

    private PointSet pointSet;

    private List<DrawablePoint> drawablePoints;

    public ConvexHullPanel()
    {
        pointSet = new PointSet();
        drawablePoints = new ArrayList<>();
        setBackground(new Color(73, 93, 119));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                addPointAtEventCoordinates(e);
            }
        });
    }

    private void addPointAtEventCoordinates(MouseEvent e) {
        int relativeX = e.getX() - getWidth()/2;
        int relativeY = getHeight()/2 - e.getY();

        Point point = new Point(relativeX, relativeY);
        pointSet.add(point);

        DrawablePoint drawablePoint = new DrawablePoint(point);
        drawablePoint.setContainer(this);
        drawablePoints.add(drawablePoint);

        repaint();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        drawAxis(g);
        drawPoints(g);
        drawLines(g);
    }

    private void drawLines(Graphics g) {
        for (Line line: pointSet.searchSpace())
        {
            g.drawLine(line.getStart().x + getCenter().getX(), getCenter().getY() - line.getStart().y, line.getEnd().x + getCenter().getX(), getCenter().getY() - line.getEnd().y);
        }
    }

    private void drawPoints(Graphics g) {
        for(DrawablePoint point: drawablePoints)
        {
            point.draw(g);
        }
    }

    private void drawAxis(Graphics g) {
        g.setColor(new Color(213, 237, 30));
        g.drawLine(getWidth()/2, 0, getWidth()/2,getHeight());
        g.drawLine(0, getHeight()/2, getWidth(),getHeight()/2);
    }

    public Point getCenter() {
        return new Point(getWidth()/2, getHeight()/2);
    }
}
