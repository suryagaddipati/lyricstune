package iTunes.def  ;

import com4j.IID;
import com4j.VTID;

/**
 * IITUserPlaylist Interface
 */
@IID("{0A504DED-A0B5-465A-8A94-50E20D7DF692}")
public interface IITUserPlaylist extends iTunes.def.IITPlaylist {
    /**
     * Add the specified file path to the user playlist.
     */
    @VTID(30)
    iTunes.def.IITOperationStatus addFile(
        java.lang.String filePath);

    /**
     * Add the specified array of file paths to the user playlist. filePaths can be of type VT_ARRAY|VT_VARIANT, where each entry is a VT_BSTR, or VT_ARRAY|VT_BSTR.  You can also pass a JScript Array object.
     */
    @VTID(31)
    iTunes.def.IITOperationStatus addFiles(
        java.lang.Object filePaths);

    /**
     * Add the specified streaming audio URL to the user playlist.
     */
    @VTID(32)
    iTunes.def.IITURLTrack addURL(
        java.lang.String url);

    /**
     * Add the specified track to the user playlist.  iTrackToAdd is a VARIANT of type VT_DISPATCH that points to an IITTrack.
     */
    @VTID(33)
    iTunes.def.IITTrack addTrack(
        java.lang.Object iTrackToAdd);

    /**
     * True if the user playlist is being shared.
     */
    @VTID(34)
    boolean shared();

    /**
     * True if the user playlist is being shared.
     */
    @VTID(35)
    void shared(
        boolean isShared);

    /**
     * True if this is a smart playlist.
     */
    @VTID(36)
    boolean smart();

    /**
     * The playlist special kind.
     */
    @VTID(37)
    iTunes.def.ITUserPlaylistSpecialKind specialKind();

    /**
     * The parent of this playlist.
     */
    @VTID(38)
    iTunes.def.IITUserPlaylist parent();

    /**
     * Creates a new playlist in a folder playlist.
     */
    @VTID(39)
    iTunes.def.IITPlaylist createPlaylist(
        java.lang.String playlistName);

    /**
     * Creates a new folder in a folder playlist.
     */
    @VTID(40)
    iTunes.def.IITPlaylist createFolder(
        java.lang.String folderName);

    /**
     * The parent of this playlist.
     */
    @VTID(41)
    void parent(
        java.lang.Object iParentPlayList);

}
