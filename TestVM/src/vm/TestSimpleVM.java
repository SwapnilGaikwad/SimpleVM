package vm;

import static vm.Bytecode.*;

public class TestSimpleVM {

    static int[] firstProg = {
            ICONST,     //Instruction at code 0
            37,         //Instruction at code 1 - actually an operand for the first instruction
            GSTORE, 0,  //Instruction at code 2, 3
            GLOAD, 0,   //Instruction at code 4, 5
            PRINT,      //Instruction at code 6
            HALT        //Instruction at code 7
    };

    public static void main(String[] args) {
        int globalDataSize = 1;
        int mainIp = 0;
        VM vm = new VM(firstProg, mainIp, globalDataSize);
        vm.trace = true;
        vm.cpu();
    }
}
