package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class WriteExample {
    public static void main(String[] args) {
        try {
            OutputStream os =
                    new FileOutputStream("C:/temp/test1.db");
            byte a = 10;
            byte b = 20;
            byte c = 30;
            os.write(a);
            os.write(b);
            os.write(c);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //try with resource로 finally 없이도 close 까지 진행될 수 있게 구성
        try(OutputStream os = new FileOutputStream("C:/temp/test1.db")) {
            byte a = 10;
            byte b = 20;
            byte c = 30;
            os.write(a);
            os.write(b);
            os.write(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
