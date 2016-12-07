package xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Event-based parser.. reads top-to-bottom instead of loading entire document.
 * as it reads, it invokes custom handler method when event occurs
 * 
 * read-only do not use for deeply nested xml much faster than DOM.. better for
 * querying
 * 
 * @author Owner
 *
 */
public class GameStopSAX {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		InputStream is = GameStopSAX.class.getClassLoader().getResourceAsStream("gamestop.xml");
		RetroGameHandler handler = new RetroGameHandler(2000);
		parser.parse(is, handler);
		System.out.println("You have " + handler.getRetroGameCount() + " retro games in stock.");
	}

}

class RetroGameHandler extends DefaultHandler {
	// anything after this is not 'retro' enough
	private int retroYear;
	private boolean foundReleaseYear;
	private int retroGameCount = 0;

	public RetroGameHandler(int retroYear) {
		super();
		this.retroYear = retroYear;
	}

	public int getRetroGameCount() {
		return retroGameCount;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// System.out.println("chars");
		if (foundReleaseYear) {
			// System.out.println(new String(ch, start, length));
			int year = Integer.parseInt(new String(ch, start, length));
			if (year < retroYear)
				retroGameCount++;
			foundReleaseYear = false;
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// System.out.println("startElement");
		if (qName.equals("release")) {
			foundReleaseYear = true;
		}
	}
}
