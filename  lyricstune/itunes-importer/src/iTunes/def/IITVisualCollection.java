package iTunes.def  ;

import com4j.Com4jObject;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.VTID;

/**
 * IITVisualCollection Interface
 */
@IID("{88A4CCDD-114F-4043-B69B-84D4E6274957}")
public interface IITVisualCollection extends Com4jObject,Iterable<Com4jObject> {
    /**
     * Returns the number of visual plug-ins in the collection.
     */
    @VTID(7)
    int count();

    /**
     * Returns an IITVisual object corresponding to the given index (1-based).
     */
    @VTID(8)
    @DefaultMethod
    iTunes.def.IITVisual item(
        int index);

    /**
     * Returns an IITVisual object with the specified name.
     */
    @VTID(9)
    iTunes.def.IITVisual itemByName(
        java.lang.String name);

    /**
     * Returns an IEnumVARIANT object which can enumerate the collection.
     */
    @VTID(10)
    java.util.Iterator<Com4jObject> iterator();

}
