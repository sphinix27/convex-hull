package org.fundacionjala.prog101.convexhull;

import static org.junit.Assert.*;

import org.fundacionjala.prog101.convexhull.Line;
import org.fundacionjala.prog101.convexhull.Point;
import org.fundacionjala.prog101.convexhull.PointSet;
import org.junit.Test;

import java.util.Collection;

/**
 * The test class org.fundacionjala.prog101.convexhull.PointSetTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PointSetTest
{
    @Test
    public void isEmptyAtTheBeginning()
    {
        PointSet pointSet = new PointSet();
        
        assertEquals(0, pointSet.size());
    }
    
    @Test
    public void size1AfterAddingPoint()
    {
        PointSet pointSet = new PointSet();
        pointSet.add(new Point());
        
        assertEquals(1, pointSet.size());
    }
    
    @Test
    public void size2AfterAdding2Points()
    {
        PointSet pointSet = new PointSet();
        pointSet.add(new Point());
        pointSet.add(new Point(1, 1));
        
        assertEquals(2, pointSet.size());
    }
    
    @Test
    public void size1AfterAddingSamePoint()
    {
        PointSet pointSet = new PointSet();
        Point point = new Point();
        pointSet.add(point);
        pointSet.add(point);
        pointSet.add(new Point());
        
        assertEquals(1, pointSet.size());
    }
    
    @Test
    public void searchSpaceIsEmptyIfPointSetIsEmpty()
    {
        PointSet pointSet = new PointSet();
        
        Collection<Line> space = pointSet.searchSpace();
                
        assertTrue(space.isEmpty());
    }
    
    @Test
    public void searchSpaceOfTreePointsIsATriangle()
    {
        PointSet pointSet = new PointSet();
        pointSet.add(new Point());
        pointSet.add(new Point(1, 1));
        pointSet.add(new Point(2, -3));
        
        assertEquals(3, pointSet.searchSpace().size());
    }
    
    @Test
    public void anyLineOfAPointSetWith3ElementsIsEdge()
    {
        PointSet pointSet = new PointSet();
        Point one = new Point();
        Point two = new Point(1, 1);
        Point three = new Point(2, -3);
        pointSet.add(one);
        pointSet.add(two);
        pointSet.add(three);
        
        assertTrue(pointSet.isEdge(new Line(one, two)));
        assertTrue(pointSet.isEdge(new Line(one, three)));
        assertTrue(pointSet.isEdge(new Line(two, three)));
    }
    
    @Test
    public void anyLineFromTheCenterOfAGroupOfPointIsNotAnEdge
    ()
    {
        PointSet pointSet = new PointSet();
        Point one = new Point();
        Point two = new Point(1, 1);
        Point three = new Point(2, -3);
        Point four = new Point(1, 0);
        pointSet.add(one);
        pointSet.add(two);
        pointSet.add(three);
        pointSet.add(four);
        
        assertFalse(pointSet.isEdge(new Line(one, four)));
        assertFalse(pointSet.isEdge(new Line(two, four)));
        assertTrue(pointSet.isEdge(new Line(two, three)));
    }
    
    @Test
    public void solutionOfAPointSetWith3ElementsIsATriangle()
    {
        PointSet pointSet = new PointSet();
        pointSet.add(new Point());
        pointSet.add(new Point(1, 1));
        pointSet.add(new Point(2, -3));
        Collection<Line> solution = pointSet.solve();
        
        
        assertEquals(3, solution.size());
    }
    
    @Test
    public void solutionOfAPointSetWith4PointsWhereOneOfThemIsInternal()
    {
        PointSet pointSet = new PointSet();
        pointSet.add(new Point(0, 5));
        pointSet.add(new Point(-1, -2));
        pointSet.add(new Point(6, 0));
        pointSet.add(new Point(0, 0));
        Collection<Line> solution = pointSet.solve();
        
        
        assertEquals(3, solution.size());
    }
    
    @Test
    public void solutionOfAPointSetWith6PointsWhereOneOfThemIsInternal()
    {
        PointSet pointSet = new PointSet();
        pointSet.add(new Point(0, 0));
        pointSet.add(new Point(2, -1));
        pointSet.add(new Point(5, -2));
        pointSet.add(new Point(2, 2));
        pointSet.add(new Point(1, 1));
        pointSet.add(new Point(4, 4));
        pointSet.add(new Point(3, 1));
        Collection<Line> solution = pointSet.solve();        
        
        assertEquals(4, solution.size());
    }
}
