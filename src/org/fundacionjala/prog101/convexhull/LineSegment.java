package org.fundacionjala.prog101.convexhull;

/**
 * Write a description of class org.fundacionjala.prog101.convexhull.LineSegment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LineSegment extends Line
{
    public LineSegment(Point start, Point end)
    {
        super(start, end);
    }
    
    @Override
    public boolean contains(Point point) 
    {
        boolean meetsFormula = super.contains(point);
        boolean pointIsInRange = isInRange(point);
        return meetsFormula && pointIsInRange;
    }
    
    private boolean isInRange(Point point) 
    {
        boolean xIsInRange = point.getX() >= start.getX() && point.getX() <= end.getX();
        boolean yIsInRange = point.getY() >= start.getY() && point.getY() <= end.getY();
        return xIsInRange && yIsInRange;
    }
    
    @Override
    public double length()
    {
        return start.distanceTo(end);
    }
    
    @Override
    public boolean equals(Object obj)
    {
        return this.hashCode() == obj.hashCode();
    }
}
