package org.acme.geometry;

public class WktWriter {

	public WktWriter() {

	}

	public String write(Geometry geometry) {
		if (geometry instanceof Point) {
			Point point = (Point) geometry;
			if (point.isEmpty()) {
				return "POINT EMPTY";
			} else {
				return "POINT(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")";
			}
		} else if (geometry instanceof LineString) {
			LineString lineString = (LineString) geometry;
			if (lineString.isEmpty()) {
				return "LINESTRING EMPTY";
			} else {
				String wkt = "LINESTRING(";
				for (int i = 0; i < lineString.getNumPoints() - 1; i++) {
					Point p = lineString.getPointN(i);
					wkt += p.getCoordinate().getX() + " " + p.getCoordinate().getY() + ",";
				}
				Point lastPoint = lineString.getPointN(lineString.getNumPoints() - 1);
				return wkt + lastPoint.getCoordinate().getX() + " " + lastPoint.getCoordinate().getY() + ")";
			}
		} else {
			throw new RuntimeException("geometry type not supported");
		}
	}

}
