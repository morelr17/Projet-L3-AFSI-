
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import metier.ComparateurList;

public class ComparateurListTest {
	
	protected ComparateurList comp;
	
	 @Test
	    public void testDiff2List() {
	        comp = new ComparateurList();
	        ArrayList<String> al1 = new ArrayList<>();
	        al1.add("act1");
	        al1.add("act2");
	        ArrayList<String> al2 = new ArrayList<>();
	        al2.add("act1");
	        al2.add("act3");
	        List<String> diff=new ArrayList<>(); 
	        diff.add("act2");
	        diff.add("act3");
	        assertEquals(diff, comp.diff2List(al1,al2));
	        
	    } 
	 
	 @Test
	    public void testSameArrayList() {
	        comp = new ComparateurList();
	        List<String> al1 = new ArrayList<>();
	        ArrayList<String> sameList = new ArrayList<>();
	        al1.add("act1");
	        al1.add("act2");
	        sameList.add("act2");
	        List<String> al2 = new ArrayList<>();
	        al2.add("act2");
	        al2.add("act3");
	        assertEquals(sameList, comp.sameArrayList(al1,al2));
	        
	    }
	   
	   
}

	

