package importer.services.lyrics;

public enum LyricProviders {
	
	LEOSLYRICS("Leo's Lyrics"){

		@Override
		public LyricsProvider getProvider() {
			return new LeosLyricsLyricsProvider();
		}
		
	}
	,LYRICS_WIKI("Leo's Lyrics"){

		@Override
		public LyricsProvider getProvider() {
			return new LyricsWikiLyricsProvider();
		}
	};
	private final String name;

	public abstract LyricsProvider getProvider();
	
	private LyricProviders(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
