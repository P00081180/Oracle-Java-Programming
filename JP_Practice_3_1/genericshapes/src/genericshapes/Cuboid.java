package genericshapes;

public class Cuboid<T extends Number> {
	private T length;
	private T breadth;
	private T height;	

	public Cuboid() {	
	}//end constructor
	
	public Cuboid(T length, T breadth, T height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}//end constructor
	
	public void setLength(T length) {
		this.length = length;
	}//end method setLength
	
	public void setHeight(T height) {
		this.height = height;
	}//end method setHeight
	
	public void setBreadth(T breadth) {
		this.breadth = breadth;
	}//end method setBreadth
	
	public T getLength() {
		return length;
	}//end method getLength
	
	public T getHeight() {
		return height;
	}//end method getHeight
	
	public T getBreadth() {
		return breadth;
	}//end method getBreadth
	
	public String toString() {
		return ("Length: " + length + "\n" + "Height: " + height + "\n" + "Breadth: " + breadth + "\n");
	}//end method toString

 	public double getVolume() {		
		return length.doubleValue() * height.doubleValue() * breadth.doubleValue();
	}//end method getVolume

}//end class Cuboid
