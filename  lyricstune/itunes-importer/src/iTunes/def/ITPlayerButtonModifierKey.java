package iTunes.def  ;

import com4j.ComEnum;

public enum ITPlayerButtonModifierKey implements ComEnum {
    ITPlayerButtonModifierKeyNone(0),
    ITPlayerButtonModifierKeyShift(1),
    ITPlayerButtonModifierKeyControl(2),
    ITPlayerButtonModifierKeyAlt(4),
    ITPlayerButtonModifierKeyCapsLock(8),
    ;

    private final int value;
    ITPlayerButtonModifierKey(int value) { this.value=value; }
    public int comEnumValue() { return value; }
}
