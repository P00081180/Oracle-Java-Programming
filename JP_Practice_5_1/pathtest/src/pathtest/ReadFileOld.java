package pathtest;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileOld {

	public static void main(String[] args) {
		// Declare container strings.
		String line = "", fileContent = "";
		try {
		   BufferedReader fileInput = new BufferedReader(new FileReader(new File("C:/JavaProgramming/employees.txt")));

	       // Read and process first line.
		   line = fileInput.readLine();
		   fileContent = line + "\n";

		   // Read and process second thru last lines.
		   while (line != null) {
		      line = fileInput.readLine();
			  if (line != null)
			     fileContent += line + "\n"; 
		   }//endwhile
		      fileInput.close(); 
	    }//endtry
		catch(EOFException eofe) {
		   System.out.println("No more lines to read.");
		   System.exit(0); 
	    }//endcatch
		catch(IOException ioe) {
		   System.out.println("Error reading file.");
		   System.exit(0); 
	    }//end catch
	    // Assign read contents.
		System.out.println(fileContent);
   }//end method main
}//end class ReadFileOld
