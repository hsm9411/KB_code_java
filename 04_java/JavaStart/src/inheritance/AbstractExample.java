package inheritance;

public class AbstractExample {
    public static void startUpload(FileUploader fileUploader){
        fileUploader.upload();
    }

    public static void main(String[] args) {
        AbstractExample.startUpload(new ImageUploader());
    }

}
