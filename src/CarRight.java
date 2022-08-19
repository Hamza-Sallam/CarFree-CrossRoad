import javax.swing.*;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class CarRight extends JLabel implements Runnable {
    private int x,y,xsp;
    private Random ran;
    private Semaphore sem;
    public CarRight(){
sem = new Semaphore(1);
        ran= new Random();
        x=425; y=250;
        xsp=ran.nextInt(5,10);

        this.setIcon(new ImageIcon("caright.png"));
        this.setBounds(x,y,50,50);

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void run() {
        try{
            if((x>175 && x< 305) && (y>160 && y < 295)) Thread.currentThread().join(3000);
           sem.acquire();
            x-=xsp;
            if( x < 0) {x=500; xsp = ran.nextInt(5,10);}
            sem.release();
        }
        catch(Exception e){}



    }
}
