package iTunes.def  ;

import com4j.Com4jObject;
import com4j.IID;
import com4j.VTID;

/**
 * IITVisual Interface
 */
@IID("{340F3315-ED72-4C09-9ACF-21EB4BDF9931}")
public interface IITVisual extends Com4jObject {
    /**
     * The name of the the visual plug-in.
     */
    @VTID(7)
    java.lang.String name();

}
