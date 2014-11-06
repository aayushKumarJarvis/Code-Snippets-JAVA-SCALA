
public class ThreadStart {

    public static void main(String args[]) {

        Thread t = Thread.currentThread();
        System.out.println("current thread is "+t);

        // change the nameOfCustomer of thread
        t.setName("My Thread");
        System.out.println("After nameOfCustomer change "+t);

        try {
            for(int i=5;i>0;i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        }

        catch(InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
