package iTunes.def  ;

import com4j.Com4jObject;
import com4j.IID;
import com4j.VTID;

/**
 * IITEncoder Interface
 */
@IID("{1CF95A1C-55FE-4F45-A2D3-85AC6C504A73}")
public interface IITEncoder extends Com4jObject {
    /**
     * The name of the the encoder.
     */
    @VTID(7)
    java.lang.String name();

    /**
     * The data format created by the encoder.
     */
    @VTID(8)
    java.lang.String format();

}
