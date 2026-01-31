package shapes;

public class Circle extends Shape{
	private final Double pi = (double)22/ (double) 7;
	public Circle(Double radius) {
		super(radius,radius);
	}

	@Override
	public Double calculateSurface() {
		return pi*super.width*super.height;
	
	}

}
