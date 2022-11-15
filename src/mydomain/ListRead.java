package mydomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Scanner;


public class ListRead {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        try {
            File myFile = new File("lista_produse.txt");
            Scanner myReader = new Scanner(myFile);
            String[] SplitProd;
            SplitProd = new String[5];
            int number = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                SplitProd = data.split(" ");
                int spaceNumber = 0;
                String restText;
                restText = new String();
                restText = "";
                for(String aux : SplitProd)
                {
                    if(spaceNumber < 1)
                        number = Integer.parseInt(aux);
                    else {
                       restText =  restText.concat(aux);
                        restText = restText.concat(" ");
                    }
                    spaceNumber ++;
                }
                int lengh = restText.length();
                //System.out.println(restText.length());
                String finalText = restText.substring(0, lengh - 1);
                map.put(number,finalText);
                System.out.println(map);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
}
