package iTunes.def  ;

import com4j.IID;
import com4j.ReturnValue;
import com4j.VTID;

/**
 * IITPlaylistWindow Interface
 */
@IID("{349CBB45-2E5A-4822-8E4A-A75555A186F7}")
public interface IITPlaylistWindow extends iTunes.def.IITWindow {
    /**
     * Returns a collection containing the currently selected track or tracks.
     */
    @VTID(32)
    iTunes.def.IITTrackCollection selectedTracks();

    @VTID(32)
    @ReturnValue(defaultPropertyThrough={iTunes.def.IITTrackCollection.class})
    iTunes.def.IITTrack selectedTracks(
        int index);

    /**
     * The playlist displayed in the window.
     */
    @VTID(33)
    iTunes.def.IITPlaylist playlist();

}
