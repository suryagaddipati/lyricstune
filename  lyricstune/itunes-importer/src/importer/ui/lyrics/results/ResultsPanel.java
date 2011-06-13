package importer.ui.lyrics.results;

import importer.application.EventMediator;
import importer.models.common.ISearchResult;
import importer.models.common.Track;
import importer.services.itunes.Itunes;
import importer.services.lyrics.LyricProviders;
import importer.ui.views.ITrackSelectionListener;

import java.util.List;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;

public class ResultsPanel extends Composite implements ITrackSelectionListener {

	private TableViewer viewer;
	private StackLayout resultLayout;
	private Label resultsMessage;
	private Track selectedTrack;

	public ResultsPanel(Composite parent, int style) {
		super(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(this);
		createControls();
		EventMediator.addTrackSelectionListener(this);

	}

	private void createControls() {
		org.eclipse.swt.widgets.Button applyResultButton = new Button(this,SWT.PUSH);
		applyResultButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		applyResultButton.setText("Set Lyrics");
		
		addListener(applyResultButton);

		Label resultsLabel = new org.eclipse.swt.widgets.Label(
				this, SWT.NONE);
		resultsLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		resultsLabel.setText("Search Results");


		Composite resultsComp = new Composite(this, SWT.BORDER);
		resultsComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));


		resultLayout = new StackLayout();
		resultsComp.setLayout(resultLayout);

		resultsMessage = new Label(resultsComp, SWT.NONE);
		resultsMessage.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));

		resultsMessage.setText("Select a track in the left to search.");
		resultLayout.topControl = resultsMessage;
		createResultsTable(resultsComp);
	}

	private void addListener(Button applyResultButton) {
		
		applyResultButton.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
			   if(	viewer.getSelection() != null ){
				   ISearchResult selectedSearch = (ISearchResult) ((IStructuredSelection)viewer.getSelection()).getFirstElement();
				   Itunes.getInstance().addLyrics(selectedTrack, selectedSearch.getLyrics());
			   }
				
			}
		});
		
	}

	private void createResultsTable(Composite resultsComp) {
		viewer = new TableViewer(resultsComp, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);

		viewer.getTable().setHeaderVisible(true);

		String [] columns = new String[]{
				"Track Name", "Artist Name" , "Exact Match?" 
		};
		int [] columnAlignments = new int[]{
				200, 200,200
		};

		for (int i = 0; i < columnAlignments.length; i++) {
			TableColumn tc = new TableColumn(viewer.getTable(), columnAlignments[i]);
			tc.setText(columns[i]);
			tc.setWidth(columnAlignments[i]);
		}

		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new ResultsInfoLabelProvider());

	}

	public void onTrackSelection(Track selectedTrack) {
		this.selectedTrack = selectedTrack;
		resultsMessage.setText("searching....");
		resultLayout.topControl = resultsMessage;
		resultsMessage.getParent().layout();

		List<? extends ISearchResult> lyrics = LyricProviders.LEOSLYRICS.getProvider().getLyricsFor(selectedTrack);
		viewer.setInput(lyrics);

		resultLayout.topControl = viewer.getControl();
		resultsMessage.getParent().layout();

	}


}
