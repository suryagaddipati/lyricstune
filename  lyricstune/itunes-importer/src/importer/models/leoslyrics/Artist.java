package importer.models.leoslyrics;

import javax.xml.bind.annotation.XmlElement;

public class Artist {
	@XmlElement
	private String name;
	
	@Override
	public String toString() {
		return name;
	}
}
