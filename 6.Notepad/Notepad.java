package Notepad_6;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.*;


//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//
public class Notepad extends JFrame implements ActionListener {

    JMenuBar menubar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");

    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");

    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectall = new JMenuItem("Select All");

    JMenuItem about = new JMenuItem("About");

    JTextArea textArea = new JTextArea();


    Notepad() {
        setTitle("Kaser Note");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("notepad.png"));
        setIconImage(icon.getImage());
       // setResizable(true);

        setJMenuBar(menubar);
        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);

        file.addSeparator();
        edit.addSeparator();
        help.addSeparator();

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(print);
        file.add(exit);

       // menubar.add(newFile);
        //newFile.add(print);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);

        help.add(about);

        JScrollPane scrollpane = new JScrollPane(textArea);
        add(scrollpane);
//        My try
//        textArea.setFont((new Font("Noor Bold", Font.PLAIN, 20)));
        textArea.setFont((new Font(Font.SANS_SERIF, Font.PLAIN, 20)));

        //So important: to prevent make the text go through Width without creating new line
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setBorder(BorderFactory.createEmptyBorder());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);



        // Add Action with  Every Action out there.

        // File Menu
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);



        // Edit Menu
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);

        // About Menu
        about.addActionListener(this);



        // Modifying the Shortcuts : Yummy :)
        // 1:51-PM - 25.April - 16.Shawwal

        // File Menu
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.CTRL_DOWN_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));

        // Edit Menu
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));

        // About Menu
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));


    }


        public static void main(String[] args) throws Exception{

        // This lins is for the program to be with new UI.
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        new Notepad().setVisible(true);

        }


    @Override
    public void actionPerformed(ActionEvent e) {

        // New
        if (e.getActionCommand().equals("New")) {
            // Here when the user clicks "New" I can make the default Text!
            //  textArea.setText("Kaser Qurashi");
            textArea.setText(null);
        }

        //  Save
        else if (e.getActionCommand().equalsIgnoreCase("Save")) {

            JFileChooser fileChooser = new JFileChooser();
            textArea.setText("Kaser!");

            // What the Extension that you want to specify!
            // and Specify the Message taht will be shown on the Saving Widget!
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);

            int action = fileChooser.showSaveDialog(null);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
                if (!fileName.contains(".txt"))
                    fileName = fileName + ".txt";

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    textArea.write(writer);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        //Open
        else if (e.getActionCommand().equalsIgnoreCase("Open")) {

            // Here is where I can Hack :) mmmmmmm - من كيس عبدالله القرشي -
            // in the constructor of "JFileChooser" you can choose the file to open.
            JFileChooser fileChooser = new JFileChooser("");
//            textArea.setText("Kaser!");

            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);

            int action = fileChooser.showSaveDialog(null);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
                if (!fileName.contains(".txt"))
                    fileName = fileName + ".txt";

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    textArea.write(writer);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }

        // Print
        else if (e.getActionCommand().equalsIgnoreCase("Print")) {
            try {
                textArea.print();
            } catch (PrinterException ex) {
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Exit
        } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
            System.exit(0);
        }
        // Cut
        else if (e.getActionCommand().equalsIgnoreCase("Cut")) {
            textArea.cut();
            // Copy
        } else if (e.getActionCommand().equalsIgnoreCase("Copy")) {
            textArea.copy();
        }
        // Paste
        else if (e.getActionCommand().equalsIgnoreCase("Paste")) {
            textArea.paste();
        }
        // Select All
        else if (e.getActionCommand().equalsIgnoreCase("Select All")) {
            textArea.selectAll();
        }
        // About
        else if (e.getActionCommand().equalsIgnoreCase("About")) {
            new About().setVisible(true);

        }

    }

}
