package importer.services.itunes;

import importer.models.common.Track;

import java.util.List;

public abstract class Itunes {

	public static final Itunes getInstance() {
		return new ItunesMAC();
	}
	

	public abstract List<Track> nextTracksWithoutLyrics(int numTracks) ;
	
	public abstract void addLyrics(Track track , String lyrics);

}