package iTunes.def  ;

import com4j.ComEnum;

public enum ITConvertOperationStatusEvent implements ComEnum {
    ITConvertOperationStatusChanged(1),
    ITConvertOperationComplete(2),
    ;

    private final int value;
    ITConvertOperationStatusEvent(int value) { this.value=value; }
    public int comEnumValue() { return value; }
}
