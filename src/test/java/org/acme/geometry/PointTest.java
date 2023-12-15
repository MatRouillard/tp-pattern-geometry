package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorCoord() {
		Coordinate c = new Coordinate(3.0, 4.0);
		Point p = new Point(c);
		Coordinate getCoord = p.getCoordinate();
		Assert.assertTrue(getCoord.equals(c));
		Assert.assertEquals("Point", p.getType());
		Assert.assertFalse(p.isEmpty());
	}

	@Test
	public void testDefaultConstructor() {
		Point p = new Point();
		Coordinate getCoord = p.getCoordinate();
		Assert.assertTrue(getCoord.isEmpty());
		Assert.assertTrue(p.isEmpty());
	}
	
	@Test
	public void testTranslate() {
		Coordinate c = new Coordinate(3.0, 4.0);
		Point p = new Point(c);
		p.translate(1, 1);;
		Assert.assertEquals(4, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(5, p.getCoordinate().getY(), EPSILON);
	}

}
