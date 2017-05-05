package org.fundacionjala.prog101.convexhull;

import java.util.*;

/**
 * Write a description of class org.fundacionjala.prog101.convexhull.PointSet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PointSet
{
    private Set<Point> points; 
   
    public PointSet()
    {
        points = new HashSet<Point>();
    }
    
    public int size()
    {       
        return points.size();
    }
   
    public void add(Point point)
    {       
        points.add(point);
    }
   
    public Collection<Line> searchSpace()
    {
        HashSet<Line> space = new HashSet<Line>();
        for (Point left: points)
        {
            for (Point right: points)
            {
                if (!left.equals(right))
                {
                    boolean flag = false;
                    LineSegment lineSegment = new LineSegment(left, right);                    
                    
                    for (Line line: space)
                    {
                        if (line.contains(lineSegment))
                        {
                            flag =true;
                            LineSegment lineAdded = new LineSegment(line.getStart(), line.getEnd());
                            if (lineSegment.length() > lineAdded.length())
                            {
                                space.remove(line);
                                flag = false;
                            }
                            break;
                        }
                    }
                    if (!flag)
                    {
                        Line line = new Line(left, right);
                        space.add(line);
                    }
                }
                    
            }
        }
        return space;
    }
    
    public boolean isEdge(Line line)
    {
        boolean isAtLeft = false;
        boolean isAtRight = false;
        for (Point other: points)
        {
            if (!line.contains(other))
            {                
                if (line.isAtLeft(other))
                    isAtLeft = true;
                else
                    isAtRight = true;                                    
            }
            if (isAtLeft && isAtRight)
            {
                return false;
            }
            
        }
        return true;
    }
    
    public Collection<Line> solve()
    {
        HashSet<Line> solution = new HashSet<Line>();
        for (Line line: searchSpace())
        {
            if (isEdge(line))
            {
                solution.add(line);
            }
                
        }
        return solution;
    }
}
