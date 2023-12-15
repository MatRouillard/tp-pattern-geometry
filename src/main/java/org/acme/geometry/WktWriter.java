package org.acme.geometry;

public class WktWriter {

	public String write(Geometry geometry) {
		StringBuilder buffer = new StringBuilder();
		if (geometry instanceof Point) {
			Point point = (Point) geometry;
			write(point, buffer);
			return buffer.toString();
		} else if (geometry instanceof LineString) {
			LineString lineString = (LineString) geometry;
			write(lineString, buffer);
			return buffer.toString();
		} else {
			throw new RuntimeException("geometry type not supported");
		}
	}

	private void write(Point point, StringBuilder buffer) {
		buffer.append("POINT");
		if (point.isEmpty()) {
			buffer.append(" EMPTY");
			return;
		}
		buffer.append("(");
		writeCoordinate(point.getCoordinate(), buffer);
		buffer.append(")");
	}

	private void write(LineString lineString, StringBuilder buffer) {
		buffer.append("LINESTRING");
		if (lineString.isEmpty()) {
			buffer.append(" EMPTY");
			return;
		}
		buffer.append("(");
		for (int i = 0; i < lineString.getNumPoints() - 1; i++) {
			writeCoordinate(lineString.getPointN(i).getCoordinate(), buffer);
			buffer.append(",");
		}
		writeCoordinate(lineString.getPointN(lineString.getNumPoints() - 1).getCoordinate(), buffer);
		buffer.append(")");
	}

	private void writeCoordinate(Coordinate coord, StringBuilder buffer) {
		double x = coord.getX();
		double y = coord.getY();
		buffer.append(x + " " + y);
	}
}
