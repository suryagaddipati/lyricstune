package importer.application;

import importer.models.common.Track;
import importer.ui.views.ITrackSelectionListener;

import java.util.ArrayList;
import java.util.List;

public class EventMediator {
	private static List<ITrackSelectionListener> listeners = new ArrayList<ITrackSelectionListener>();
	public static void fireTrackSelection(Track selectedTrack) {
		if( selectedTrack == null ) return;
		for (ITrackSelectionListener listener : listeners) {
			listener.onTrackSelection(selectedTrack);
		}
	}
	
	public static void addTrackSelectionListener(ITrackSelectionListener listener){
		listeners.add(listener);
	}
	

}
