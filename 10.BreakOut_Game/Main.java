package BreakOut_Game_10;

import javax.swing.*;


//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//

public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Gameplay gamePlay = new Gameplay();

        obj.setBounds(10,10,700,600);
        obj.setTitle("Breakout Ball Game");
        obj.setResizable(false);
        obj.setVisible(true);

        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);
        obj.setVisible(true);
    }

}
