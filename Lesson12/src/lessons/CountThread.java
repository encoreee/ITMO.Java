package lessons;
public class CountThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i <= 100; i++){
            System.out.println(i);
        }
    }
}
