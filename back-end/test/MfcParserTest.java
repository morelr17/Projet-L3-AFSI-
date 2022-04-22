

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import metier.*;

public class MfcParserTest {

	private String mfcXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<mxfile host=\"app.diagrams.net\" modified=\"2022-03-06T17:40:39.290Z\" agent=\"5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36\" etag=\"IBBA3JNx5AA0y317cPgB\" version=\"16.6.6\" type=\"device\">\n"
			+ "  <diagram id=\"yaR8N0y67tRqn7zQOQpr\" name=\"Page-1\">\n"
			+ "    <mxGraphModel dx=\"1351\" dy=\"707\" grid=\"1\" gridSize=\"10\" guides=\"1\" tooltips=\"1\" connect=\"1\" arrows=\"1\" fold=\"1\" page=\"1\" pageScale=\"1\" pageWidth=\"827\" pageHeight=\"1169\" math=\"0\" shadow=\"0\">\n"
			+ "      <root>\n" + "        <mxCell id=\"0\" />\n" + "        <mxCell id=\"1\" parent=\"0\" />\n"
			+ "        <mxCell id=\"wItf2btd2XwO8WPsTBu5-1\" value=\"\" style=\"whiteSpace=wrap;html=1;aspect=fixed;\" vertex=\"1\" parent=\"1\">\n"
			+ "          <mxGeometry x=\"50\" y=\"150\" width=\"220\" height=\"220\" as=\"geometry\" />\n"
			+ "        </mxCell>\n"
			+ "        <mxCell id=\"wItf2btd2XwO8WPsTBu5-3\" value=\"user1\" style=\"ellipse;whiteSpace=wrap;html=1;\" vertex=\"1\" parent=\"1\">\n"
			+ "          <mxGeometry x=\"400\" y=\"150\" width=\"120\" height=\"80\" as=\"geometry\" />\n"
			+ "        </mxCell>\n"
			+ "        <mxCell id=\"wItf2btd2XwO8WPsTBu5-4\" value=\"user2\" style=\"ellipse;whiteSpace=wrap;html=1;\" vertex=\"1\" parent=\"1\">\n"
			+ "          <mxGeometry x=\"420\" y=\"260\" width=\"120\" height=\"80\" as=\"geometry\" />\n"
			+ "        </mxCell>\n"
			+ "        <mxCell id=\"wItf2btd2XwO8WPsTBu5-7\" value=\"\" style=\"endArrow=classic;html=1;rounded=0;entryX=1;entryY=0.5;entryDx=0;entryDy=0;exitX=0;exitY=0.5;exitDx=0;exitDy=0;\" edge=\"1\" parent=\"1\" source=\"wItf2btd2XwO8WPsTBu5-3\" target=\"wItf2btd2XwO8WPsTBu5-1\">\n"
			+ "          <mxGeometry width=\"50\" height=\"50\" relative=\"1\" as=\"geometry\">\n"
			+ "            <mxPoint x=\"560\" y=\"450\" as=\"sourcePoint\" />\n"
			+ "            <mxPoint x=\"610\" y=\"400\" as=\"targetPoint\" />\n" + "          </mxGeometry>\n"
			+ "        </mxCell>\n"
			+ "        <mxCell id=\"wItf2btd2XwO8WPsTBu5-9\" value=\"F01: Facture\" style=\"edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];\" vertex=\"1\" connectable=\"0\" parent=\"wItf2btd2XwO8WPsTBu5-7\">\n"
			+ "          <mxGeometry x=\"0.1817\" relative=\"1\" as=\"geometry\">\n"
			+ "            <mxPoint as=\"offset\" />\n" + "          </mxGeometry>\n" + "        </mxCell>\n"
			+ "        <mxCell id=\"wItf2btd2XwO8WPsTBu5-8\" value=\"\" style=\"endArrow=classic;html=1;rounded=0;exitX=0.991;exitY=0.668;exitDx=0;exitDy=0;exitPerimeter=0;\" edge=\"1\" parent=\"1\" source=\"wItf2btd2XwO8WPsTBu5-1\" target=\"wItf2btd2XwO8WPsTBu5-4\">\n"
			+ "          <mxGeometry width=\"50\" height=\"50\" relative=\"1\" as=\"geometry\">\n"
			+ "            <mxPoint x=\"560\" y=\"450\" as=\"sourcePoint\" />\n"
			+ "            <mxPoint x=\"610\" y=\"400\" as=\"targetPoint\" />\n" + "          </mxGeometry>\n"
			+ "        </mxCell>\n"
			+ "        <mxCell id=\"wItf2btd2XwO8WPsTBu5-10\" value=\"F02 : Recu\" style=\"edgeLabel;html=1;align=center;verticalAlign=middle;resizable=0;points=[];\" vertex=\"1\" connectable=\"0\" parent=\"wItf2btd2XwO8WPsTBu5-8\">\n"
			+ "          <mxGeometry x=\"-0.2343\" y=\"-3\" relative=\"1\" as=\"geometry\">\n"
			+ "            <mxPoint as=\"offset\" />\n" + "          </mxGeometry>\n" + "        </mxCell>\n"
			+ "        <mxCell id=\"wItf2btd2XwO8WPsTBu5-11\" value=\"Activite001\" style=\"rounded=1;whiteSpace=wrap;html=1;\" vertex=\"1\" parent=\"1\">\n"
			+ "          <mxGeometry x=\"100\" y=\"200\" width=\"120\" height=\"60\" as=\"geometry\" />\n"
			+ "        </mxCell>\n" + "      </root>\n" + "    </mxGraphModel>\n" + "  </diagram>\n" + "</mxfile>";


	protected MfcParser mf;
	
	@BeforeEach
	public void init() { 
		this.mf=new MfcParser() ;
	} 
	
	@Test
	public void testParsingActeurs() { 
		List<String> lesActeursParsed=new ArrayList<> (); 
		List<String> lesActeurs=lesActeursParsed; 
		lesActeurs.add("user1"); lesActeursParsed.add("user2");
		mf.parseMfcMethode(mfcXml);
		lesActeursParsed=mf.getListActeursMfc();
		assertEquals(lesActeurs,lesActeursParsed);
	}
	
	@Test
	public void testParsingFlux() { 
		List<String> lesFlux=new ArrayList<> (); 
		lesFlux.add("F01: Facture"); lesFlux.add("F02 : Recu");
		mf.parseMfcMethode(mfcXml);
		assertEquals(mf.getListFluxMfc(),lesFlux);
	}
	
}
