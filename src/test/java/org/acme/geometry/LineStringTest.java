package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorPoint(){
		Coordinate c1 = new Coordinate(3.0,4.0);
		Point p1 = new Point(c1);
		Coordinate c2 = new Coordinate(6.0,8.0);
		Point p2 = new Point(c2);
		List<Point> listPoints = new ArrayList<Point>();
		listPoints.add(p1);
		listPoints.add(p2);
		LineString l = new LineString(listPoints);
		Assert.assertTrue(l.getPointN(0).equals(p1));
		Assert.assertEquals(2, l.getNumPoints(), EPSILON);
		Assert.assertEquals("LineString", l.getType());

	}
	
	@Test
	public void testDefaultConstructor(){
		LineString l = new LineString();
		Assert.assertEquals(0, l.getNumPoints(), EPSILON);
	}

}
