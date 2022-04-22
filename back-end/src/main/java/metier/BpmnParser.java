package metier;

import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BpmnParser {
	private List<String> listFluxBpmn = new ArrayList<>();
	private List<String> listActeursBpmn = new ArrayList<>();

	/* Constructor of BPMNParser */
	public BpmnParser(List<String> listFluxBpmn, List<String> listActeursBpmn) {
		this.listFluxBpmn = listFluxBpmn;
		this.listActeursBpmn = listActeursBpmn;

	}

	public BpmnParser() {
		super();
	}

	/**
	 * take one XML file contents and Parse the flux and actors of the BPMN
	 * 
	 * @param xmlRecords the contents of the files XML
	 */
	public void parseBpmnMethode(String xmlRecords) {
		try {
			// create a Document for the result
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			// create new inputSource for read the file
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlRecords));
			Document doc = db.parse(is);

			// differents NodeList who we need to parse
			NodeList fluxV1 = doc.getElementsByTagName("bpmn:messageFlow");
			NodeList acteursV1 = doc.getElementsByTagName("bpmn:participant");
			NodeList fluxV2 = doc.getElementsByTagName("bpmn2:messageFlow");
			NodeList acteursV2 = doc.getElementsByTagName("bpmn2:participant");

			// Parsing of the Flux and actors
			this.parsingFlux(fluxV1);
			this.parsingFlux(fluxV2);
			this.parsingActors(acteursV1);
			this.parsingActors(acteursV2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get all Flux from the model
	 * 
	 * @param node the node who we need to parse
	 */
	public void parsingFlux(NodeList node) {
		for (int i = 0; i < node.getLength(); i++) {
			Element element = (Element) node.item(i);
			listFluxBpmn.add(element.getAttribute("name").replaceFirst(" ", ""));
		}
	}

	/**
	 * Get all actors from the model
	 * 
	 * @param node the node who we need to parse
	 */
	public void parsingActors(NodeList node) {
		for (int i = 0; i < node.getLength(); i++) {
			Element element = (Element) node.item(i);
			listActeursBpmn.add(element.getAttribute("name").replaceFirst(" ", ""));
		}
	}

	/**
	 * @return the list of Flux BPMN
	 */
	public List<String> getListFluxBpmn() {
		return this.listFluxBpmn;
	}

	/**
	 * set the new list for the list listFluxBPMN
	 * 
	 * @param listFluxBpmn the new list who we want add
	 */
	public void setListFluxBpmn(List<String> listFluxBpmn) {
		this.listFluxBpmn = listFluxBpmn;
	}

	/**
	 * @return the list of Actors BPMN
	 */
	public List<String> getListActeursBpmn() {
		return this.listActeursBpmn;
	}

	/**
	 * set the new list for the list listActeursBpmn
	 * 
	 * @param listActeursBpmn the new list who we want add
	 */
	public void setListActeursBpmn(List<String> listActeursBpmn) {
		this.listActeursBpmn = listActeursBpmn;
	}

}
