package importer.services.lyrics;

import importer.models.common.ISearchResult;
import importer.models.common.Track;

import java.util.List;

public abstract  class LyricsProvider {

	public abstract List<? extends ISearchResult> getLyricsFor(Track track);

}