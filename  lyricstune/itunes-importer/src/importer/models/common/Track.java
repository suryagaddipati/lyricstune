package importer.models.common;


public class Track {
	private String artist;
	private String trackName;
	private String trackNumber;

	public Track(String artist, String trackName, String trackNumber) {
		super();
		this.artist = artist;
		this.trackName = trackName;
		this.trackNumber = trackNumber;
	}

	public String getArtist() {
		return artist;
	}

	public String getTrackName() {
		return trackName;
	}

	
	@Override
	public String toString() {

		return trackName+ "  : " +artist +"  ";
	}

	public String getTrackNumber() {
		return trackNumber;
	}


	
	
	
}
