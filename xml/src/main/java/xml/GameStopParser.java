package xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * DOM parser Tree-based; loads the entire document into memory
 * 
 * @author Owner
 *
 */
public class GameStopParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		InputStream stream = GameStopParser.class
				.getClassLoader()
				.getResourceAsStream("gamestop.xml");
		Document document = getXMLDocument(stream);
		// traverse the document (tree-based)
		Element root = document.getDocumentElement(); // root node
		//System.out.println(root.getNodeName());
		NodeList nodes = root.getChildNodes(); // get children
		// loop through all children
		section : for(int i = 0; i < nodes.getLength(); i++){
			Node node = nodes.item(i);
			// check if it's actually a node first
			if(node.getNodeType() == Node.ELEMENT_NODE){
				// all my sections
				// get node name and attribute value for "name"
				String attrValue = node.getAttributes()
						.getNamedItem("name").getNodeValue();
				System.out.println(node.getNodeName() + 
						" : " + attrValue);	
				
				// get all the games for the section
				NodeList games = node.getChildNodes();
				games : for(int j=0; j<games.getLength(); j++){
					// print data for each game
					Node game = games.item(j);
					if(game.getNodeType() ==
							Node.ELEMENT_NODE){
						System.out.println("\t" + 
							game.getNodeName());
					}
				}
			}		
		}
	}

	public static Document getXMLDocument(InputStream stream) 
			throws ParserConfigurationException, 
			SAXException, IOException {
		/*
		 * DocumentBuilderFactory DocumentBuilder Document
		 */
		DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = factory
				.newDocumentBuilder();
		Document document = builder.parse(stream);
		return document;
	}
}
