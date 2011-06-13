package importer.services.itunes;


import importer.models.common.Track;
import importer.models.leoslyrics.Result;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ItunesMAC extends Itunes {
	Runtime rt = Runtime.getRuntime();
	private String playListName="iphone";
	int currentTrkIndx = 1;
	public  List<Track> nextTracksWithoutLyrics(int numTracks) {
		ArrayList<Track> returnVal = new ArrayList<Track>();
		int i = 0;
		while (i <= numTracks){
			
			System.out.println("Track : " + currentTrkIndx);
			if(!hasLyrics()){
				Track track = makeTrack();
				
				returnVal.add(track);
				i++;
			}
			currentTrkIndx++;
		}
		
		return returnVal;
	}

	
	


	public Track makeTrack(){
		try {


			String[] args = { "osascript", "-e","tell app \"iTunes\" to artist of  track "+ currentTrkIndx+" of playlist \""+playListName+"\" as string"};
			final Process proc = rt.exec(args);
			InputStream in = proc.getInputStream();
			String artist = new DataInputStream(in).readLine();
			in.close();

			String[]   args1 = { "osascript", "-e","tell app \"iTunes\" to name of  track "+ currentTrkIndx+" of playlist \""+playListName+"\" as string"};
			final Process proc1 = rt.exec(args1);
			in = proc1.getInputStream();
			String trackName = new DataInputStream(in).readLine();
			in.close();
			return new Track(artist,trackName, ""+currentTrkIndx);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;

	}

	boolean hasLyrics(){

		try {
			String[] args = { "osascript", "-e","tell app \"iTunes\" to lyrics of  track "+ currentTrkIndx+" of playlist \""+playListName+"\" as string"};
			final Process proc = rt.exec(args);
			
			InputStream in = proc.getInputStream();
			String lyrics = new DataInputStream(in).readLine();

			in.close();
			if(lyrics ==null || "".equals(lyrics)){
				return false;
			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}





	@Override
	public void addLyrics(Track track, String lyrics) {
		
		try {
			lyrics.replaceAll( "\""," ");
			String[] args = { "osascript", "-e","tell app \"iTunes\" \n tell track "+track.getTrackNumber()+ " of playlist \""+playListName+"\" to set lyrics to \"" + lyrics +"\" \n end tell"};
			System.out.println(args[2]);
			rt.exec(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public void applyResult(Result result) {
		
		
		
	}


	
	
}
