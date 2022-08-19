
import javax.swing.*;
import java.awt.*;

public class CrossRoad extends JPanel implements Runnable {
//create the car objects
private CarObjects c1,c2,c3,c4; // I created 4 cars
public CrossRoad() {
//initliaze
	c1= new CarObjects("car1"); //car from up to down
	c2= new CarObjects("car2"); // car from down to up
	c3= new CarObjects("car3"); // car from left to right
	c4= new CarObjects("car4"); // car from right to left


	setLayout(null); // set the layout to null to adjust the cars locations properly
	setSize(500, 500); // size of the game panel
	// add the car objects to the panel
add(c1);
add(c2);
add(c3);
add(c4);
}

//main method
	public static void main(String[] args) {
		CrossRoad c = new CrossRoad(); // panel
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
	    c1.setLocation(c1.getX(),c1.getY());
		c2 .setLocation(c2.getX(),c2.getY());
		c3 .setLocation(c3.getX(),c3.getY());
		c4 .setLocation(c4.getX(),c4.getY());
        // create the threads
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);
		Thread t4 = new Thread(c4);
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
	while(true){ // make it continous animation
	  try{
		  Thread.currentThread().sleep(50); // the lower the length the faster the cars will move
		animate();
	  }
	  catch(InterruptedException e){
		  System.err.println(e.getMessage());
	  }
  }
	}}
