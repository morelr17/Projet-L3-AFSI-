package metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comparateur { 
	private ComparateurList comparateurList=new ComparateurList();
	List<String> listActOfBpmnMfc = new ArrayList <> () ; 
	private List<String> diffOfAll= new ArrayList <> () ; 
	private List<String> diffFlux = new ArrayList <> () ; 
	private List<String> correctFlux = new ArrayList <> (); 
	private List<String> diffActBpmnWithMfc= new ArrayList <> () ;
	private List<String> correctActBpmnWithMfc = new ArrayList <> (); 
	private List<String> lActeurs ; 
	private List<String> flMfc= new ArrayList<> () ; 
	private List<String> flBpmn=new ArrayList<> () ; 
	private List<String> actBpmn=new ArrayList<> () ;
	private List<String> actMfc=new ArrayList<> () ;;
	private List<String> diffActWithBpmn= new ArrayList <> () ; 
	private List<String> correctActWithBpmn = new ArrayList <> () ; 
	private List<String> diffActWithMfc = new ArrayList <> () ; 
	private List<String> correctActWithMfc;
	private int cpErTotal=0 ;
	private int cpErFlux=0; 
	private int cpErActBpmnWithMfc=0;  
	private int cpCorrectFl=0 ; 
	private int cpCorrectActBpmnWithMfc=0 ;
	private int cpCorrectActMfc; 
	private int cpCorrectActWithBpmn ; 
	private int cpErActWithBpmn ;
	private int cpCorrectActWithMfc;
	private int cpErActWithMfc; 
	boolean boolActIsInput=false; 
	private int nbPointsCorrect;

	public Comparateur() {
		super();
	}

	public boolean doMetier(String bpmn , String mfc,String actExt) { 
		doParseBpmn(bpmn);
		doParseMfc(mfc);
		return diffAll(flMfc,flBpmn,actBpmn,actMfc,actExt).isEmpty(); 
	} 
	
	public void doParseBpmn(String bpmnXml) { 
		 BpmnParser bp = new BpmnParser() ; 
		 bp.parseBpmnMethode(bpmnXml); 
		 this.flBpmn=bp.getListFluxBpmn(); 
		 this.actBpmn=(ArrayList<String>) bp.getListActeursBpmn(); 
	} 
	
	public void doParseMfc(String mfcXml) { 
		 MfcParser mf = new MfcParser() ; 
		 mf.parseMfcMethode(mfcXml); 
		 this.flMfc=mf.getListFluxMfc(); 
		 this.actMfc=mf.getListActeursMfc(); 
	}
	
	public List<String> diffAll(List<String> l1, List<String> l2, List<String> l3, List<String> l4,String acteurs) { 
		this.diffOfAll.clear();
		extractDifferenceOfActeursBpmnVsMfc(l3,l4);
		extractDifferenceOfFluxBpmnVsMfc(l1, l2) ;
		extractDifferenceBetweenActeursVsBpmnVsMfc(l3,l4,acteurs);
		competeurErreurTotal();
		return  this.diffOfAll ;
	} 
	
	public void diffActWithBpmnAndMfc(String act,List<String> actBpmn,List<String> actMfc) { 
		if(act.length()>1) {
			boolActIsInput=true;
			//String acteurs to List
	        lActeurs = new ArrayList<String>(Arrays.asList(act.split(",")));  
	        //For acteurs vs BPMN
	        this.diffActWithBpmn= comparateurList.diff2List(lActeurs,actBpmn);
			this.correctActWithBpmn= comparateurList.sameArrayList(lActeurs,actBpmn);
			this.cpCorrectActWithBpmn = correctActWithBpmn.size() ; 
			this.cpErActWithBpmn = diffActWithBpmn.size() ;  
			//For acteurs vs MFC
			this.diffActWithMfc= comparateurList.diff2List(lActeurs,actMfc);
			this.correctActWithMfc= comparateurList.sameArrayList(lActeurs,actMfc);
			this.cpCorrectActWithMfc = correctActWithMfc.size() ; 
			this.cpErActWithMfc = diffActWithMfc.size() ; 
		}
        
	} 
	
	public void extractDifferenceOfActeursBpmnVsMfc(List<String> l3,List<String> l4) { 
		//For acteurs of BPMN vs MFC
		this.diffActBpmnWithMfc= comparateurList.diff2List(l3,l4) ; 
		this.correctActBpmnWithMfc= comparateurList.sameArrayList(l3,l4) ;  
		cpCorrectActBpmnWithMfc=correctActBpmnWithMfc.size() ; 
		cpErActBpmnWithMfc=diffActBpmnWithMfc.size() ; 
		this.diffOfAll.addAll(diffActBpmnWithMfc) ; 
	}
	
	public void extractDifferenceOfFluxBpmnVsMfc(List<String> l1,List<String> l2) { 
		this.diffFlux= comparateurList.diff2List(l1,l2) ; 
		this.correctFlux= comparateurList.sameArrayList(l1,l2) ; 
		cpCorrectFl=correctFlux.size() ; 
		cpErFlux = diffFlux.size() ; 
		this.diffOfAll.addAll(diffFlux) ; 
	} 
	
	public void extractDifferenceBetweenActeursVsBpmnVsMfc(List<String> l3,List<String> l4,String acteurs) { 
		diffActWithBpmnAndMfc(acteurs,l3,l4) ;
		if(! (diffActWithBpmn.isEmpty())) { 
			this.diffOfAll.addAll(this.diffActWithBpmn) ;
			this.diffOfAll.addAll(this.diffActWithMfc) ; 
		}
	} 
	
	public void competeurErreurTotal() { 
		cpErTotal=cpErFlux+cpErActBpmnWithMfc+cpErActWithMfc+cpErActWithBpmn ;
	} 
	
	public void compteurPointCorrectTotal() { 
		this.nbPointsCorrect=cpCorrectActWithMfc+cpCorrectFl+cpCorrectActBpmnWithMfc+cpCorrectActMfc+cpCorrectActWithBpmn+cpCorrectActWithBpmn ; 
	}
	
	public double getLaMoyenne() { 
		int laMoyenne=0;
		if(cpErTotal==0) { 
			laMoyenne=20;
		} 
		else { 
			compteurPointCorrectTotal();
			int nbDePoint=nbPointsCorrect+cpErTotal;
			int noteForOneQuestion=20/nbDePoint ;
			laMoyenne=nbPointsCorrect*noteForOneQuestion;
		}
		if(laMoyenne<0) { 
			laMoyenne=0 ;
		}
		return laMoyenne;
	}
	
	public int getCpErTotal() {
		return cpErTotal;
	}

	public int getCpErFlux() {
		return cpErFlux;
	}

	public int getCpErActBpmnWithMfc() {
		return cpErActBpmnWithMfc;
	}

	public int getCpCorrectFl() {
		return cpCorrectFl;
	}

	public int getCpCorrectAct() {
		return cpCorrectActBpmnWithMfc;
	}

	public List<String> getDiffOfAll() {
		return diffOfAll;
	}

	public List<String> getDiffFlux() {
		return diffFlux;
	}

	public List<String> getCorrectFlux() {
		return correctFlux;
	}

	public List<String> getDiffActBpmnWithMfc() {
		return diffActBpmnWithMfc;
	}

	public List<String> getCorrectActBpmnWithMfc() {
		return correctActBpmnWithMfc;
	}

	public void setCpErTotal(int cpErTotal) {
		this.cpErTotal = cpErTotal;
	}

	public void setCpErFlux(int cpErFlux) {
		this.cpErFlux = cpErFlux;
	}

	public void setCpErActBpmnWithMfc(int cpErAct) {
		this.cpErActBpmnWithMfc = cpErAct;
	}

	public void setCpCorrectFl(int cpCorrectFl) {
		this.cpCorrectFl = cpCorrectFl;
	}

	public void setCpCorrectActBpmnWithMfc(int cpCorrectAct) {
		this.cpCorrectActBpmnWithMfc = cpCorrectAct;
	}

	public void setDiffOfAll(List<String> diffOfAll) {
		this.diffOfAll = diffOfAll;
	}

	public void setDiffFlux(List<String> diffFlux) {
		this.diffFlux = diffFlux;
	}

	public void setCorrectFlux(List<String> correctFlux) {
		this.correctFlux = correctFlux;
	}

	public void setDiffActBpmnWithMfc(List<String> diffActBpmnWithMfc) {
		this.diffActBpmnWithMfc = diffActBpmnWithMfc;
	}

	public void setCorrectActBpmnWithMfc(List<String> correctAct) {
		this.correctActBpmnWithMfc = correctAct;
	}
	
	public boolean getActIsInput() { 
		return this.boolActIsInput ; 
	} 
	
	public int getCpErActWithBpmn() { 
		return this.cpErActWithBpmn;
	} 
	
	public int getCpErActWithMfc() { 
		return this.cpErActWithMfc;
	} 
	
	public List<String> getDiffActWithBpmn() { 
		return this.diffActWithBpmn ; 
	} 
	public List<String> getDiffActWithMfc() { 
		return this.diffActWithMfc ; 
	} 
	
	public List<String> getCorrectActWithBpmn() { 
		return this.correctActWithBpmn;
	} 
	public List<String> getCorrectActWithMfc() { 
		return this.correctActWithMfc;
	} 
	
	public int getCpCorrectActMfc() { 
		return this.cpCorrectActMfc;
	} 
	
	public int getCpCorrectActWithBpmn() { 
		return this.cpCorrectActWithBpmn;
	} 
	
	
	public int getNbPointsCorrect() {
		return nbPointsCorrect;
	} 
	
	public List<String> getFlBpmn() { 
		return this.flBpmn;
	} 
	
	public List<String> getFlMfc() { 
		return this.flMfc;
	} 
	
	public List<String> getActBpmn() { 
		return this.actBpmn; 
	} 
	
	public List<String> getActMfc() { 
		return this.actMfc; 
	}
	
}