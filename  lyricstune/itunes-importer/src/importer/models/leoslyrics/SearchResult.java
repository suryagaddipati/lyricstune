package importer.models.leoslyrics;

import importer.models.common.ISearchResult;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class SearchResult  {
	@XmlElement(name="result")
	public  List<Result> results= new ArrayList<Result>();
	
	
	
	@Override
	public String toString() {
		return results.toString() ;
	}
	
	public boolean exactMatchFound() {
		
		for(Result result : results){
			if(result.isExactMatch()) return true;
		}
		
		return false;
	}

}
