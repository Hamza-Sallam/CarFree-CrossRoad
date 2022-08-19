import javax.swing.*;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Carleft extends JLabel implements Runnable{
    private int x,y,xsp;
    private Random ran;
   private Semaphore se;
    public Carleft(){
se = new Semaphore(1);
        ran= new Random();
        x=5; y=210;
        xsp=ran.nextInt(4,7);

        this.setIcon(new ImageIcon("carleft.png"));
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
    if((x>175 && x< 305) && (y>160 && y < 295)) Thread.currentThread().sleep(2500);
se.acquire();
            x += xsp;
            if (x > 500) {x = 0; xsp=ran.nextInt(5,10);}
            se.release();

}
catch (Exception e){}
    }}

