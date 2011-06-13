package iTunes.def  ;

import com4j.Com4jObject;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.VTID;

/**
 * IITWindowCollection Interface
 */
@IID("{3D8DE381-6C0E-481F-A865-E2385F59FA43}")
public interface IITWindowCollection extends Com4jObject,Iterable<Com4jObject> {
    /**
     * Returns the number of windows in the collection.
     */
    @VTID(7)
    int count();

    /**
     * Returns an IITWindow object corresponding to the given index (1-based).
     */
    @VTID(8)
    @DefaultMethod
    iTunes.def.IITWindow item(
        int index);

    /**
     * Returns an IITWindow object with the specified name.
     */
    @VTID(9)
    iTunes.def.IITWindow itemByName(
        java.lang.String name);

    /**
     * Returns an IEnumVARIANT object which can enumerate the collection.
     */
    @VTID(10)
    java.util.Iterator<Com4jObject> iterator();

}
