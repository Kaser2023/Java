package Downloader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;



//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//


public class Download_URL {
    public static void main(String[] args) {
        // Make sure that this directory exists
        String dirName = "E:\\2";
        try {
            saveFileFromUrlWithJavaIO(
                    dirName + "\\kaser.png", "https://w7.pngwing.com/pngs/327/783/png-transparent-blue-sky-and-white-clouds-blue-blue-sky-blue-clouds.png");
            System.out.println("finished");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Using Java IO
    public static void saveFileFromUrlWithJavaIO(String fileName, String fileUrl)
            throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try { in = new BufferedInputStream(new URL(fileUrl).openStream());
            fout = new FileOutputStream(fileName);
            byte data[] = new byte[1024];
            int count;
            while ((count = in .read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if ( in != null)
                in .close();
            if (fout != null)
                fout.close();
        }
    }
    // Using Commons IO library
    // Available at http://commons.apache.org/io/download_io.cgi
    public static void saveFileFromUrlWithCommonsIO(String fileName,
                                                    String fileUrl) throws MalformedURLException, IOException {
        FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
    }
}