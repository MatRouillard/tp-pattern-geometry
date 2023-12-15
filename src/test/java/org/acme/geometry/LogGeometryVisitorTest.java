package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class LogGeometryVisitorTest {

	@Test
	public void testLogPoint() {
		Geometry g = StaticTestFactory.makePointA();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor log = new LogGeometryVisitor(out);
		g.accept(log);
		try {
			String result = os.toString("UTF8");
			Assert.assertEquals("Je suis un point avec x=3.0 et y=4.0.", result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testLogPointEmpty() {
		Geometry g = new Point();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor log = new LogGeometryVisitor(out);
		g.accept(log);
		try {
			String result = os.toString("UTF8");
			Assert.assertEquals("Je suis un point vide.", result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testLogLineString() {
		Geometry g = StaticTestFactory.makeLineStringA();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor log = new LogGeometryVisitor(out);
		g.accept(log);
		try {
			String result = os.toString("UTF8");
			Assert.assertEquals("Je suis une polyligne définie par 2 point(s).", result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testLogLineStringEmpty() {
		Geometry g = new LineString();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor log = new LogGeometryVisitor(out);
		g.accept(log);
		try {
			String result = os.toString("UTF8");
			Assert.assertEquals("Je suis une polyligne vide.", result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
