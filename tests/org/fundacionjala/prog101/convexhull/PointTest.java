package org.fundacionjala.prog101.convexhull;

import static org.junit.Assert.*;

import org.fundacionjala.prog101.convexhull.Point;
import org.junit.Test;

/**
 * The test class org.fundacionjala.prog101.convexhull.PointTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PointTest
{
    @Test
    public void createPointInstance()
    {
        Point myPoint = new Point();
        
        assertTrue(myPoint instanceof Point);
    }
    
    @Test
    public void pointCreatedWithoutParamsIsOrigin()
    {
        Point origin = new Point();
        
        assertEquals(origin.getX(), 0);
        assertEquals(origin.getY(), 0);
    }
    
    @Test
    public void pointCreatedWithParametersXandY()
    {
        Point myPoint = new Point(2, 3);
        
        assertEquals(myPoint.getX(), 2);
        assertEquals(myPoint.getY(), 3);
    }
    
    @Test
    public void twoPointsWithDifferentCoordinatesAreNotEquals()
    {
        Point firstPoint = new Point();
        Point secondPoint = new Point(1, 1);
        
        assertFalse(firstPoint.equals(secondPoint));
    }
    
    @Test
    public void twoPointsAreEqualsIfTheyHaveTheSameCoordinates() {
        Point firstPoint = new Point(0, 2);
        Point secondPoint = new Point(0, 2);
        
        assertTrue(firstPoint.equals(secondPoint));
    }
    
    @Test
    public void distanceToTheSamePointIsZero()
    {
        Point point = new Point();
        
        assertEquals(0, point.distanceTo(point), 0);
    }
    
    @Test
    public void distanceIsDeterminedByPythagorasFormula()
    {
        Point firstPoint = new Point();
        Point secondPoint = new Point(3, 4);
        
        assertEquals(5, firstPoint.distanceTo(secondPoint), 0);
    }
    
    @Test
    public void cannotCompareToString()
    {
        String message = "I'm not a org.fundacionjala.prog101.convexhull.Point";
        Point point = new Point();
        
        assertFalse(point.equals(message));
    }

    @Test
    public void canGenerateRandomPointBetweenSize()
    {
        Point point = Point.generateRandom(250,400);

        assertTrue(-125 <= point.getX() );
        assertTrue(125 >= point.getX() );
        assertTrue(-200 <= point.getY() );
        assertTrue(200 >= point.getX() );
    }

    @Test
    public void generatedRandomNumbersAreNotEqual()
    {
        Point pointOne = Point.generateRandom(250,400);
        Point pointTwo = Point.generateRandom(250,400);

        assertFalse(pointOne.equals(pointTwo));
    }
}
