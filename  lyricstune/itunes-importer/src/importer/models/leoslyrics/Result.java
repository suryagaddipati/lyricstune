/**
 * 
 */
package importer.models.leoslyrics;

import importer.models.common.ISearchResult;
import importer.services.lyrics.LeosLyricsLyricsProvider;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Result implements ISearchResult {
	@XmlAttribute  
	public int id;
	@XmlAttribute
	public String hid;
	@XmlAttribute
	public String exactMatch;
	
	@XmlElement
	public Artist artist;
	@XmlElement
	public String title;
	
	@Override
	public String toString() {
		return "Id : " + id + " hid :" + "exactMatch : " + exactMatch +" Artist : " + artist.toString();
	}
	public boolean isExactMatch(){
		return "true".equals(exactMatch);
	}
	public String artist() {
		return artist.toString();
	}

	public String trackName() {
		return title;
	}
	public String getLyrics() {
		return new LeosLyricsLyricsProvider().getLyrics(hid);
	}
}