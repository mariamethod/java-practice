package shapes;

public class Triangle extends Shape{
	
	public Triangle(Double width, Double height) {
		super(width,height);
	}

	@Override
	public Double calculateSurface() {
		return super.width*super.height/2;
	
	}

}
