package iTunes.def.events;

import com4j.DISPID;
import com4j.IID;

/**
 * _IiTunesEvents Interface
 */
@IID("{5846EB78-317E-4B6F-B0C3-11EE8C8FEEF2}")
public abstract class _IiTunesEvents {
    /**
     * Fired when a database change occurs.
     */
    @DISPID(1)
    public void onDatabaseChangedEvent(
        java.lang.Object deletedObjectIDs,
        java.lang.Object changedObjectIDs) {
            throw new UnsupportedOperationException();
    }

    /**
     * Fired when a track has started playing.
     */
    @DISPID(2)
    public void onPlayerPlayEvent(
        java.lang.Object iTrack) {
            throw new UnsupportedOperationException();
    }

    /**
     * Fired when a track has stopped playing.
     */
    @DISPID(3)
    public void onPlayerStopEvent(
        java.lang.Object iTrack) {
            throw new UnsupportedOperationException();
    }

    /**
     * Fired when information about the currently playing track has changed.
     */
    @DISPID(4)
    public void onPlayerPlayingTrackChangedEvent(
        java.lang.Object iTrack) {
            throw new UnsupportedOperationException();
    }

    /**
     * Fired when the iTunes user interface is no longer disabled.
     */
    @DISPID(5)
    public void onUserInterfaceEnabledEvent() {
            throw new UnsupportedOperationException();
    }

    /**
     * Fired when calls to the iTunes COM interface will be deferred.
     */
    @DISPID(6)
    public void onCOMCallsDisabledEvent(
        iTunes.def.ITCOMDisabledReason reason) {
            throw new UnsupportedOperationException();
    }

    /**
     * Fired when calls to the iTunes COM interface will no longer be deferred.
     */
    @DISPID(7)
    public void onCOMCallsEnabledEvent() {
            throw new UnsupportedOperationException();
    }

    /**
     * Fired when iTunes is about to quit.
     */
    @DISPID(8)
    public void onQuittingEvent() {
            throw new UnsupportedOperationException();
    }

    /**
     * Fired when iTunes is about to prompt the user to quit.
     */
    @DISPID(9)
    public void onAboutToPromptUserToQuitEvent() {
            throw new UnsupportedOperationException();
    }

    /**
     * Fired when the sound output volume has changed.
     */
    @DISPID(10)
    public void onSoundVolumeChangedEvent(
        int newVolume) {
            throw new UnsupportedOperationException();
    }

}
