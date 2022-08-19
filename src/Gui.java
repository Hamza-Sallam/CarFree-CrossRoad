//package homework2;


import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class Gui extends JPanel implements Runnable {
    private JLabel fCar,sCar,tCAr,fTCar;
    private int x1=20;
    private int y1=400;
    Thread thread;

    public Gui(){
        this.setLayout(null);
        setSize(500,500);

        fCar = new JLabel("");
        Image img = new ImageIcon("carleft.png").getImage();
        fCar.setIcon(new ImageIcon(img));
        fCar.setLocation(x1,250);
        fCar.setSize(50,50);
        this.add(fCar);
        sCar = new JLabel();
        sCar.setIcon(new ImageIcon("cardown.png"));
        sCar.setLocation(250,y1);
        sCar.setSize(50,50);
        add(sCar);









    }

    public void paint(Graphics g){
       super.paint(g);
        g.drawRect(220,0,100,500);
        g.drawRect(0,210,500,100);
        g.setColor(Color.gray);
        g.fillRect(220,210,100,100);


    }




    public static void main(String[] args) {
        Gui Jframe= new Gui();
        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setResizable(false);
        j.setVisible(true);
        j.setSize(Jframe.getSize());
        j.add(Jframe);

        Thread t = new Thread(Jframe);
        t.start();





    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
while(true){
    try{
    Thread.currentThread().sleep(60);
   fCar.setLocation(x1,250);
   sCar.setLocation(250,y1);
    x1+=5;
    y1-=5;
}
catch(Exception e){}
    }






}}