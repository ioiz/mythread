import java.util.Scanner;

public class Bank implements  Runnable{
    Account account;
    Object obj;
    Scanner sc;
    public Bank(Account account,Object obj){
        sc=new Scanner(System.in);
        this.account=account;
        this.obj=obj;
    }
    public void run() {
        synchronized (obj){
            while(account.getMoney()>0){
                System.out.println("请到"+Thread.currentThread().getName()+"窗口取钱");
                System.out.println("请输入取款金额:");
                double drawMoney;
                drawMoney = sc.nextDouble();
                if(account.getMoney()<drawMoney){
                    System.out.println("账户余额不足！！！"+"剩余余额为"+account.getMoney());
                }else{
                    account.draw(drawMoney);
                    System.out.println(account.getName()+"成功取了"+drawMoney+"元"+
                            "剩余余额为"+account.getMoney()+"元");

                }
            }
        }
    }
}
