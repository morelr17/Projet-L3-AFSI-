package metier;

import java.util.ArrayList;
import java.util.List;

public class ComparateurList { 
	 
	public ComparateurList() {
		super();
	}
	
	public List<String> diff2List(List<String> l, List<String> l2) {  
		List<String> diff = new ArrayList<> ()  ; 
		for (String f : l) { 
			if (!(l2.contains(f))) { 
				diff.add(f) ;  
			} 
		}
		for (String f2 : l2) { 
			if (!(l.contains(f2))) { 
				diff.add(f2) ;  
			} 
		} 
		return diff;
	} 
	
	

	public List<String> sameArrayList(List<String> lActeurs, List<String> actBpmn){
        ArrayList<String> res = new ArrayList<String>();
        for (String s1 : lActeurs){
            for (String s2 : actBpmn){
                if (s1.equals(s2)){
                    res.add(s1);
                    if(!(res.contains(s1))){
                        res.add(s1);
                    }
                    if(!(res.contains(s2))){
                        res.add(s2);
                    }
                }
            }
        } 
        return res;
    } 
}