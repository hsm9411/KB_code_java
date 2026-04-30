package inheritance;

public class ImageUploader extends FileUploader{

    @Override
    public void upload() {
        System.out.println("Image Upload");
    }

    @Override
    public void connect() {
        System.out.println("Connect Image");
    }
}
