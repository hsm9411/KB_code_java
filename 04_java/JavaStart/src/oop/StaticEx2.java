package oop;

public class StaticEx2 {

    private int data;
    private static StaticEx2 instance = new StaticEx2();
    private StaticEx2() {
        this(10);
    }

    private StaticEx2(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public static StaticEx2 getInstance() {
        return instance;
    }
}
