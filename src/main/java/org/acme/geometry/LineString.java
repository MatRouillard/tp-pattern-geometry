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
		return 0 == this.getNumPoints();
	}

	public void translate(double dx, double dy) {
		for (Point point : this.points) {
			point.translate(dx, dy);
		}
	}

	@Override
	public LineString clone() {

		List<Point> clonePoints = new ArrayList<Point>();

		for (Point point : this.points) {
			clonePoints.add(point.clone());
		}

		return new LineString(clonePoints);
	}

	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();

		for (Point point : this.points) {
			builder.insert(point.getCoordinate());
		}
		return builder.build();
	}

	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
