package org.fundacionjala.prog101.convexhull;

import static org.junit.Assert.*;

import org.fundacionjala.prog101.convexhull.Line;
import org.fundacionjala.prog101.convexhull.Point;
import org.junit.Test;

import java.util.HashSet;
/**
 * The test class org.fundacionjala.prog101.convexhull.LineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LineTest
{
    @Test
    public void lineCanBeConstructedWithTwoPoints()
    {
        Point start = new Point();
        Point end = new Point(1, 1);
        Line myLine = new Line(start, end);
        
        assertTrue(myLine instanceof Line);
    }
    
    @Test
    public void lineContainsItsStartAndEndPoints()
    {
        Point start = new Point();
        Point end = new Point(1, 1);
        Line myLine = new Line(start, end);
        
        assertTrue(myLine.contains(start));
        assertTrue(myLine.contains(end));
    }
    
    @Test
    public void lineThatDoesNotPassByTheOriginDoesNotContainIt()
    {
        Point start = new Point(-1, 0);
        Point end = new Point(0, 2);
        Line line = new Line(start, end);
        
        assertFalse(line.contains(new Point(0, 0)));
    }
    
    @Test
    public void verticalLineThatHasXeq2DoesNotContainOrigin()
    {
        Point start = new Point(2, 0);
        Point end = new Point(2, 7);
        Line line = new Line(start, end);
        
        assertFalse(line.contains(new Point()));
    }
    
    @Test
    public void pointNotAtLeft() 
    {
        Point start = new Point(2, 0);
        Point end = new Point(2, 7);
        Line line = new Line(start, end);
        
        assertFalse(line.isAtLeft(new Point(5, 1))); 
    }
    
    @Test
    public void pointAtRightOfLine() 
    {
        Point start = new Point(2, 0);
        Point end = new Point(2, 7);
        Line line = new Line(start, end);
        
        assertTrue(line.isAtRight(new Point(5, 0)));
    }
    
    @Test
    public void pointNotAtRight() 
    {
        Point start = new Point(2, 0);
        Point end = new Point(2, 7);
        Line line = new Line(start, end);
        
        assertFalse(line.isAtRight(new Point()));
    }
    
    @Test
    public void lengthOfALineIsInfinity()
    {
        Point start = new Point(2, 0);
        Point end = new Point(2, 7);
        Line line = new Line(start, end);
        
        assertEquals(Double.POSITIVE_INFINITY, line.length(), 0.0);
    }
    
    @Test
    public void hashCodeOfLinesShouldBeEqualsNoMatterWhereStarts()
    {
        Line firstLine = new Line(new Point(), new Point(1, 2));
        Line secondLine = new Line(new Point(1, 2), new Point());
        
        assertEquals(firstLine.hashCode(), secondLine.hashCode());
        
        HashSet<Line> set = new HashSet<Line>();
        set.add(firstLine);
        
        assertTrue(set.contains(firstLine));
        assertTrue(set.contains(secondLine));
    }
}
