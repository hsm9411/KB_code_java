package thread;

public class ThreadEx2 extends Thread {
    private int[] m = new int[100];

    public ThreadEx2(String name){
        super(name);
        for(int i=0;i<m.length;i++){
            m[i]=i+1;
        }
    }
    @Override
    public void run() {
        for(int i=0;i<m.length;i++){

            System.out.println("run"+ this.getName() + " " + m[i] );
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ThreadEx2 thread1 = new ThreadEx2("정현");
        ThreadEx2 thread2 = new ThreadEx2("이초");
        thread1.start();
        thread2.start();
    }
}
