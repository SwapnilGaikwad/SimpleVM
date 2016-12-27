package vm;

import static vm.Bytecode.*;

public class TestSimpleVM {

    static int[] firstProg = {
            ICONST,     //Instruction at code 0
            37,         //Instruction at code 1 - actually an operand for the first instruction
            CALL, 6, 1, //Instruction at code 2, 3, 4
            HALT,       //Instruction at code 5
            LOAD, -3,   //Instruction at code 6, 7
            ICONST, 5,  //Instruction at code 8, 9
            IADD,       //Instruction at code 10
            ICONST, 3,  //Instruction at code 11, 12
            ISUB,       //Instruction at code 13
            PRINT,      //Instruction at code 14
            RET         //Instruction at code 15
    };

    static int[] factorial = {
//.DEF FACT: ARGS=1, LOCALS=0  ADDRESS
// IF N < 2 RETURN 1
            LOAD, -3,           // 0
            ICONST, 2,          // 2
            ILT,                // 4
            BRF, 10,            // 5
            ICONST, 1,          // 7
            RET,                // 9
// CONT:
// RETURN N * FACT(N-1)
            LOAD, -3,           // 10
            LOAD, -3,           // 12
            ICONST, 1,          // 14
            ISUB,               // 16
            CALL, 0, 1,         // 17
            IMUL,               // 20
            RET,                // 21
//.DEF MAIN: ARGS = 0, LOCALS = 0
// PRINT FACT(5)
            ICONST, 4,          // 22       <-- MAIN METHOD
            CALL, 0, 1,         // 24
            PRINT,              // 27
            HALT                // 28
    };

    public static void main(String[] args) {
        int globalDataSize = 1;
        int mainIp = 0;
        //VM vm = new VM(firstProg, mainIp, globalDataSize);
        mainIp = 22;
        VM vm = new VM(factorial, mainIp, globalDataSize);
        vm.trace = true;
        vm.cpu();
    }
}
