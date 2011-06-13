package importer.ui.itunes.search;

import importer.application.EventMediator;
import importer.models.common.Track;
import importer.services.itunes.Itunes;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;

public class ItunesSearchPanel extends Composite {

	private TableViewer viewer;

	public ItunesSearchPanel(Composite parent, int style) {
		super(parent, style);
		createControls();
		GridLayoutFactory.fillDefaults().applyTo(this);
	}

	private void createControls() {
		org.eclipse.swt.widgets.Label resultsLabel = new org.eclipse.swt.widgets.Label(
				this, SWT.NONE);
		resultsLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		resultsLabel.setText("Tracks");
		
		viewer = new TableViewer(this, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);

		viewer.getTable().setHeaderVisible(true);

		String [] columns = new String[]{
				"Track Name" , "Artist Name"
		};
		int [] columnAlignments = new int[]{
				250, 200
		};

		for (int i = 0; i < columnAlignments.length; i++) {
			TableColumn tc = new TableColumn(viewer.getTable(), columnAlignments[i]);
			tc.setText(columns[i]);
			tc.setWidth(columnAlignments[i]);
		}

		viewer.setContentProvider(new ArrayContentProvider()) ;
		viewer.setLabelProvider(new TrackInfoLabelProvider());
		viewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));		
	    addSelectionChangeListener();
		
	}


	private void addSelectionChangeListener() {
		viewer.addSelectionChangedListener(new ISelectionChangedListener(){
			public void selectionChanged(SelectionChangedEvent event) {
			  Track selectedTrack = (Track)	((IStructuredSelection) event.getSelection()).getFirstElement();
			EventMediator.fireTrackSelection (selectedTrack);
				
			}
			
		});
	}

	
	
	
	
	
	Itunes itunes = Itunes.getInstance();
	public void next() {
			
		viewer.setInput(itunes.nextTracksWithoutLyrics(5));
	}
}
