package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {

	@Override
	public abstract AbstractGeometry clone();

	public String asText() {
		WktVisitor wktVisitor = new WktVisitor();
		this.accept(wktVisitor);
		return wktVisitor.getResult();
	}

}
