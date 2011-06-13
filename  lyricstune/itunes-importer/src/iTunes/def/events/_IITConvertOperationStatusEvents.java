package iTunes.def.events;

import com4j.DISPID;
import com4j.IID;

/**
 * _IITConvertOperationStatusEvents Interface
 */
@IID("{5C47A705-8E8A-45A1-9EED-71C993F0BF60}")
public abstract class _IITConvertOperationStatusEvents {
    /**
     * Fired when status about the conversion operation has changed.
     */
    @DISPID(1)
    public void onConvertOperationStatusChangedEvent(
        java.lang.String trackName,
        int progressValue,
        int maxProgressValue) {
            throw new UnsupportedOperationException();
    }

    /**
     * Fired when the conversion operation has completed.
     */
    @DISPID(2)
    public void onConvertOperationCompleteEvent() {
            throw new UnsupportedOperationException();
    }

}
