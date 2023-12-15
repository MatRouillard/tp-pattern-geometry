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
		double xTranslate = this.coordinate.getX() + dx;
		double yTranslate = this.coordinate.getY() + dy;

		Coordinate newCoord = new Coordinate(xTranslate, yTranslate);
		this.coordinate = newCoord;
	}

	public Point clone() {
		Coordinate cloneCoord = new Coordinate(this.coordinate.getX(), this.coordinate.getY());

		return new Point(cloneCoord);
	}

}
