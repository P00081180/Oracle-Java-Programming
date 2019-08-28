package genericshapes;

public class ShapeDriver {

	public static void main(String[] args) {
		Cuboid<Double> c1 = new Cuboid<>();
		c1.setLength(1.3);
		c1.setBreadth(2.2);
		c1.setHeight(2.0);
		System.out.println(c1);

		Cuboid<Integer> c2 = new Cuboid<>(1,2,3);
		System.out.println(c2);
		
		System.out.println(c1.getVolume());
		System.out.println(c2.getVolume());
	}//end method main

}//end class ShapeDriver 
