package vm;

import static vm.Bytecode.*;

public class TestSimpleVM {

    static int[] firstProg = {
            HALT    //Instruction at code 0
    };

    public static void main(String[] args) {
        VM vm = new VM(firstProg, 0, 0);
        vm.cpu();
    }
}
