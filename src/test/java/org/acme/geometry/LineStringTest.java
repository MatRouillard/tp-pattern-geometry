package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorPoint() {
		LineString l = StaticTestFactory.makeLineStringA();
		Assert.assertEquals("[0.0,0.0]", l.getPointN(0).getCoordinate().toString());
		Assert.assertEquals(2, l.getNumPoints(), EPSILON);
		Assert.assertEquals("LineString", l.getType());
		Assert.assertFalse(l.isEmpty());
	}

	@Test
	public void testDefaultConstructor() {
		LineString l = new LineString();
		Assert.assertEquals(0, l.getNumPoints(), EPSILON);
		Assert.assertTrue(l.isEmpty());
	}

	@Test
	public void testTranslate() {
		LineString l = StaticTestFactory.makeLineStringA();

		l.translate(1, 1);

		Assert.assertEquals("[1.0,1.0]", l.getPointN(0).getCoordinate().toString());
		Assert.assertEquals("[4.0,5.0]", l.getPointN(1).getCoordinate().toString());
	}

	@Test
	public void testClone() {
		LineString l = StaticTestFactory.makeLineStringA();

		LineString lClone = l.clone();

		lClone.translate(1, 1);

		Assert.assertEquals("[0.0,0.0]", l.getPointN(0).getCoordinate().toString());
		Assert.assertEquals("[3.0,4.0]", l.getPointN(1).getCoordinate().toString());
	}

	@Test
	public void testEnvelope() {
		LineString l = StaticTestFactory.makeLineStringA();

		Assert.assertEquals("0.0,0.0,3.0,4.0", l.getEnvelope().toString());
	}

}
