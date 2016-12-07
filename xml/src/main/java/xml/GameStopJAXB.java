package xml;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class GameStopJAXB {

	public static void main(String[] args) throws JAXBException {
		JAXBContext ctxt = JAXBContext.newInstance(Gamestop.class);
		Unmarshaller beanMaker = ctxt.createUnmarshaller();
		InputStream stream = GameStopDOM.class
				.getClassLoader()
				.getResourceAsStream("gamestop.xml");
		
		Gamestop data = (Gamestop) beanMaker.unmarshal(stream);
		System.out.println(data);
		
		Section ds = new Section(); ds.setName("Nintendo DS");
		data.getSections().add(ds);

		// 'copy' elsewhere ---> Marshall JavaBean -> XML
		Marshaller xmlMaker = ctxt.createMarshaller();
		// "pretty" the output
		xmlMaker.setProperty("jaxb.formatted.output", true);
		
		xmlMaker.marshal(data,
				new File("copy.xml"));
		System.out.println("Complete");
	}
	
}
@XmlRootElement(name="gamestop")
class Gamestop{
	private List<Section> sections; // has-a
	public List<Section> getSections() {
		return sections;
	}
	@XmlElement(name="section")
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	@Override
	public String toString() {
		return "Gamestop [sections=" + sections + "]";
	}
	
}

				// name is name of XML tag
@XmlRootElement(name="section")
class Section{
	private String name;
	private List<Game> games;
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="game")
	public void setGames(List<Game> games) {
		this.games = games;
	}
	public String getName() {
		return name;
	}
	public List<Game> getGames() {
		return games;
	}
	@Override
	public String toString() {
		return "Section [name=" + name + ", games=" + games + "]";
	}
	
}

@XmlRootElement
class Game{
	private String title;
	private int release;
	private String genre;
	private double price;
	
	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRelease() {
		return release;
	}
	@XmlElement
	public void setRelease(int release) {
		this.release = release;
	}
	public String getGenre() {
		return genre;
	}
	@XmlElement
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getPrice() {
		return price;
	}
	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Game [title=" + title + ", release=" + release + ", genre=" + genre + ", price=" + price + "]";
	}
	
}