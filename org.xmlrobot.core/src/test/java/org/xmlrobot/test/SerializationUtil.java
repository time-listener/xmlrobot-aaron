/**
 * 
 */
package org.xmlrobot.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.xmlrobot.core.Universe;

/**
 * @author joan
 *
 */
public class SerializationUtil {

	/**
	 * 
	 */
	public SerializationUtil() {
		// TODO Auto-generated constructor stub
	}
	// deserialize to Object from given file
    public static Object deserialize(String fileName) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
 
    // serialize the given object and save it to file
    public static void serialize(Object obj, String fileName)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
 
        fos.close();
    }
    
    
    public static void main(String[] args) {
		
//    	String[] message = new String[] { "A", "B", "C", "D", "E", "F", "G",
//				"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
//				"T", "U", "V", "W", "X", "Y", "Z", "Ç" };
//		// instance hypercube
//		Hypercube cube = new Hypercube(Hyperchain.class);
//		// for each word in original message
//		for (String word : message) {
//			// declare counter
//			int i = 0;
//			// sum all char values
//			for (char letter : word.toCharArray())
//				i += letter;
//			// instance key-value mapping
//			String key = new String(word);
//			Integer value = new Integer(i);
//			// store key-value pair
//			cube.put(key, value);
//		}
//		
//		try {
//			serialize(Test1.bigBang(), "bigBang.tmp");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	try {
			Object src = deserialize("bigBang.tmp");
			System.out.print((Universe)src);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
