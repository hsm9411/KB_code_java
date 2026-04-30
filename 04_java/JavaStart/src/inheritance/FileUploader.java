package inheritance;

public abstract class FileUploader {
    public void upload(){
        System.out.println("File Upload");
    }
    public abstract void connect();
}
