package iTunes.def  ;

import com4j.IID;
import com4j.ReturnValue;
import com4j.VTID;

/**
 * IITPlaylist Interface
 */
@IID("{3D5E072F-2A77-4B17-9E73-E03B77CCCCA9}")
public interface IITPlaylist extends iTunes.def.IITObject {
    /**
     * Delete this playlist.
     */
    @VTID(15)
    void delete();

    /**
     * Start playing the first track in this playlist.
     */
    @VTID(16)
    void playFirstTrack();

    /**
     * Print this playlist.
     */
    @VTID(17)
    void print(
        boolean showPrintDialog,
        iTunes.def.ITPlaylistPrintKind printKind,
        java.lang.String theme);

    /**
     * Search tracks in this playlist for the specified string.
     */
    @VTID(18)
    iTunes.def.IITTrackCollection search(
        java.lang.String searchText,
        iTunes.def.ITPlaylistSearchField searchFields);

    /**
     * The playlist kind.
     */
    @VTID(19)
    iTunes.def.ITPlaylistKind kind();

    /**
     * The source that contains this playlist.
     */
    @VTID(20)
    iTunes.def.IITSource source();

    /**
     * The total length of all songs in the playlist (in seconds).
     */
    @VTID(21)
    int duration();

    /**
     * True if songs in the playlist are played in random order.
     */
    @VTID(22)
    boolean shuffle();

    /**
     * True if songs in the playlist are played in random order.
     */
    @VTID(23)
    void shuffle(
        boolean isShuffle);

    /**
     * The total size of all songs in the playlist (in bytes).
     */
    @VTID(24)
    double size();

    /**
     * The playback repeat mode.
     */
    @VTID(25)
    iTunes.def.ITPlaylistRepeatMode songRepeat();

    /**
     * The playback repeat mode.
     */
    @VTID(26)
    void songRepeat(
        iTunes.def.ITPlaylistRepeatMode repeatMode);

    /**
     * The total length of all songs in the playlist (in MM:SS format).
     */
    @VTID(27)
    java.lang.String time();

    /**
     * True if the playlist is visible in the Source list.
     */
    @VTID(28)
    boolean visible();

    /**
     * Returns a collection of tracks in this playlist.
     */
    @VTID(29)
    iTunes.def.IITTrackCollection tracks();

    @VTID(29)
    @ReturnValue(defaultPropertyThrough={iTunes.def.IITTrackCollection.class})
    iTunes.def.IITTrack tracks(
        int index);

}
