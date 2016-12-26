package vm;

import static vm.Bytecode.*;

public class VM {
    private int [] data;
    private int [] code;
    private int [] stack;

    private int ip;
    private int sp = -1;
    private int fp;

    public VM( int[] code, int main, int dataSize ){
        this.code = code;
        this.ip = main;
        this.data = new int[dataSize];
        this.stack = new int[100];
    }

    public void  cpu(){
        while(ip < code.length) {   //Execute all the lines of code
            int opcode = code[ip];  //Fetch
            ip++;                   //Increment instruction point to next instruction
            switch (opcode) {
                case ICONST:
                    int operand = code[ip];
                    ip++;
                    sp++;
                    stack[sp] = operand;
                    break;
                case PRINT:
                    operand = stack[sp];
                    sp--;
                    System.out.println(operand);
                    break;
                case HALT:
                    return;
            }
        }

    }
}
