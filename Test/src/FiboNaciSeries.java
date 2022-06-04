public class FiboNaciSeries implements Runnable{
    @Override
    public void run() {

        synchronized (this){
            System.out.println("Started");
            int firstNum=0;
            int secondNum=1;
            int temp =0;

            for(int i=2;i<=5;i++){
                temp=firstNum+secondNum;
                System.out.println(temp);
                firstNum=secondNum;
                secondNum=temp;
            }
            System.out.println("Ended");

            notify();
        }





    }
}
