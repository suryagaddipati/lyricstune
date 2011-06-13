package importer.services.lyrics;

import importer.models.common.Track;
import importer.models.leoslyrics.Response;
import importer.models.leoslyrics.Result;

import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LeosLyricsLyricsProvider extends LyricsProvider {
	private static	JAXBContext jaxbContext;
	private static	Unmarshaller umarshaller;
	{
		try {
			jaxbContext=JAXBContext.newInstance("importer.models.leoslyrics");
			umarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
	public String getLyrics(String hid ) {
		try {
			URL url = new URL("http://api.leoslyrics.com/api_lyrics.php?auth=duane&hid="+hid+"=");
			Response lyricResponse = ((Response) umarshaller.unmarshal(url));
			if(lyricResponse.lyric !=null){
				return lyricResponse.lyric.text;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	private  String makeUrl(String artist , String trackName){
		return "http://api.leoslyrics.com/api_search.php?auth=duane&artist="+artist+"&songtitle="+trackName;
	}
	@Override
	public List<Result> getLyricsFor(Track track) {
		URL url;
		 try {
			url = new URL(makeUrl(track.getArtist(), track.getTrackName()));
			Response 	response = (Response) umarshaller.unmarshal(url);
			return response.searchResults.results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
