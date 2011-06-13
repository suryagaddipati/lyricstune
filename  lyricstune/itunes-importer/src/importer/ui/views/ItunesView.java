package importer.ui.views;


import importer.services.itunes.Itunes;
import importer.services.itunes.ItunesMAC;
import importer.ui.itunes.search.ItunesSearchPanel;
import importer.ui.lyrics.results.ResultsPanel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash; 
import org.eclipse.ui.part.ViewPart;



public class ItunesView extends ViewPart {
	public static final String ID = "itunes_tagger.view";


	

	public static	Itunes finder = ItunesMAC.getInstance();




	private ItunesSearchPanel searchPanel;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		Composite  composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(1, false));

		Button load = new Button(composite, SWT.PUSH);
		load.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));


		load.setText("Search");
		addLoadListner(load);


		Composite panelsComposite = new Composite(composite, SWT.NONE);
		panelsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createPanels(panelsComposite);



	}
 
	private void createPanels(final Composite panelsComposite) {
		searchPanel = new ItunesSearchPanel (panelsComposite, SWT.PUSH);
		final Sash sash = new Sash (panelsComposite, SWT.VERTICAL);
		ResultsPanel resultsPanel = new ResultsPanel (panelsComposite, SWT.PUSH);
		
		final FormLayout form = new FormLayout ();
		panelsComposite.setLayout (form);
		
		FormData button1Data = new FormData ();
		button1Data.left = new FormAttachment (0, 0);
		button1Data.right = new FormAttachment (sash, 0);
		button1Data.top = new FormAttachment (0, 0);
		button1Data.bottom = new FormAttachment (100, 0);
		searchPanel.setLayoutData (button1Data);

		final int limit = 20, percent = 50;
		final FormData sashData = new FormData ();
		sashData.left = new FormAttachment (percent, 0);
		sashData.top = new FormAttachment (0, 0);
		sashData.bottom = new FormAttachment (100, 0);
		sash.setLayoutData (sashData);
		sash.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event e) {
				Rectangle sashRect = sash.getBounds ();
				Rectangle shellRect = panelsComposite.getClientArea ();
				int right = shellRect.width - sashRect.width - limit;
				e.x = Math.max (Math.min (e.x, right), limit);
				if (e.x != sashRect.x)  {
					sashData.left = new FormAttachment (0, e.x);
					panelsComposite.layout ();
				}
			}
		});
		
		FormData button2Data = new FormData ();
		button2Data.left = new FormAttachment (sash, 0);
		button2Data.right = new FormAttachment (100, 0);
		button2Data.top = new FormAttachment (0, 0);
		button2Data.bottom = new FormAttachment (100, 0);
		resultsPanel.setLayoutData (button2Data);
	}

	private void addLoadListner(final Button load) {
		load.setText("Next >>");
		load.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				searchPanel.next(); 
			}
		});
	}


	

	@Override
	public void setFocus() {
		
	}

	
}