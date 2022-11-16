package mydomain;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ListRead {
	static HashMap<Integer, String> map = new HashMap<Integer, String>();
	public static void Main(String[] args) {
		try {
			File file = new File("lista_produse.txt");
			Scanner scanner = new Scanner(file);
			String line;
			
			while(scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] tokens = line.split(" ");
				
				String key = tokens[0];
				line = String.join(" ",Arrays.copyOfRange(tokens, 1, tokens.length));
				
				map.put(Integer.parseInt(key), line);
			}
			
			scanner.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
