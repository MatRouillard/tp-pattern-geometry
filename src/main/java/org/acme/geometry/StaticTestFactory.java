package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public final class StaticTestFactory {

	private StaticTestFactory() {

	}

	public static Point makePoint0() {
		return new Point(new Coordinate(0, 0));
	}

	public static Point makePointA() {
		return new Point(new Coordinate(3, 4));
	}

	public static LineString makeLineStringA() {
		List<Point> listPoints = new ArrayList<Point>();
		listPoints.add(makePoint0());
		listPoints.add(makePointA());
		return new LineString(listPoints);
	}

}
