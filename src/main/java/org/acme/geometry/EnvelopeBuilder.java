package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder {

	private List<Double> xVals;
	private List<Double> yVals;

	public EnvelopeBuilder() {
		this.xVals = new ArrayList<Double>();
		this.yVals = new ArrayList<Double>();
	}

	public void insert(Coordinate coord) {
		this.xVals.add(coord.getX());
		this.yVals.add(coord.getY());
	}

	public Envelope build() {
		return new Envelope(new Coordinate(Collections.min(xVals), Collections.min(yVals)),
				new Coordinate(Collections.max(xVals), Collections.max(yVals)));
	}

}
