package kalkulator;

public class Calculator {
    private int state = 0;

    private boolean err = false;

    private int memory = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void add(int x) {
        state += x;
    }

    public void subtract(int x) {
        state -= x;
    }

    public void multiply(int x) {
        state *= x;
    }

    public void divide(int x) {
        if (x == 0) {
            err = true;
        } else {
            state /= x;
        }
    }

    public void saveMem () {
        memory = state;
    }

    public void useMem () {
        state += memory;
    }

    public void addMem () {
        memory += state;
    }

    public void subMem () {
        memory -= state;
    }

    public int getMem () {
        return memory;
    }

    public boolean getErr () {
        return err;
    }
}
