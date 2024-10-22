//package url;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        String link = "https://pbs.twimg.com/media/EcfgjILXQAAYnlC.jpg";
        File out = new File("E:\\2\\ kaser.jpg");
        new Thread (new Download (link, out)).start();


    }

}