package oop;

public class Font {
    private String face;
    private int size;
    private String  color;
    public Font(){}
    public Font(String face){
//        this.face = face;
        this(face,0);
    }
    public Font(String face, int size){
//        this.face = face;
//        this.size = size;
        this(face,size,"");
    }

    public Font(String face, int size, String color) {
        this.face = face;
        this.size = size;
        this.color = color;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return face;
    }

    public static void main(String[] args) {
        Font f = new Font();
        f.setFace("font1");
        System.out.println(f);
    }

}
