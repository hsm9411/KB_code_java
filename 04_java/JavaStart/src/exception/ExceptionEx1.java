package exception;

public class ExceptionEx1  {
    public void arrayIndexOutOfBoundsException(){
        int []m = new int [5];
        for(int i=0;i<=m.length;i++){
            try{
//                m[i] = i+1;
                m[i] = 10/(int)Math.random()*100;
            } catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }catch(ArithmeticException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            } catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("finally");
            }
        }
    }

    public void cloneNotSupportedException(){
//        ExceptionDemo e1 = new ExceptionDemo();
        try{
            ExceptionEx1 e1 = new ExceptionEx1();
            ExceptionEx1 e2 = (ExceptionEx1) e1.clone();
            System.out.println(e2);
        } catch(Throwable e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        ExceptionEx1 e = new ExceptionEx1();
        e.cloneNotSupportedException();
    }
}
