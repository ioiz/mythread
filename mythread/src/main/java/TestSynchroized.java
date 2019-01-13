class Wash{
    static  int count=100;
    public synchronized void Wash() throws InterruptedException {

        for (int i=100;i>=0;i--){
            System.out.println(Thread.currentThread().getName()+"还剩"+count--+"个杯子");
            Thread.sleep(100);
        }
    }
}



class T extends  Thread{//T是一个线程
    Wash wash=new Wash();
    public T(Wash wash){
        this.wash=wash;
    }

    @Override
    public void run() {
        try {
            wash.Wash();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class T2 extends  Thread{
    Wash wash=new Wash();
    public T2(Wash  wash){
        this.wash=wash;
    }

    @Override
    public void run() {
        try {
            wash.Wash();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
public class TestSynchroized {
    public static void main(String[] args) {
        Wash wash=new Wash();
        T t1=new T(wash);
        T t2=new T(wash);
       Thread thread1=new Thread((Runnable) t1,"t1");
        Thread thread2=new Thread((Runnable) t2,"t2");
        thread1.start();
        thread2.start();

    }
}
