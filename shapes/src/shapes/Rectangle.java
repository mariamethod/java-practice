package shapes;

public class Rectangle extends Shape{
	
	public Rectangle(Double width, Double height) {
		super(width,height);
	}

	@Override
	public Double calculateSurface() {
		return super.width*super.height;
	
	}

}
