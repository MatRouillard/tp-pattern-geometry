package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

	private StringBuilder buffer;

	public WktVisitor() {
		this.buffer = new StringBuilder();
	}

	@Override
	public void visit(Point point) {
		buffer.append("POINT");
		if (point.isEmpty()) {
			buffer.append(" EMPTY");
			return;
		}
		buffer.append("(");
		writeCoordinate(point.getCoordinate(), buffer);
		buffer.append(")");
	}

	@Override
	public void visit(LineString lineString) {
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

	public String getResult() {
		return buffer.toString();
	}

}
