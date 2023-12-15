package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {

	private List<Point> points;

	public LineString() {
		this(null);
	}

	public LineString(List<Point> points) {
		if (points == null) {
			this.points = new ArrayList<Point>();
		} else {
			this.points = points;
		}
	}

	public int getNumPoints() {
		return points.size();
	}

	public Point getPointN(int n) {
		return points.get(n);
	}

	public String getType() {
		return "LineString";
	}

	public boolean isEmpty() {
		return (0 == this.getNumPoints());
	}

	public void translate(double dx, double dy) {
		for (Point point: this.points) {
			point.translate(dx, dy);
		}
	}

}
