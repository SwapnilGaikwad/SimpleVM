package vm;

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

    }
}
