package importer.services.itunes;

import importer.models.common.Track;

import java.util.Arrays;
import java.util.List;

public class ItunesWindows extends Itunes {

	@Override
	public void addLyrics(Track track, String lyrics) {
		System.out.println("Adding lyrics :" + lyrics);
		
	}

	@Override
	public List<Track> nextTracksWithoutLyrics(int numTracks) {
		return Arrays.asList(makeTrack("Nirvana","Smells Like Teen Spirit"),
				makeTrack("Smashing Pumpkins","Cherub Rock")     );
	}

	private Track makeTrack(String artist, String track) {
		return new Track(artist,track,"-1") ;
	}

}
