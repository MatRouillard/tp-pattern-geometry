package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testEnvelopBuilder() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(0.0, 1.0));
		builder.insert(new Coordinate(2.0, 0.0));
		builder.insert(new Coordinate(1.0, 3.0));
		Envelope envelope = builder.build();
		Assert.assertFalse(envelope.isEmpty());
		Assert.assertEquals("0.0,0.0,2.0,3.0", envelope.toString());
	}

	@Test
	public void testDefaultConstructor() {
		Envelope envelope = new Envelope();
		Assert.assertTrue(envelope.isEmpty());
	}

}
