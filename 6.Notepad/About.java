package Notepad_6;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame{
    About() {
        setTitle("About Kaser Note Application");
        setBounds(100, 100, 500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("notepad.png"));
        setIconImage(icon.getImage());

        JLabel iconLabel= new JLabel( new ImageIcon(getClass().getResource("windows.png")));
        iconLabel.setBounds(150, 40, 400, 80);
        add(iconLabel);

        JLabel textLabel = new JLabel("<html>Kaser Note<br>Conventional Notepad Version 2.0<br> All rights reserved<br><br>Kaser Note is a word processing program, <br>which allows changing of text in a computer file.<br>Kaser Note is a simple text editor for basic text-editing program which enables computer users to create documents. </html>");
//        JLabel textLabel = new JLabel("");
//        JLabel label = new JLabel("<html>line 1<p><font color=blue size=+2>"
//                + "big blue</font> line 2<p>line 3 jjjjjj<p>K</html>");
        textLabel.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        textLabel.setBounds(150, 130, 500, 300);
        add(textLabel);
//        label.setBounds(150, 130, 500, 300);
//        add(label);


    }


    public static void main(String[] args){
        new About().setVisible(true);
    }


}

