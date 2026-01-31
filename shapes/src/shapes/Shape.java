package shapes;

public abstract class Shape implements Comparable<Shape>{

	protected Double width;
	protected Double height;
	
	public Shape(Double width, Double height) {
		this.width = width;
		this.height = height;
	}
	
	public abstract Double calculateSurface();
	
	@Override
	public int compareTo(Shape other) {
		return this.calculateSurface().compareTo(other.calculateSurface());
	}
}
