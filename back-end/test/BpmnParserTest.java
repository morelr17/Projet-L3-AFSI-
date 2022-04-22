
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.SAXException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import metier.*;
public class BpmnParserTest {

	private String xmlBPMN = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<bpmn2:tDefinitions xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL-XMI\" xmi:id=\"_wSbnUJipEeywH4imXz37fQ\" name=\"bpmnTT\" targetNamespace=\"http://genmymodel.com/bpmn2\">\n"
			+ "  <eAnnotations xmi:id=\"_wSbnUJipEeywH4imXz37fQ0\" source=\"genmymodel\">\n"
			+ "    <details xmi:id=\"_wSbnUJipEeywH4imXz37fQ00\" key=\"uuid\" value=\"_wSbnUJipEeywH4imXz37fQ\"/>\n"
			+ "    <details xmi:id=\"_wSbnUJipEeywH4imXz37fQ01\" key=\"author\" value=\"gccheker\"/>\n"
			+ "  </eAnnotations>\n"
			+ "  <bpmn2:rootElement xsi:type=\"bpmn2:tCollaboration\" xmi:id=\"_u6npEHrXEDqTsv_oMt1zow\" isClosed=\"true\">\n"
			+ "    <eAnnotations xmi:id=\"_u6npEHrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "      <details xmi:id=\"_u6npEHrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_u6npEHrXEDqTsv_oMt1zow\"/>\n"
			+ "    </eAnnotations>\n"
			+ "    <bpmn2:participant xmi:id=\"_u6zPQHrXEDqTsv_oMt1zow\" name=\"user1\" processRef=\"_wSbnUJipEeywH4imXz37fQ.xmi#_u6vk4HrXEDqTsv_oMt1zow\">\n"
			+ "      <eAnnotations xmi:id=\"_u6zPQHrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_u6zPQHrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_u6zPQHrXEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "    </bpmn2:participant>\n"
			+ "    <bpmn2:participant xmi:id=\"_yJuCUHrXEDqTsv_oMt1zow\" name=\"user2\" processRef=\"_wSbnUJipEeywH4imXz37fQ.xmi#_yJuCUXrXEDqTsv_oMt1zow\">\n"
			+ "      <eAnnotations xmi:id=\"_yJuCUHrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_yJuCUHrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_yJuCUHrXEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "    </bpmn2:participant>\n"
			+ "    <bpmn2:messageFlow xmi:id=\"_8Brl8HrXEDqTsv_oMt1zow\" name=\"F01:Facture\" sourceRef=\"_wSbnUJipEeywH4imXz37fQ.xmi#_33bMAHrXEDqTsv_oMt1zow\" targetRef=\"_wSbnUJipEeywH4imXz37fQ.xmi#_4w_RQHrXEDqTsv_oMt1zow\">\n"
			+ "      <eAnnotations xmi:id=\"_8Brl8HrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_8Brl8HrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_8Brl8HrXEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "    </bpmn2:messageFlow>\n"
			+ "    <bpmn2:messageFlow xmi:id=\"_O0YP8HrYEDqTsv_oMt1zow\" name=\"F02:Recu\" sourceRef=\"_wSbnUJipEeywH4imXz37fQ.xmi#_F2jZUHrYEDqTsv_oMt1zow\" targetRef=\"_wSbnUJipEeywH4imXz37fQ.xmi#_HNk2oHrYEDqTsv_oMt1zow\">\n"
			+ "      <eAnnotations xmi:id=\"_O0YP8HrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_O0YP8HrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_O0YP8HrYEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "    </bpmn2:messageFlow>\n"
			+ "  </bpmn2:rootElement>\n"
			+ "  <bpmn2:rootElement xsi:type=\"bpmn2:tProcess\" xmi:id=\"_u6vk4HrXEDqTsv_oMt1zow\" name=\"Processus\">\n"
			+ "    <eAnnotations xmi:id=\"_u6vk4HrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "      <details xmi:id=\"_u6vk4HrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_u6vk4HrXEDqTsv_oMt1zow\"/>\n"
			+ "    </eAnnotations>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tStartEvent\" xmi:id=\"_zfIWEHrXEDqTsv_oMt1zow\" name=\"Dbut\">\n"
			+ "      <eAnnotations xmi:id=\"_zfIWEHrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_zfIWEHrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_zfIWEHrXEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "      <bpmn2:outgoing>_AZ_qAHrYEDqTsv_oMt1zow</bpmn2:outgoing>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tIntermediateThrowEvent\" xmi:id=\"_33bMAHrXEDqTsv_oMt1zow\" name=\"\">\n"
			+ "      <eAnnotations xmi:id=\"_33bMAHrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_33bMAHrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_33bMAHrXEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "      <bpmn2:incoming>_AZ_qAHrYEDqTsv_oMt1zow</bpmn2:incoming>\n"
			+ "      <bpmn2:outgoing>_MVaTIHrYEDqTsv_oMt1zow</bpmn2:outgoing>\n"
			+ "      <bpmn2:eventDefinition xsi:type=\"bpmn2:tMessageEventDefinition\" xmi:id=\"_33caIHrXEDqTsv_oMt1zow\">\n"
			+ "        <eAnnotations xmi:id=\"_33caIHrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "          <details xmi:id=\"_33caIHrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_33caIHrXEDqTsv_oMt1zow\"/>\n"
			+ "        </eAnnotations>\n"
			+ "      </bpmn2:eventDefinition>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tSequenceFlow\" xmi:id=\"_AZ_qAHrYEDqTsv_oMt1zow\" sourceRef=\"_zfIWEHrXEDqTsv_oMt1zow\" targetRef=\"_33bMAHrXEDqTsv_oMt1zow\">\n"
			+ "      <eAnnotations xmi:id=\"_AZ_qAHrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_AZ_qAHrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_AZ_qAHrYEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tEndEvent\" xmi:id=\"_CO6kQHrYEDqTsv_oMt1zow\" name=\"Fin\">\n"
			+ "      <eAnnotations xmi:id=\"_CO6kQHrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_CO6kQHrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_CO6kQHrYEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "      <bpmn2:incoming>_M5jiAHrYEDqTsv_oMt1zow</bpmn2:incoming>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tIntermediateCatchEvent\" xmi:id=\"_HNk2oHrYEDqTsv_oMt1zow\" name=\"\">\n"
			+ "      <eAnnotations xmi:id=\"_HNk2oHrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_HNk2oHrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_HNk2oHrYEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "      <bpmn2:incoming>_MVaTIHrYEDqTsv_oMt1zow</bpmn2:incoming>\n"
			+ "      <bpmn2:outgoing>_M5jiAHrYEDqTsv_oMt1zow</bpmn2:outgoing>\n"
			+ "      <bpmn2:eventDefinition xsi:type=\"bpmn2:tMessageEventDefinition\" xmi:id=\"_HNk2oXrYEDqTsv_oMt1zow\">\n"
			+ "        <eAnnotations xmi:id=\"_HNk2oXrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "          <details xmi:id=\"_HNk2oXrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_HNk2oXrYEDqTsv_oMt1zow\"/>\n"
			+ "        </eAnnotations>\n"
			+ "      </bpmn2:eventDefinition>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tSequenceFlow\" xmi:id=\"_MVaTIHrYEDqTsv_oMt1zow\" sourceRef=\"_33bMAHrXEDqTsv_oMt1zow\" targetRef=\"_HNk2oHrYEDqTsv_oMt1zow\">\n"
			+ "      <eAnnotations xmi:id=\"_MVaTIHrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_MVaTIHrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_MVaTIHrYEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tSequenceFlow\" xmi:id=\"_M5jiAHrYEDqTsv_oMt1zow\" sourceRef=\"_HNk2oHrYEDqTsv_oMt1zow\" targetRef=\"_CO6kQHrYEDqTsv_oMt1zow\">\n"
			+ "      <eAnnotations xmi:id=\"_M5jiAHrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_M5jiAHrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_M5jiAHrYEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "  </bpmn2:rootElement>\n"
			+ "  <bpmn2:rootElement xsi:type=\"bpmn2:tProcess\" xmi:id=\"_yJuCUXrXEDqTsv_oMt1zow\" name=\"Processus\">\n"
			+ "    <eAnnotations xmi:id=\"_yJuCUXrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "      <details xmi:id=\"_yJuCUXrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_yJuCUXrXEDqTsv_oMt1zow\"/>\n"
			+ "    </eAnnotations>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tStartEvent\" xmi:id=\"_z5qV8HrXEDqTsv_oMt1zow\" name=\"Dbut\">\n"
			+ "      <eAnnotations xmi:id=\"_z5qV8HrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_z5qV8HrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_z5qV8HrXEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "      <bpmn2:outgoing>_A8D1QHrYEDqTsv_oMt1zow</bpmn2:outgoing>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tIntermediateCatchEvent\" xmi:id=\"_4w_RQHrXEDqTsv_oMt1zow\" name=\"\">\n"
			+ "      <eAnnotations xmi:id=\"_4w_RQHrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_4w_RQHrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_4w_RQHrXEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "      <bpmn2:incoming>_A8D1QHrYEDqTsv_oMt1zow</bpmn2:incoming>\n"
			+ "      <bpmn2:outgoing>_ElbvsHrYEDqTsv_oMt1zow</bpmn2:outgoing>\n"
			+ "      <bpmn2:eventDefinition xsi:type=\"bpmn2:tMessageEventDefinition\" xmi:id=\"_4w_4UHrXEDqTsv_oMt1zow\">\n"
			+ "        <eAnnotations xmi:id=\"_4w_4UHrXEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "          <details xmi:id=\"_4w_4UHrXEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_4w_4UHrXEDqTsv_oMt1zow\"/>\n"
			+ "        </eAnnotations>\n"
			+ "      </bpmn2:eventDefinition>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tSequenceFlow\" xmi:id=\"_A8D1QHrYEDqTsv_oMt1zow\" sourceRef=\"_z5qV8HrXEDqTsv_oMt1zow\" targetRef=\"_4w_RQHrXEDqTsv_oMt1zow\">\n"
			+ "      <eAnnotations xmi:id=\"_A8D1QHrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_A8D1QHrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_A8D1QHrYEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tEndEvent\" xmi:id=\"_Bl2ZIHrYEDqTsv_oMt1zow\" name=\"Fin\">\n"
			+ "      <eAnnotations xmi:id=\"_Bl2ZIHrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_Bl2ZIHrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_Bl2ZIHrYEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "      <bpmn2:incoming>_F2kAYXrYEDqTsv_oMt1zow</bpmn2:incoming>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tSequenceFlow\" xmi:id=\"_ElbvsHrYEDqTsv_oMt1zow\" sourceRef=\"_4w_RQHrXEDqTsv_oMt1zow\" targetRef=\"_F2jZUHrYEDqTsv_oMt1zow\">\n"
			+ "      <eAnnotations xmi:id=\"_ElbvsHrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_ElbvsHrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_ElbvsHrYEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tSequenceFlow\" xmi:id=\"_F2kAYXrYEDqTsv_oMt1zow\" sourceRef=\"_F2jZUHrYEDqTsv_oMt1zow\" targetRef=\"_Bl2ZIHrYEDqTsv_oMt1zow\">\n"
			+ "      <eAnnotations xmi:id=\"_F2kAYXrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_F2kAYXrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_F2kAYXrYEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "    <bpmn2:flowElement xsi:type=\"bpmn2:tIntermediateThrowEvent\" xmi:id=\"_F2jZUHrYEDqTsv_oMt1zow\" name=\"\">\n"
			+ "      <eAnnotations xmi:id=\"_F2jZUHrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "        <details xmi:id=\"_F2jZUHrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_F2jZUHrYEDqTsv_oMt1zow\"/>\n"
			+ "      </eAnnotations>\n"
			+ "      <bpmn2:incoming>_ElbvsHrYEDqTsv_oMt1zow</bpmn2:incoming>\n"
			+ "      <bpmn2:outgoing>_F2kAYXrYEDqTsv_oMt1zow</bpmn2:outgoing>\n"
			+ "      <bpmn2:eventDefinition xsi:type=\"bpmn2:tMessageEventDefinition\" xmi:id=\"_F2kAYHrYEDqTsv_oMt1zow\">\n"
			+ "        <eAnnotations xmi:id=\"_F2kAYHrYEDqTsv_oMt1zow0\" source=\"genmymodel\">\n"
			+ "          <details xmi:id=\"_F2kAYHrYEDqTsv_oMt1zow00\" key=\"uuid\" value=\"_F2kAYHrYEDqTsv_oMt1zow\"/>\n"
			+ "        </eAnnotations>\n"
			+ "      </bpmn2:eventDefinition>\n"
			+ "    </bpmn2:flowElement>\n"
			+ "  </bpmn2:rootElement>\n"
			+ "</bpmn2:tDefinitions>"; 
	
	protected BpmnParser bpmnParser;
	List<String> listeVide = new ArrayList<>();
	List<String> lesActeurs=new ArrayList<>() ;
	List<String> lesFlux=new ArrayList<>() ;

	
	@BeforeEach 
	public void init() { 
		bpmnParser= new BpmnParser(); 
		lesActeurs.add("user1"); lesActeurs.add("user2");
		lesFlux.add("F01:Facture"); lesFlux.add("F02:Recu");
		
	}
    /**
     * Test if the list is empty at initialization
     * @throws ParserConfigurationException 
     * @throws IOException 
     * @throws SAXException 
     */
	@Test 
	public void testInit() {
		List<String> l = new ArrayList<>();
		assertEquals(l,bpmnParser.getListFluxBpmn());
		assertEquals(l,bpmnParser.getListActeursBpmn());
	}
	
	/**
	 * Test if the function parsingFlux parse the flux 
	 */
	@Test
	public void parsingFluxTest() {
		bpmnParser.parseBpmnMethode(xmlBPMN);
		assertEquals(lesFlux,bpmnParser.getListFluxBpmn());
	}
	
	/**
	 * Test if the function parsingActors parse the actors
	 */
	@Test 
	public void parsingActorsTest() {
		bpmnParser.parseBpmnMethode(xmlBPMN);
		assertEquals(lesActeurs,bpmnParser.getListActeursBpmn());
	}
	
	/**
	 * Test if the function parseBpmnMethodeTest parse the actors and flux
	 */
	@Test 
	public void parseBpmnMethodeTest (){
		assertEquals(listeVide,bpmnParser.getListFluxBpmn());
		assertEquals(listeVide,bpmnParser.getListActeursBpmn());
		bpmnParser.parseBpmnMethode(xmlBPMN);

		assertEquals(lesActeurs,bpmnParser.getListActeursBpmn());
		assertEquals(lesFlux,bpmnParser.getListFluxBpmn());
	}
	
}

	

