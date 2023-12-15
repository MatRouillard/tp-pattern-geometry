package org.acme.geometry;

public class Point implements Geometry {

	private Coordinate coordinate;

	public Point() {
		this(null);
	}

	public Point(Coordinate coordinate) {
		if (coordinate == null) {
			this.coordinate = Coordinate.EMPTY;
		} else {
			this.coordinate = coordinate;
		}
	}

	public Coordinate getCoordinate() {
		return this.coordinate;
	}

	public String getType() {
		return "Point";
	}

	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}

	public void translate(double dx, double dy) {
		this.coordinate = new Coordinate(this.coordinate.getX() + dx, this.coordinate.getY() + dy);
	}

	public Point clone() {
		return new Point(coordinate);
	}

	public Envelope getEnvelope() {
		return new Envelope(coordinate, coordinate);
	}
}
