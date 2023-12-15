package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorCoord() {
		Point p = StaticTestFactory.makePointA();
		Coordinate getCoord = p.getCoordinate();
		Assert.assertEquals("[3.0,4.0]", getCoord.toString());
		Assert.assertEquals("Point", p.getType());
		Assert.assertFalse(p.isEmpty());
	}

	@Test
	public void testDefaultConstructor() {
		Point p = new Point();
		Assert.assertTrue(p.getCoordinate().isEmpty());
		Assert.assertTrue(p.isEmpty());
	}

	@Test
	public void testTranslate() {
		Point p = StaticTestFactory.makePointA();

		p.translate(1, 1);
		Assert.assertEquals("[4.0,5.0]", p.getCoordinate().toString());
	}

	@Test
	public void testClone() {
		Point p = StaticTestFactory.makePointA();

		Point pClone = p.clone();
		pClone.translate(1, 1);

		Assert.assertEquals("[3.0,4.0]", p.getCoordinate().toString());
	}

	@Test
	public void testEnvelope() {
		Point p = StaticTestFactory.makePointA();

		Assert.assertEquals("3.0,4.0,3.0,4.0", p.getEnvelope().toString());
	}

	@Test
	public void testAsText() {
		Geometry p = StaticTestFactory.makePointA();

		Assert.assertEquals("POINT(3.0 4.0)", p.asText());
	}

	@Test
	public void testAsTextEmpty() {
		Geometry p = new Point();

		Assert.assertEquals("POINT EMPTY", p.asText());
	}

}
