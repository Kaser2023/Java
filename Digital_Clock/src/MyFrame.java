
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {


    //Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLable;
    JLabel dayLable;
    JLabel dateLable;
    String time;
    String day;
    String date;

    MyFrame (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        //this.setResizable(false);


        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd,,, yyyy");



        timeLable = new JLabel ();
        timeLable.setFont(new Font ("Noor", Font.BOLD, 50));
        timeLable.setForeground(new Color (0xFFFFFF));
        timeLable.setBackground(new Color (0xCB5D46) );
        timeLable.setOpaque(true);


        dayLable = new JLabel ();
        dayLable.setFont(new Font ("noor", Font.PLAIN, 30));

        dateLable = new JLabel ();
        dateLable.setFont(new Font ("noor", Font.PLAIN, 20));



        this.add(timeLable);
        this.add(dayLable);
        this.add(dateLable);
        this.setVisible(true);

        setTime();


    }

    public void setTime(){

        while (true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLable.setText(time) ;

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLable.setText(day) ;

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLable.setText(date) ;

            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }


        }

    }


}