package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {

	@Override
	public abstract Geometry clone();

	public String asText() {
		WktVisitor wktVisitor = new WktVisitor();
		this.accept(wktVisitor);
		return wktVisitor.getResult();
	}

}
