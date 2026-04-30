package thread;


public class ThreadEx3 implements Runnable {

    @Override
    public void run() {
        System.out.println("ThreadEx3 run");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadEx3 t1 = new ThreadEx3();

        Thread thread1 = new Thread(t1);
        thread1.start();

        Thread thread2 = new Thread(t1);
        thread2.start();
    }

}
