import javax.swing.*;
import java.util.Random;

public class Cardown extends JLabel implements Runnable {

// SAME THING FOR CARDOWN BUT THE CAR IS IN THE SOUTH ROAD
        private int x,y,ysp;
        private Random ran;

        public Cardown(){

            ran= new Random();
            x=260; y=410;
            ysp= ran.nextInt(5,10); //speed
            this.setIcon(new ImageIcon("cardown.png"));
            this.setBounds(x,y,50,50); //both location and size
        }
//getters for the location to animate it
    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x;
    }


    // run the threads
    public void run() {
            y-=ysp; //move the car upwards;
            if( y < 0) {y=500; ysp= ran.nextInt(5,10);
            ;}


    }}

