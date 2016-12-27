package vm;

import static vm.Bytecode.*;

public class TestSimpleVM {

    static int[] firstProg = {
            ICONST,     //Instruction at code 0
            37,         //Instruction at code 1 - actually an operand for the first instruction
            PRINT,      //Instruction at code 2
            HALT        //Instruction at code 3
    };

    public static void main(String[] args) {
        VM vm = new VM(firstProg, 0, 0);
        vm.trace = true;
        vm.cpu();
    }
}
