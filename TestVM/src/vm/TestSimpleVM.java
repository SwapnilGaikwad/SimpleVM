package vm;

import static vm.Bytecode.*;

public class TestSimpleVM {

    static int[] firstProg = {
            ICONST,     //Instruction at code 0
            37,         //Instruction at code 1 - actually an operand for the first instruction
            CALL, 6, 1, //Instruction at code 2, 3, 4
            HALT,       //Instruction at code 5
            LOAD, -3,   //Instruction at code 6, 7
            IADD, 5,    //Instruction at code 8, 9
            ISUB, 3,    //Instruction at code 10, 11
            PRINT,      //Instruction at code 12
            RET         //Instruction at code 13
    };

    public static void main(String[] args) {
        int globalDataSize = 1;
        int mainIp = 0;
        VM vm = new VM(firstProg, mainIp, globalDataSize);
        vm.trace = true;
        vm.cpu();
    }
}
