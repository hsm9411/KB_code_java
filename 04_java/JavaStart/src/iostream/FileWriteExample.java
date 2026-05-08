package iostream;

//2. 파일 쓰기 예제 (FileOutputStream 사용)
import java.io.*;

public class FileWriteExample {
    public static void main(String[] args) {
        String destinationFile = "src/iostream/destination.txt";  // 쓸 파일 경로
        String content = "Hello, Java ByteStream!";   // 파일에 쓸 내용
        FileOutputStream fos = null;

        try {
            // 파일 쓰기 위한 스트림 열기
            fos = new FileOutputStream(destinationFile);

            // 문자열을 바이트 배열로 변환하여 파일에 쓴다.
            fos.write(content.getBytes());

            System.out.println("파일에 내용이 성공적으로 기록되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 스트림 닫기
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    // try-with-resources 예시
    // try 괄호 안에서 스트림을 만들면, try 블록이 끝날 때 fos.close()가 자동으로 호출됩니다.
    public static void main(String[] args) {
        String destinationFile = "src/iostream/destination.txt";
        String content = "Hello, Java ByteStream!";

        try (FileOutputStream fos = new FileOutputStream(destinationFile)) {
            fos.write(content.getBytes());
            System.out.println("파일에 내용이 성공적으로 기록되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}

//FileOutputStream**을 사용하여 지정된 파일(destination.txt)에 데이터를 씁니다.

//문자열을 getBytes() 메소드를 통해 바이트 배열로 변환한 후 파일에 쓴다.

//fos.write() 메소드는 바이트 배열을 파일에 씁니다.



//파일 읽기: FileInputStream을 사용하여 파일을 바이트 단위로 읽습니다.

//파일 쓰기: FileOutputStream을 사용하여 파일에 데이터를 바이트 단위로 씁니다.

//두 예제는 각각 파일을 읽고 쓰는 기본적인 방식으로, 보다 복잡한 작업을 위해 **BufferedInputStream**이나 **BufferedOutputStream**을 사용할 수 있습니다.
