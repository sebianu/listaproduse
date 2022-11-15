package mydomain;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.HashMap;
import java.util.Map;

import mydomain.ReadList.map;

public class Bon {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
    private HashMap<Integer, String> listaProduse = new HashMap<Integer, String>();
    
    public Bon() {
    	
    }
    
    public String printBon() { 
    	LocalDateTime timpAcum = LocalDateTime.now();
    	String bonPrintOut = "        BON FISCAL        \n";
    	for(Map.Entry<Integer, String> entry : listaProduse.entrySet()) {
    		Integer prodCant = entry.getKey();
    		String prodNume = entry.getValue();
    		bonPrintOut += String.format("%s - %d\n", prodNume, prodCant);
    	}
    	bonPrintOut += "\n " + dtf.format(timpAcum) + "\n";
    	return bonPrintOut;
    }
    
    public void addProdus(int produs) {
    	if(listaProduse.containsKey(produs)) {
    		listaProduse.put(produs, listaProduse.get(produs) + 1);
    	}
    	listaProduse.put(map.get(produs), 1);
    }
    
    public void delProdus(int produs) {
    	listaProduse.remove(produs);
    }
    
    

}
