package com.xy.homework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-16 23:22
 * @desc:
 **/
public class WindowButton extends JFrame implements ActionListener {
    int count = 0;
    int number;
    JLabel showPrompt;
    JTextField inputNumber;
    JButton buttonGetNumber;
    JButton buttonConfirm;
    JButton buttonOut;
    JComboBox comboBox = new JComboBox();

    WindowButton(String s) {
        super(s);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                WindowButton.this.dispose();
            }
        });
        this.setLayout(new FlowLayout());
        this.buttonGetNumber = new JButton("Get a random number");
        this.add(this.buttonGetNumber);
        this.comboBox.addItem("1");
        this.comboBox.addItem("2");
        this.comboBox.addItem("3");
        this.comboBox.setPreferredSize(new Dimension(60, 25));
        this.add(this.comboBox);
        this.showPrompt = new JLabel("input your guess_number:", 0);
        this.showPrompt.setBackground(Color.cyan);
        this.add(this.showPrompt);
        this.inputNumber = new JTextField("0", 10);
        this.add(this.inputNumber);
        this.buttonOut = new JButton("Cancel");
        this.add(this.buttonOut);
        this.buttonConfirm = new JButton("Confirm");
        this.add(this.buttonConfirm);
        this.comboBox.addActionListener(this);
        this.buttonOut.addActionListener(this);
        this.buttonConfirm.addActionListener(this);
        this.buttonGetNumber.addActionListener(this);
        this.setBounds(100, 100, 360, 200);
        this.setVisible(true);
        this.validate();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
        boolean guess;
        int guessC;
        if(e.getSource() == this.buttonGetNumber) {
            guess = false;
            guessC = Integer.parseInt((String)this.comboBox.getSelectedItem());
            RandomNumber randomNumber = new RandomNumber();
            if(guessC == 1) {
                this.number = randomNumber.getEasy();
            } else if(guessC == 2) {
                this.number = randomNumber.getNormal();
            } else {
                this.number = randomNumber.getNormal();
            }

            this.inputNumber.setText("Start");
            this.showPrompt.setText("                    Are you ready?                ");
            Font myfont = new Font("nomal", 0, 15);
            this.showPrompt.setFont(myfont);
        } else if(e.getSource() == this.buttonConfirm) {
            ++this.count;
            guess = false;
            Font myfont = new Font("nomal", 0, 15);
            this.showPrompt.setFont(myfont);

            try {
                guessC = Integer.parseInt(this.inputNumber.getText());
                if(guessC == this.number) {
                    this.showPrompt.setText("  Guessing rigth!! Guessing times:" + this.count + ";");
                    this.showPrompt.setForeground(Color.red);
                    myfont = new Font("arial", 2, 20);
                    this.showPrompt.setFont(myfont);
                    this.count = 0;
                } else if(Math.abs(guessC - this.number) < 10) {
                    this.showPrompt.setFont(myfont);
                    if(guessC < this.number) {
                        this.showPrompt.setText("  Guessing times:" + this.count + "; Come on!(a little low)");
                        this.showPrompt.setForeground(Color.pink);
                    } else {
                        this.showPrompt.setText("  Guessing times:" + this.count + "; Come on!(a little high)");
                        this.showPrompt.setForeground(Color.blue);
                    }

                    myfont = new Font("arial", 2, 13);
                    this.showPrompt.setFont(myfont);
                } else if(Math.abs(guessC - this.number) < 20) {
                    if(guessC < this.number) {
                        this.showPrompt.setText("     Guessing times:" + this.count + "; general low!                ");
                        this.showPrompt.setForeground(Color.green);
                    } else {
                        this.showPrompt.setText("     Guessing times:" + this.count + "; general low!                ");
                        this.showPrompt.setForeground(Color.orange);
                    }
                } else if(guessC < this.number) {
                    this.showPrompt.setText("    Guessing times:" + this.count + "; It's low!                    ");
                } else if(guessC > this.number) {
                    this.showPrompt.setText("    Guessing times:" + this.count + "; It's high!                    ");
                }
            } catch (NumberFormatException var5) {
                this.showPrompt.setText("please input a number!");
            }
        } else if(e.getSource() == this.buttonOut) {
            this.dispose();
        }

    }
}
