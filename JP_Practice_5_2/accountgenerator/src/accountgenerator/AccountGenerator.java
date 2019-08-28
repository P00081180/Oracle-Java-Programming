package accountgenerator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AccountGenerator {

	public static void main(String[] args) throws ClassNotFoundException {
		Employee emp = new Employee();
		serializeData(emp);
		Employee emp2 = (Employee) deSerialize();
		System.out.println(emp2);
	}//end method main
	
	static void serializeData(Employee emp) {
		try(FileOutputStream fos = new FileOutputStream("employee.ser"); 
			ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(emp); 
			System.out.print("Serialized data is saved in employee.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}//end try catch
	}//end method serializeData
	
	
	public static Object deSerialize() throws ClassNotFoundException {
		try(FileInputStream fis = new FileInputStream("employee.ser");
			ObjectInputStream ois = new ObjectInputStream(fis)) {
				return ois.readObject(); 
			} catch (IOException i) {
				i.printStackTrace();
				return null;
			}//end try catch
	}//end method deSerialize
}//end class AccountGenerator
