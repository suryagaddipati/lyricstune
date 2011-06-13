package iTunes.def  ;

import com4j.Com4jObject;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.VTID;

/**
 * IITPlaylistCollection Interface
 */
@IID("{FF194254-909D-4437-9C50-3AAC2AE6305C}")
public interface IITPlaylistCollection extends Com4jObject,Iterable<Com4jObject> {
    /**
     * Returns the number of playlists in the collection.
     */
    @VTID(7)
    int count();

    /**
     * Returns an IITPlaylist object corresponding to the given index (1-based).
     */
    @VTID(8)
    @DefaultMethod
    iTunes.def.IITPlaylist item(
        int index);

    /**
     * Returns an IITPlaylist object with the specified name.
     */
    @VTID(9)
    iTunes.def.IITPlaylist itemByName(
        java.lang.String name);

    /**
     * Returns an IEnumVARIANT object which can enumerate the collection.
     */
    @VTID(10)
    java.util.Iterator<Com4jObject> iterator();

}
