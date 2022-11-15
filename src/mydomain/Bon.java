package mydomain;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.HashMap;
import java.util.Map;
import mydomain.ListRead;


public class Bon {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
    private HashMap<String, Integer> listaProduse = new HashMap<String, Integer>();
    
    public Bon() {
    	
    }
    
    public String printBon() { 
    	LocalDateTime timpAcum = LocalDateTime.now();
    	String bonPrintOut = "        BON FISCAL        \n";
    	for(Map.Entry<String, Integer> entry : listaProduse.entrySet()) {
    		Integer prodCant = entry.getValue();
    		String prodNume = entry.getKey();
    		bonPrintOut += String.format("%s - %d\n", prodNume, prodCant);
    	}
    	bonPrintOut += "\n " + dtf.format(timpAcum) + "\n";
    	return bonPrintOut;
    }
    
    public void addProdus(int produs) {
    	String prod = ListRead.map.get(produs);
    	if(listaProduse.containsKey(prod)) {
    		listaProduse.put(prod, listaProduse.get(prod) + 1);
    	}
    	listaProduse.put(ListRead.map.get(produs), 1);
    }
    
    public void delProdus(int produs) {
    	listaProduse.remove(ListRead.map.get(produs));
    }
    
    

}
