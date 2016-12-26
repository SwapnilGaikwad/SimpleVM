package vm;

public class Bytecode{
    public static final short IADD = 1;
    public static final short ISUB = 2;
    public static final short IMUL = 3;
    public static final short ILT = 4;
    public static final short IEQ = 5;
    public static final short BR = 6;
    public static final short BRT = 7;
    public static final short BRF = 8;
    public static final short ICONST = 9;
    public static final short LOAD = 10;
    public static final short GLOAD = 11;
    public static final short STORE = 12;
    public static final short GSTORE = 13;
    public static final short PRINT = 14;
    public static final short POP = 15;
    public static final short HALT = 16;
}
