package iTunes.def  ;

import com4j.Com4jObject;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.VTID;

/**
 * IITEQPresetCollection Interface
 */
@IID("{AEF4D111-3331-48DA-B0C2-B468D5D61D08}")
public interface IITEQPresetCollection extends Com4jObject,Iterable<Com4jObject> {
    /**
     * Returns the number of EQ presets in the collection.
     */
    @VTID(7)
    int count();

    /**
     * Returns an IITEQPreset object corresponding to the given index (1-based).
     */
    @VTID(8)
    @DefaultMethod
    iTunes.def.IITEQPreset item(
        int index);

    /**
     * Returns an IITEQPreset object with the specified name.
     */
    @VTID(9)
    iTunes.def.IITEQPreset itemByName(
        java.lang.String name);

    /**
     * Returns an IEnumVARIANT object which can enumerate the collection.
     */
    @VTID(10)
    java.util.Iterator<Com4jObject> iterator();

}
