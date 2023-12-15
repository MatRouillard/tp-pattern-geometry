package org.acme.geometry;

public class Point implements Geometry {
	
	private Coordinate coordinate;

	public Point() {
		coordinate = new Coordinate();
	}

	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}

	public String getType() {
		return "Point";
	}

}
