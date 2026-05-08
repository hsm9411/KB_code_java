package iostream;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        // 파일 경로 설정
        String sourceFile = "src/iostream/source.txt";  // 원본 파일 경로
        String destinationFile = "src/iostream/destination2.txt";  // 복사할 파일 경로

        // 스트림 선언
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            // 원본 파일을 읽기 위한 스트림 설정
            fis = new FileInputStream(sourceFile);
            bis = new BufferedInputStream(fis);

            // 복사할 파일을 쓰기 위한 스트림 설정
            fos = new FileOutputStream(destinationFile);
            bos = new BufferedOutputStream(fos);

            int byteData;
            // 원본 파일에서 데이터를 읽어와 복사 파일에 쓴다
            while ((byteData = bis.read()) != -1) {
                bos.write(byteData);
            }

            System.out.println("파일 복사 완료!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 스트림 닫기
                if (bis != null) bis.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
