public class TestThread {
    public static void main(String[] args) {
        //新建状态+就绪状态
        BoilThread boilThread=new BoilThread();//优先级是1-10；默认是5数越大越先执行
       WashThread washThread=new WashThread();//注意*********************
       Thread washThread1=new Thread(washThread,"刷杯线程");
        boilThread.start();//运行状态
       washThread1.start();



    }
}
