package iTunes.def  ;

import com4j.IID;
import com4j.ReturnValue;
import com4j.VTID;

/**
 * IITBrowserWindow Interface
 */
@IID("{C999F455-C4D5-4AA4-8277-F99753699974}")
public interface IITBrowserWindow extends iTunes.def.IITWindow {
    /**
     * True if window is in Mini Player mode.
     */
    @VTID(32)
    boolean miniPlayer();

    /**
     * True if window is in Mini Player mode.
     */
    @VTID(33)
    void miniPlayer(
        boolean isMiniPlayer);

    /**
     * Returns a collection containing the currently selected track or tracks.
     */
    @VTID(34)
    iTunes.def.IITTrackCollection selectedTracks();

    @VTID(34)
    @ReturnValue(defaultPropertyThrough={iTunes.def.IITTrackCollection.class})
    iTunes.def.IITTrack selectedTracks(
        int index);

    /**
     * The currently selected playlist in the Source list.
     */
    @VTID(35)
    iTunes.def.IITPlaylist selectedPlaylist();

    /**
     * The currently selected playlist in the Source list.
     */
    @VTID(36)
    void selectedPlaylist(
        java.lang.Object iPlaylist);

}
