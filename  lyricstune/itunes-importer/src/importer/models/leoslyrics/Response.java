package importer.models.leoslyrics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name ="leoslyrics" )
public class Response {
	@XmlElement	
	public SearchResult searchResults;
	
	@XmlElement
	public Lyric lyric;

	public boolean exactMatchFound(){
	     return searchResults.exactMatchFound();

	}

	public Result getExactResult() {
		for(Result result : searchResults.results){
			if(result.isExactMatch())return result;
		}
		
		
		return null;
	}
}
