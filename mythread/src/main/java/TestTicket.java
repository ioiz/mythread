class TicketOffice implements Runnable  {
    Object obj;
    int ticketnum;
    public TicketOffice(Object obj,int ticketnum){
        this.obj=obj;
        this.ticketnum=ticketnum;
    }
    public void run() {
        while(ticketnum>=0){
            synchronized (obj){
            if (ticketnum<=0){
                System.out.println("无票，停止售卖");
                break;
            }else{


                System.out.println(Thread.currentThread().getName()+"售票点买了一张"+this.obj+"，还剩下"+--ticketnum+"张票");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }}
    }
}
public class TestTicket {
    public static void main(String[] args) {
        TicketOffice ticketOffice=new TicketOffice("天津高铁",10);
        Thread thread1=new Thread((Runnable) ticketOffice,"窗口1");
        Thread thread2=new Thread((Runnable) ticketOffice,"窗口2");
        Thread thread3=new Thread((Runnable) ticketOffice,"窗口3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
