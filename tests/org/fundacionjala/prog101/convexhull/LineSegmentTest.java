package org.fundacionjala.prog101.convexhull;

import static org.junit.Assert.*;

import org.fundacionjala.prog101.convexhull.Line;
import org.fundacionjala.prog101.convexhull.LineSegment;
import org.fundacionjala.prog101.convexhull.Point;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class org.fundacionjala.prog101.convexhull.LineSegmentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LineSegmentTest
{
    private Point start;
    private Point end;
    
    @Before
    public void setUp() {
        start = new Point();
        end = new Point(3, 3);        
    }
    
    @Test
    public void lineSegmentExtendsLine() {
        LineSegment segment = new LineSegment(start, end);
        
        assertTrue(segment instanceof Line);
        assertTrue(segment instanceof LineSegment);
    }
    
    @Test
    public void lineSegmentContainsPointInsideTheBoundaries() {
        Line segment = new LineSegment(start, end);
        
        assertTrue(segment.contains(new Point(2, 2)));
    }
    
    @Test
    public void lineSegmentDoesNotContainPointsOutsideOfTheBoundaries() {
        Line segment = new LineSegment(start, end);
        
        assertFalse(segment.contains(new Point(4, 4)));
    }
}
