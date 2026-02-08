package ru.sigpipe.utils;

import net.minecraft.core.Direction;

public class DirBoolMapUtils {
    static final int dirEnumCount = Direction.class.getEnumConstants().length;

    static int unmarkBit(int map, int bit) {
        return map & ~(1<<(bit + dirEnumCount));
    }

    static int markBit(int map, int bit) {
        return map | (1<<(bit + dirEnumCount));
    }

    public static int putBit(int map, int bit, boolean value) {
        if (value) return setBit(map, bit);
        else return unsetBit(map, bit);
    }

    public static int setBit(int map, int bit) {
        return markBit(map, bit) | (1<<bit);
    }

    public static boolean getBit(int map, int bit) {
        return (map & (1<<bit)) != 0;
    }

    public static int unsetBit(int map, int bit) {
        return markBit(map, bit) & ~(1<<bit);
    }

    public static int removeBit(int map, int bit) {
        return unmarkBit(map, bit) & ~(1<<bit);
    }

    public static boolean containsBit(int map, int bit) {
        return (map & (1<<(bit + dirEnumCount))) != 0;
    }
}
