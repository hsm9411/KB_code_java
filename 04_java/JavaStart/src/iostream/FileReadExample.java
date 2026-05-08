package iostream;

// 1. 파일 읽기 예제 (FileInputStream 사용)
import java.io.*;

public class FileReadExample {
    public static void main(String[] args) {
        String sourceFile = "src/iostream/source.txt";  // 읽을 파일 경로
        FileInputStream fis = null;

        try {
            // 파일 읽기 위한 스트림 열기
            fis = new FileInputStream(sourceFile);
            int byteData;

            // 파일에서 한 바이트씩 읽기
            while ((byteData = fis.read()) != -1) {
                // 읽은 바이트 출력
                System.out.print((char) byteData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 스트림 닫기
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    // try-with-resources 예시
    // try 괄호 안에서 스트림을 만들면, try 블록이 끝날 때 fis.close()가 자동으로 호출됩니다.
    public static void main(String[] args) {
        String sourceFile = "src/iostream/source.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile)) {
            int byteData;

            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}


//FileInputStream**을 사용하여 지정된 파일(source.txt)을 읽습니다.

//파일을 한 바이트씩 읽고 출력합니다.

//fis.read() 메소드로 데이터를 읽고, 더 이상 읽을 데이터가 없으면 -1을 반환합니다.

