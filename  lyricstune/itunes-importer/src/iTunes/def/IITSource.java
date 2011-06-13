package iTunes.def  ;

import com4j.IID;
import com4j.ReturnValue;
import com4j.VTID;

/**
 * IITSource Interface
 */
@IID("{AEC1C4D3-AEF1-4255-B892-3E3D13ADFDF9}")
public interface IITSource extends iTunes.def.IITObject {
    /**
     * The source kind.
     */
    @VTID(15)
    iTunes.def.ITSourceKind kind();

    /**
     * The total size of the source, if it has a fixed size.
     */
    @VTID(16)
    double capacity();

    /**
     * The free space on the source, if it has a fixed size.
     */
    @VTID(17)
    double freeSpace();

    /**
     * Returns a collection of playlists.
     */
    @VTID(18)
    iTunes.def.IITPlaylistCollection playlists();

    @VTID(18)
    @ReturnValue(defaultPropertyThrough={iTunes.def.IITPlaylistCollection.class})
    iTunes.def.IITPlaylist playlists(
        int index);

}
