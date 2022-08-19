import javax.swing.*;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class CarObjects extends JLabel implements Runnable {

    private int x, y, xsp, ysp; // locations and speeds
    private Random ran; // random for making random speeds
    private String label; //  a string for checking which car to animate
    private Semaphore semaphore; // semaphore
    //***********************************
    //*********CONSTRUCTOR****************
    //*******************************
    public CarObjects(String label) { // take String label as a parameter to assign the car image and location according to it
        this.label = label;
        ran = new Random();
        semaphore = new Semaphore(1); // one car can only pass the intersection at a time
        setSize(50, 50); // size of all cars
        xsp = ran.nextInt(5, 10);
        ysp = ran.nextInt(5, 10); // random speeds
        // make conditions to the label in the constructors  to assign icon and locations according to the label
        if (label.equals("car1")) { // if label is car1 , draw the car in up
            label = "carup.png";
            x = 210;
            y = 10;
        }
        //same for all roads cars
        //for the car in the down road
        if (label.equals("car2")) {
            label = "cardown.png";
            x = 260;
            y = 410;
        }
        //car in the left road
        if (label.equals("car3")) {
            label = "carleft.png";
            x = 5;
            y = 210;
        }
        //and finally the car in the right road
        if (label.equals("car4")) {
            label = "caright.png";
            x = 425;
            y = 250;
        }

        setIcon(new ImageIcon(label)); // set the icon according to the conditions above
        setLocation(x, y); // set the locations according to the conditions above
    }
    //***************************************************************************
public void move(){
    //make the condition again but this time will move the specific car according to what car the user choose
    // if label is that car, move it and assign new random speed once it reaches the end of the frame
    if (label.equals("car1")) {
        y += ysp;
        if (y > 500) y = 0;
        ysp = ran.nextInt(3, 6);
    }
    if (label.equals("car2")) {
        y -= ysp;
        if (y < 0) y = 500;
        ysp = ran.nextInt(5, 8);
    }
   if (label.equals("car3")) {
        x += xsp;
        if (x > 500) x = 0;
        xsp = ran.nextInt(5, 8);
    }
   if (label.equals("car4")) {
        x -= xsp;
        if (x < 0) x = 500;
        xsp = ran.nextInt(5, 8);
    }
}
//*******************************************************************
    // getters for x and y
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    //run method to animate
    @Override
    public void run() {
        try {
            //protect the critical section
           if((x>175 && x< 305) && (y>160 && y < 295)) Thread.currentThread().sleep(ran.nextInt(2000)); // once the car reaches the intersection wait
            semaphore.acquire();
            move();
            semaphore.release();
       }
       catch (InterruptedException e) {
           System.err.println(e.getMessage());
       }
    }



}// end of class
