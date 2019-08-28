package serializeing;

import java.io.*;
public class Serialization implements Serializable {
	private static final long serialVersionUID = 1L;
	// Declare a local variable.
	private String identifier = "A serialized string!";
	
	public Serialization() {
		
	}//end constructor
	
	public String getSerializableIdentifier() {
		return this.identifier;
	}
	
	public static void serialize(String outFile, Object serializableObject) throws IOException {
	     FileOutputStream fos = new FileOutputStream(outFile);
	     ObjectOutputStream oos = new ObjectOutputStream(fos);
	     oos.writeObject(serializableObject); 
	}

	public static Object deSerialize(String serilizedObject) throws FileNotFoundException, IOException, ClassNotFoundException {
	     FileInputStream fis = new FileInputStream(serilizedObject);
	     ObjectInputStream ois = new ObjectInputStream(fis);
	     return ois.readObject(); 
	}
	
	public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
		Serialization serial1 = new Serialization();
	    serialize("Fellowship.txt", serial1);
	    Serialization serial2 = (Serialization) deSerialize("Fellowship.txt");
	    System.out.println(serial2.getSerializableIdentifier()); 
	}    
}
