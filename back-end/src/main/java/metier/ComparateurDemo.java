package metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComparateurDemo extends Comparateur{ 
	 
	ArrayList<String> flMfc; 
	 ArrayList<String> actMfc; 
	 ArrayList<String> flBpmn; 
	 ArrayList<String> actBpmn;  
	 
	public ComparateurDemo() {
		super();
	}

	public boolean doMetier(String bpmn , String mfc,String actExt) { 
		doParseBpmn(bpmn);
		doParseMfc(mfc);
		 return (flBpmn.isEmpty() && flMfc.isEmpty()) ;
	} 
	
	@Override
	public ArrayList<String> getFlMfc() {
		return flMfc;
	}
	@Override
	public ArrayList<String> getActMfc() {
		return actMfc;
	}
	@Override
	public ArrayList<String> getFlBpmn() {
		return flBpmn;
	}
	@Override
	public ArrayList<String> getActBpmn() {
		return actBpmn;
	}

	public boolean existDiff(List<String> l) { 
		return !(l.isEmpty());
	} 
	
	
	
}