package importer.models.common;

public interface ISearchResult {
	String artist();
	String trackName();
	boolean isExactMatch();
	String getLyrics();
}
