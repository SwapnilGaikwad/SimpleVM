package vm;

import static vm.Bytecode.*;

public class VM {
    private int [] globals;
    private int [] code;
    private int [] stack;

    private int ip;
    private int sp = -1;
    private int fp;

    public static boolean trace = false;

    public VM( int[] code, int main, int dataSize ){
        this.code = code;
        this.ip = main;
        this.globals = new int[dataSize];
        this.stack = new int[100];
    }

    public void  cpu(){
        loop:
        while(ip < code.length) {   //Execute all the lines of code
            int opcode = code[ip];  //Fetch
            if(trace){
                disassemble(opcode);
            }
            ip++;                   //Increment instruction point to next instruction
            switch (opcode) {       //Decode
                case ICONST:        //Execute
                    int operand = code[ip];
                    ip++;
                    sp++;
                    stack[sp] = operand;
                    break;
                case PRINT:
                    int value = stack[sp];
                    sp--;
                    System.out.println(value);
                    break;
                case GSTORE:
                    int storageLocation = code[ip];
                    ip ++;
                    value = stack[sp];
                    sp--;
                    globals[storageLocation] = value;
                    break;
                case GLOAD:
                    storageLocation = code[ip];
                    ip++;
                    sp++;
                    stack[sp]=globals[storageLocation];
                    break;
                case HALT:
                    break loop;
            }
            if(trace) System.err.println(stackString());
        }
        if(trace){
            System.err.println("\n");
            dumpDataMemory();
            dumpCodeMemory();
        }
    }

    private void disassemble(int opcode) {
        //Print ip: opcode [operands]
        Instruction instr = instructions[opcode];
        System.err.printf("%04d: %s", ip, instr.name);
        if(instr.nArgs == 1){
            System.err.printf(" %d", code[ip+1]);
        } else if (instr.nArgs == 2){
            System.err.printf(" %d, %d", code[ip+1], code[ip+2]);
        }
        System.err.print("\t\t\t\t");
    }

    private String stackString(){
        //Print Stack
        StringBuilder buf = new StringBuilder();
        buf.append("[ ");
        for(int i = 0; i <= sp; i++){
            int value = stack[i];
            buf.append(value);
            buf.append(" ");
        }
        buf.append("]");
        return buf.toString();
    }

    private void dumpDataMemory(){
        //Print data memory
        System.err.println("Data Memory: ");
        int addr = 0;
        for(int dataValue : globals){
            System.err.printf("%04d: %d\n", addr, dataValue);
            addr++;
        }
        System.err.println();
    }
    private void dumpCodeMemory(){
        //Print code memory
        System.err.println("Code Memory: ");
        int addr = 0;
        for(int bytecode : code){
            System.err.printf("%04d: %d\n", addr, bytecode);
            addr++;
        }
        System.err.println();
    }
}
