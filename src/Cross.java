
import javax.swing.*;
import java.awt.*;

public class Cross extends JPanel implements Runnable {
    //create the car objects
    private Carup car1;
    private Cardown car2;
    private Carleft car3;
    private CarRight car4;
    public Cross() {
//initliaze
        car1 = new Carup();
        car2 = new Cardown();
        car3 = new Carleft();
        car4 = new CarRight();
        setLayout(null);
        setSize(500, 500);
        // add the car objects to the panel
        add(car1);
        add(car2);
        add(car3);
        add(car4);
    }

    public static void main(String[] args) {
        Cross c = new Cross(); // panel
        JFrame frame = new JFrame(); //create a frame
        frame.add(c); // add the panel
        frame.setSize(c.getSize()); // set size same as size of panel
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
// start the thread that contains other threads
        Thread t1 = new Thread(c);
        t1.start();
    }



    // create a method to call all 4 car threads
    public void animate() {
        //set location for each car object
        car1.setLocation(car1.getX(),car1.getY());
        car2 .setLocation(car2.getX(),car2.getY());
        car3 .setLocation(car3.getX(),car3.getY());
        car4 .setLocation(car4.getX(),car4.getY());
        // create the threads
        Thread t1 = new Thread(car1);
        Thread t2 = new Thread(car2);
        Thread t3 = new Thread(car3);
        Thread t4 = new Thread(car4);
        //run the threads for each car object
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }



    //*******************************************************************
//***********************designing the road **************************
//********************************************************************
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(184,134,11));
        g.fillRect(0,0,200,200);
        g.setColor(new Color(184,134,11));
        g.fillRect(0,300,200,200);
        g.setColor(new Color(184,134,11));
        g.fillRect(300,0,200,200);
        g.setColor(new Color(184,134,11));
        g.fillRect(300,300,200,200);
        // create the intersection block
        g.setColor(Color.red);
        g.drawRect(200,200,100,100);
        //************************************************************************************
        //*********************design for the Lane Lines**************************************
        //************************************************************************************
        g.setColor(Color.black);
        g.fillRect(245,20,5,60);
        g.fillRect(245,135,5,60);
        g.fillRect(245,305,5,60);
        g.fillRect(245,420,5,60);
        g.fillRect(20,250,60,5);
        g.fillRect(120,250,60,5);
        g.fillRect(320,250,60,5);
        g.fillRect(420,250,60,5);

    }


    // run the thread by calling animate() that contains all 4 cars threads
    public void run() {
        while(true){
            try{
                Thread.currentThread().sleep(40);
                animate();
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }}
