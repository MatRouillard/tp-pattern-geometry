package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {

	@Test
	public void testWktPoint() {
		Geometry g = StaticTestFactory.makePointA();
		WktWriter writer = new WktWriter();
		Assert.assertEquals("POINT(3.0 4.0)", writer.write(g));
	}

	@Test
	public void testWktPointEmpty() {
		Geometry g = new Point();
		WktWriter writer = new WktWriter();
		Assert.assertEquals("POINT EMPTY", writer.write(g));
	}

	@Test
	public void testWktLineString() {
		Geometry g = StaticTestFactory.makeLineStringA();
		WktWriter writer = new WktWriter();
		Assert.assertEquals("LINESTRING(0.0 0.0,3.0 4.0)", writer.write(g));
	}

	@Test
	public void testWktLineStringEmpty() {
		Geometry g = new LineString();
		WktWriter writer = new WktWriter();
		Assert.assertEquals("LINESTRING EMPTY", writer.write(g));
	}
}
