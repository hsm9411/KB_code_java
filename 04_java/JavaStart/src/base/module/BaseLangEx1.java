package base.module;

public class BaseLangEx1 {

    public static void main(String[] args) {
        BaseLangEx1 base = new BaseLangEx1();
        base.objectMethod1();
        base.objectMethod2(new Object());
        base.objectMethod3();
    }

    public void objectMethod1() {

        Object obj = new Object();
        obj.equals(10);

        String str = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        System.out.println(str == str2);
        System.out.println(str == str3);
        System.out.println(str.equals(str2));
        System.out.println(str.equals(str3));

        System.out.println(obj.hashCode());
        System.out.println(new Object().hashCode());
        System.out.println(obj.toString());
    }

    public void objectMethod2(Object data){
        if(data instanceof String){
            System.out.println(((String) data).charAt(0));
        }
        if(data instanceof Integer){
            System.out.println(((Integer) data).intValue());
        }
        if(data instanceof Double){
            System.out.println(((Double) data).doubleValue());
        }
    }

    public void objectMethod3(){

        System.out.println("-------------------------");
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println(str1.hashCode() == str2.hashCode());
        String str3="java";
        String str4="spring";
        System.out.println(str3.startsWith("j"));

    }


}
