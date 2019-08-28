package courses;

import java.util.HashMap;

public class Courses {

	public static void main(String[] args) {
		HashMap<String,String> courses = new HashMap();
		courses.put("CIT", "Computing and Information Technology");
		courses.put("CHI", "Childcare and Early Education");
		courses.put("MVS", "Motor Vehicle Systems");
		courses.put("BTH", "Beauty Therapy");
		courses.put("GDE", "Graphic Design");
		
		System.out.println(courses);
		System.out.println(courses.get("CIT"));

	}//end method main

}//end class Courses
