/**
 * 
 */
package importer.ui.itunes.search;

import importer.models.common.Track;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class TrackInfoLabelProvider extends LabelProvider implements
ITableLabelProvider {
	public String getColumnText(Object obj, int index) {

		Track track = (Track)obj;
		switch(index){
		case 0 :
			return track.getTrackName();
		case 1 :
			return track.getArtist();
		}
		return getText(obj);
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}


}