package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

    public static void main(String[] args){
        //Creating the Main Jframe
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new BorderLayout());
        jFrame.setUndecorated(true);
        jFrame.setAlwaysOnTop(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //End of Creating Main JFrame

        //Full-Screen Jframe
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int xsize = (int)toolkit.getScreenSize().getWidth();
        int ysize = (int)toolkit.getScreenSize().getHeight();
        jFrame.setSize(xsize,ysize);
        //End Full-Screen

        //Setting Jframe visible
        jFrame.setVisible(true);
        //End Visibility

        //Show 15 Seconds Timer
        JLabel jLabel = new JLabel();
        jLabel.setFont(new Font("Verdana",Font.PLAIN,60));
        jLabel.setVerticalAlignment(JLabel.CENTER);
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setForeground(Color.RED);
        jLabel.setVisible(true);
        //End of Showing Timer

        jFrame.add(jLabel);


        //Timer
        int i = 15;
        Timer TimerA = new Timer();
        TimerTask TaskA = new TimerTask() {
            int timer = i;
            @Override
            public void run() {
                if (timer >= 0){
                    jLabel.setText(String.valueOf(timer));
                    timer--;
                }
                if (timer == -1){
                    TimerA.cancel();
                }
            }
        };
        TimerA.schedule(TaskA,0,1000);
        //End Timer

        //Realtime

        //End Realtime

        //Timer for App to Close
        int delay = 15000;
        javax.swing.Timer timer = new javax.swing.Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
            }
        });
        timer.start();
        //End of timer

        //Add Photo
        jFrame.add(new JLabel(new ImageIcon("image.png")));
        //End Add Photo

    }
}