package lessons;

public class StateThread extends Thread{
    @Override
    public void run(){
        System.out.println(this.getState());
    }
}
