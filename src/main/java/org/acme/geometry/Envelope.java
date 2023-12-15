package org.acme.geometry;

import java.util.List;

public class Envelope {

	private Coordinate bottomLeft;
	private Coordinate topRight;
	
	public Envelope() {
		this.bottomLeft = Coordinate.EMPTY;
		this.topRight = Coordinate.EMPTY;
	}

	public Envelope(Coordinate bottomLeft, Coordinate topRight) {
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}

	public double getXMin() {
		return bottomLeft.getX();
	}

	public double getYMin() {
		return bottomLeft.getY();
	}

	public double getXMax() {
		return topRight.getX();
	}

	public double getYMax() {
		return topRight.getY();
	}

	public String toString() {
		return this.getXMin() + "," + this.getYMin() + "," + this.getXMax() + "," + this.getYMax();
	}

	public boolean isEmpty() {
		return (bottomLeft.isEmpty() && topRight.isEmpty());
	}

}
