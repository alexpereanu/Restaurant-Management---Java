package PresentationLayer;

import BusinessLayer.IObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChefGraphicalUserInterface implements IObserver {

    public void initChefGraphicalUserInterface(){

        JFrame chefFrame = new JFrame("CHEF");
        JPanel chefPanel = new JPanel();
        chefFrame.add(chefPanel);
        chefFrame.setVisible(true);
        chefPanel.setLayout(null);
        chefFrame.setSize(500,400);
        chefFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel updateOrders = new JLabel("UPDATE ORDERS ");
        chefPanel.add(updateOrders);
        updateOrders.setBounds(152,30,250,50);
        updateOrders.setFont(new Font("TimesRoman", Font.CENTER_BASELINE,20));

        JButton updateButton = new JButton("UPDATE");
        chefPanel.add(updateButton);
        updateButton.setBounds(115,150,250,30);
        updateButton.setFont(new Font("TimesRoman", Font.BOLD,15));

        JButton backBut = new JButton("BACK");
        chefPanel.add(backBut);
        backBut.setBounds(300,300,100,30);

        backBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                chefFrame.setVisible(false);
                //MainInterface t = new MainInterface();
                //t.initMainFrame();
            }
        });

        backBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                notifyObservers();
            }
        });


    }
    @Override
    public void notifyObservers() {

    }
}
