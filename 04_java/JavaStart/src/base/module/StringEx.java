package base.module;

public class StringEx {
    private char[] value;
    public StringEx(){

    }

    public StringEx(char[] value) {
        this.value = value;
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof String){
            char[] temp = ((String)(obj)).toCharArray();
            if(temp.length!=value.length){
                return false;
            }else {
                for(int i=0;i<temp.length;i++){
                    if(temp[i]!=value[i]){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public char charAt(int index) {
        if(index<0||index>value.length-1){
            throw new StringIndexOutOfBoundsException();
        }
        return value[index];
    }

    public static void main(String[] args) {
        StringEx stringEx=new StringEx("abc".toCharArray());
        StringEx stringEx1=new StringEx("abc".toCharArray());
        System.out.println(stringEx.equals(stringEx1));
    }
}
