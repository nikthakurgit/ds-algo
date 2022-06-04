public class TestClass {
    public static void main(String[] args) throws InterruptedException {
        FiboNaciSeries fb= new FiboNaciSeries();

            for(int j=0;j<5;j++){
                Thread t =new Thread(fb);
                t.start();
                synchronized (t){
                    System.out.println("Waiting...");
                    t.wait();
                }
               // t.join();
            }

System.out.println("%%%%%%%%%%%%");
        }


    }


