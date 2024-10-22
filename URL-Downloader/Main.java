//package url;

import java.io.File;


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

        String link = "https://pbs.twimg.com/media/EcfgjILXQAAYnlC.jpg";
        File out = new File("E:\\2\\ kaser.jpg");
        new Thread (new Download (link, out)).start();


    }

}