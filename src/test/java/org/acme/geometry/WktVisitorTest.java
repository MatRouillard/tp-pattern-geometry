package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {

	@Test
	public void testWktPoint() {
		Geometry g = StaticTestFactory.makePointA();
		WktVisitor wktVisitor = new WktVisitor();
		g.accept(wktVisitor);
		Assert.assertEquals("POINT(3.0 4.0)", wktVisitor.getResult());
	}

	@Test
	public void testWktPointEmpty() {
		Geometry g = new Point();
		WktVisitor wktVisitor = new WktVisitor();
		g.accept(wktVisitor);
		Assert.assertEquals("POINT EMPTY", wktVisitor.getResult());
	}

	@Test
	public void testWktLineString() {
		Geometry g = StaticTestFactory.makeLineStringA();
		WktVisitor wktVisitor = new WktVisitor();
		g.accept(wktVisitor);
		Assert.assertEquals("LINESTRING(0.0 0.0,3.0 4.0)", wktVisitor.getResult());
	}

	@Test
	public void testWktLineStringEmpty() {
		Geometry g = new LineString();
		WktVisitor wktVisitor = new WktVisitor();
		g.accept(wktVisitor);
		Assert.assertEquals("LINESTRING EMPTY", wktVisitor.getResult());
	}

}
