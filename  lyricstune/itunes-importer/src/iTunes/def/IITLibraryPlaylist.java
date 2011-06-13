package iTunes.def  ;

import com4j.IID;
import com4j.VTID;

/**
 * IITLibraryPlaylist Interface
 */
@IID("{53AE1704-491C-4289-94A0-958815675A3D}")
public interface IITLibraryPlaylist extends iTunes.def.IITPlaylist {
    /**
     * Add the specified file path to the library.
     */
    @VTID(30)
    iTunes.def.IITOperationStatus addFile(
        java.lang.String filePath);

    /**
     * Add the specified array of file paths to the library. filePaths can be of type VT_ARRAY|VT_VARIANT, where each entry is a VT_BSTR, or VT_ARRAY|VT_BSTR.  You can also pass a JScript Array object.
     */
    @VTID(31)
    iTunes.def.IITOperationStatus addFiles(
        java.lang.Object filePaths);

    /**
     * Add the specified streaming audio URL to the library.
     */
    @VTID(32)
    iTunes.def.IITURLTrack addURL(
        java.lang.String url);

    /**
     * Add the specified track to the library.  iTrackToAdd is a VARIANT of type VT_DISPATCH that points to an IITTrack.
     */
    @VTID(33)
    iTunes.def.IITTrack addTrack(
        java.lang.Object iTrackToAdd);

}
