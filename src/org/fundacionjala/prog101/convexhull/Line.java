package org.fundacionjala.prog101.convexhull;

/**
 * Write a description of class org.fundacionjala.prog101.convexhull.Line here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Line
{
    protected Point start;
    protected Point end;
   
    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }
   
    public boolean contains(Point point)
    {
        return calculateDeterminant(point) == 0;
    }
    
    public boolean isAtLeft(Point point) 
    {
        return calculateDeterminant(point) > 0;
    }
    
    public boolean isAtRight(Point point) 
    {
        return calculateDeterminant(point) < 0;
    }
    
    public double calculateDeterminant(Point point)
    {
        int x = point.getX();
        int y = point.getY();
        int xs = start.getX();
        int ys = start.getY();
        int xe = end.getX();
        int ye = end.getY();
        return (xe - xs) * (y - ys) - (x - xs) * (ye - ys);
    }
    
    public double length()
    {
        return Double.POSITIVE_INFINITY;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        return this.hashCode() == obj.hashCode();
    }
    
    @Override
    public int hashCode()
    {
        return start.hashCode() + end.hashCode();
    }
    
    public Point getStart()
    {
        return start;
    }
        
    public Point getEnd()
    {
        return end;
    }
    
    public boolean contains(LineSegment lineSegment)
    {
        double determinantStart = calculateDeterminant(lineSegment.getStart());
        double determinantEnd = calculateDeterminant(lineSegment.getEnd());
        return (determinantStart == 0) && (determinantEnd == 0);
    }
}
