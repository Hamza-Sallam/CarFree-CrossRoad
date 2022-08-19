import javax.swing.*;
import java.util.Random;
import java.util.concurrent.Semaphore;

// class for car moving in the north road
public class Carup extends JLabel implements Runnable{ // extend jlabel to easily add it in the main frame

    private int x,y,ysp; //create coordinats and speed
    private Random ran;
    private Semaphore sema1;

    public Carup(){
sema1 = new Semaphore(1);
        ran= new Random();
        x=210; y=10; // set the location the car will move
        ysp=2; // the speed; no need for xspeed since its only moving in y axis

this.setIcon(new ImageIcon("carup.png")); // set the icon for the jlabel
this.setLocation(x,y); // set the location
this.setSize(50,50);// width and height

    }
//getters
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

// run method to run the thread
    public void run() {
        try {

            if((x>175 && x< 305) && (y>160 && y < 295)) Thread.currentThread().sleep(1000);
            sema1.acquire();
            y += ysp; // move the  car
            if (y > 500) {
                y = 0;
                ysp = ran.nextInt(5, 10);
            }  // if the car reaches the ground spawn back from top with new random speed
sema1.release();
        } catch (Exception e) {
        }
    }


}// end of carup