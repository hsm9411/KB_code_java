package inheritance;

public class VideoUploader extends FileUploader {
    @Override
    public void upload() {
        System.out.println("Video Upload");
    }

    @Override
    public void connect() {
        System.out.println("Connect Video");
    }
}
