package iTunes.def  ;

import com4j.IID;
import com4j.VTID;

/**
 * IITURLTrack Interface
 */
@IID("{1116E3B5-29FD-4393-A7BD-454E5E327900}")
public interface IITURLTrack extends iTunes.def.IITTrack {
    /**
     * The URL of the stream represented by this track.
     */
    @VTID(72)
    java.lang.String url();

    /**
     * The URL of the stream represented by this track.
     */
    @VTID(73)
    void url(
        java.lang.String url);

    /**
     * True if this is a podcast track.
     */
    @VTID(74)
    boolean podcast();

    /**
     * Update the podcast feed for this track.
     */
    @VTID(75)
    void updatePodcastFeed();

    /**
     * Start downloading the podcast episode that corresponds to this track.
     */
    @VTID(76)
    void downloadPodcastEpisode();

    /**
     * Category for the track.
     */
    @VTID(77)
    java.lang.String category();

    /**
     * Category for the track.
     */
    @VTID(78)
    void category(
        java.lang.String category);

    /**
     * Description for the track.
     */
    @VTID(79)
    java.lang.String description();

    /**
     * Description for the track.
     */
    @VTID(80)
    void description(
        java.lang.String description);

    /**
     * Long description for the track.
     */
    @VTID(81)
    java.lang.String longDescription();

    /**
     * Long description for the track.
     */
    @VTID(82)
    void longDescription(
        java.lang.String longDescription);

}
