/**
 * 
 */
package importer.ui.lyrics.results;

import importer.models.leoslyrics.Result;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public	class ResultsInfoLabelProvider extends LabelProvider implements
ITableLabelProvider {
	public String getColumnText(Object obj, int index) {

		Result result = (Result)obj;
		switch(index){
		case 0 :
			return result.title;
		case 1 :
			return result.artist.toString();

		case 2 :
			return result.isExactMatch()?"YES":"NO";//track.
		}
		return getText(obj);
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}


}