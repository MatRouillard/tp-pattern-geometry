package org.acme.geometry;

public class Coordinate {

	public static final Coordinate EMPTY = new Coordinate();

	private double x;

	private double y;

	public Coordinate() {
		this.x = Double.NaN;
		this.y = Double.NaN;
	}

	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
		this.ensureIsValid();
	}

	/**
	 * Bloque la création de coordonnées avec une seule valeur NaN pour x ou y
	 */
	private void ensureIsValid() {
		if (Double.isNaN(x) || Double.isNaN(y)) {
			throw new IllegalArgumentException("Invalid Coordinate: " + this.toString());
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public boolean isEmpty() {
		return Double.isNaN(x) || Double.isNaN(y);
	}

	public String toString() {
		if (Double.isNaN(x) && Double.isNaN(y)) {
			return "[NaN, NaN]";
		} else if (Double.isNaN(x)) {
			return "[NaN," + y + "]";
		} else if (Double.isNaN(y)) {
			return "[" + x + ",NaN]";
		} else {
			return "[" + x + "," + y + "]";
		}
	}
}
