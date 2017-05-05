package org.fundacionjala.prog101.convexhull;

/**
 * Write a description of class org.fundacionjala.prog101.convexhull.Point here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point
{
    public int x;
    public int y;
    
    public Point()
    {
        this(0,0);
    }
    
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        boolean typeIsCompatible = (obj instanceof Point);
        return typeIsCompatible && (this.hashCode() == obj.hashCode());
    }
    
    public double distanceTo(Point other)
    {
        return Math.sqrt(Math.pow((other.getX() - x), 2) + Math.pow((other.getY() - y), 2));
    }
    
    @Override
    public int hashCode()
    {
        return x + 31 * y;
    }
}
