package Painting_Canvas_9;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This Class will Save the Image in the Format of "JPG"!
import java.awt.image.BufferedImage;

import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

// Change Event
import javax.swing.event.ChangeEvent;
// Cahange Listener
import javax.swing.event.ChangeListener;


public class DrawingEditor extends JFrame {

    Random rnd = new Random();

    //Icons
    Icon rec = new ImageIcon(getClass().getResource("img\\rec.png"));
    // Icon rec = new ImageIcon(getClass().getResource("/img/rec.png"));
    Icon circ = new ImageIcon(getClass().getResource("img\\circ.png"));
    Icon line = new ImageIcon(getClass().getResource("img\\line.png"));
    Icon garbage = new ImageIcon(getClass().getResource("img\\garbage.png"));
    Icon del = new ImageIcon(getClass().getResource("img\\del.png"));
    Icon tic = new ImageIcon(getClass().getResource("img\\tik.png"));
    Icon sve = new ImageIcon(getClass().getResource("img\\save.png"));

    //Icons
//    static Color currentCol = Color.BLACK;
    static Color currentCol = new Color(89, 149, 1);

    // The Color of the Left/Right Side of the Program
    Color systemColor = new Color(255, 149, 1);
//    Color systemColor = new Color(89, 149, 1);


    // ----------------------------------------------------------------
    // The Line Color and Size
    static Color lineCol;
    static int lineSize;
    // ----------------------------------------------------------------

    JRadioButton emptyRec, fullRec, emptyCir, fullCir;
    int recW, recH, cirW, cirH;
    //int pointCounter = 0;


    DrawingArea center;
    static JPanel left = new JPanel(),
            topRec = new JPanel(),
            topCir = new JPanel(),
            topLine = new JPanel();

    JButton save, rect, circle, lne, rmv, clearAll, DrawRec, setRecCol, DrawCir, setCirCol, setLineCol;

    static boolean remove = false;
    static JPanel currentTop = topRec;


    public DrawingEditor() {

        // ----------------------------------------------------------------
        // Easy to Understand
        // ----------------------------------------------------------------
        //Main Frame
        setSize(1000, 800); //location and size
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close button stops the app
        setLocationRelativeTo(null);// middle of the screen
        //setResizable(false);
        setVisible(true);
        setTitle("Kaser Drawing Editor");
        //Main Frame
        // ----------------------------------------------------------------


        // ----------------------------------------------------------------
        // The Drawing Area - Left-Right and Main-Center
        // ----------------------------------------------------------------
        //Drawing Area Center JPanel
        center = new DrawingArea();
        add(center, BorderLayout.CENTER);
        //Drawing Area Center JPanel

        //Left JPanel
        left.setBackground(systemColor);
        add(left, BorderLayout.WEST);
        addButtonsToLeft();
        //Left JPanel

        //TOP PANEL SETTINGS
        topRec.setBackground(systemColor);
        add(topRec, BorderLayout.NORTH);
        recButtons();
        // ----------------------------------------------------------------
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        // The Buttons
        // ----------------------------------------------------------------
        topCir.setBackground(systemColor);
        circButtons();

        topLine.setBackground(systemColor);
        lineButtons();
        //TOP PANEL SETTING

        //DUTY OF BUTTONS
        dutyButtons();
        //DUTY OF BUTTONS
        // ----------------------------------------------------------------
        // ----------------------------------------------------------------

    }


    // Thr Adding Button Method:
    public void addButtonsToLeft() {

        // Setting up the Buttons:
        rect = new JButton(null, rec);
        circle = new JButton(null, circ);
        lne = new JButton(null, line);
        clearAll = new JButton(null, garbage);
        rmv = new JButton(null, tic);
        save = new JButton(null, sve);

        //
        rect.setFocusPainted(false);
        circle.setFocusPainted(false);
        lne.setFocusPainted(false);
        clearAll.setFocusPainted(false);
        rmv.setFocusPainted(false);
        save.setFocusPainted(false);

        // Setting up the Colors of Background:
        rect.setBackground(Color.white);
        circle.setBackground(Color.white);
        lne.setBackground(Color.white);
        clearAll.setBackground(Color.white);
        rmv.setBackground(Color.white);
        save.setBackground(Color.white);

        // ----------------------------------------------------------------
        // Setting up the Visibility of Buttons
        // ----------------------------------------------------------------
        JButton visible = new JButton();
        visible.setVisible(false);
        JButton visible1 = new JButton();
        visible1.setVisible(false);
        JButton visible2 = new JButton();
        visible2.setVisible(false);
        JButton visible3 = new JButton();
        visible3.setVisible(false);

        JButton visible4 = new JButton();
        visible4.setVisible(false);
        JButton visible5 = new JButton();
        visible5.setVisible(false);
        JButton visible6 = new JButton();
        visible6.setVisible(false);
        JButton visible7 = new JButton();
        visible7.setVisible(false);
        // ----------------------------------------------------------------
        // ----------------------------------------------------------------


        left.setLayout(new GridLayout(0, 1));

        left.add(save);
        left.add(visible1);
        left.add(visible2);
        left.add(rect);

        left.add(visible3);
        left.add(circle);

        left.add(visible5);
        left.add(lne);

        left.add(visible6);
        left.add(visible7);
        left.add(rmv);
        left.add(clearAll);

    }


    // ----------------------------------------------------------------
    // if the Button is Clicked --> then  Draw Rectangle.
    // ----------------------------------------------------------------
    public void topRec() {

        if (currentTop != topRec) {
            remove(currentTop);
            add(topRec, BorderLayout.NORTH);
            currentTop = topRec;
            SwingUtilities.updateComponentTreeUI(this);
        }

    }

    // ----------------------------------------------------------------
    // if the Button is Clicked --> then  Draw Circle.
    // ----------------------------------------------------------------
    public void topCir() {
        if (currentTop != topCir) {
            remove(currentTop);
            add(topCir, BorderLayout.NORTH);
            currentTop = topCir;
            SwingUtilities.updateComponentTreeUI(this);
        }

    }


    // ----------------------------------------------------------------
    // if the Button is Clicked --> then  Draw Line.
    // ----------------------------------------------------------------
    public void topLine() {
        if (currentTop != topLine) {
            remove(currentTop);
            add(topLine, BorderLayout.NORTH);
            currentTop = topLine;
            SwingUtilities.updateComponentTreeUI(this);
        }

    }
        // ----------------------------------------------------------------
        // ----------------------------------------------------------------



        // ----------------------------------------------------------------
    // Draw Rectangle Button
        // ----------------------------------------------------------------
        public void recButtons() {

            SpinnerModel value1 = new SpinnerNumberModel(0, 0, 800, 50);
            SpinnerModel value2 = new SpinnerNumberModel(0, 0, 800, 50);

            JLabel wid = new JLabel("Width: ");
            wid.setFont(new Font("Calinri", 1, 15));
            topRec.add(wid);
            JSpinner w = new JSpinner(value1);

            w.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent ce) {
                    recW = (int) ((JSpinner) ce.getSource()).getValue();
                }
            });
            topRec.add(w);

            topRec.add(new JLabel("        "));

            JLabel hei = new JLabel("Width: ");
            hei.setFont(new Font("Calinri", 1, 15));
            topRec.add(hei);
            JSpinner h = new JSpinner(value2);
            h.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent ce) {
                    recH = (int) ((JSpinner) ce.getSource()).getValue();
                }
            });
            topRec.add(h);

            topRec.add(new JLabel("        "));

            setRecCol = new JButton("SET COLOR");
            setRecCol.setFocusPainted(false);
            setRecCol.setBackground(Color.WHITE);
            topRec.add(setRecCol);

            //ISFileed
            ButtonGroup g1 = new ButtonGroup();
            topRec.add(new JLabel("      "));

            emptyRec = new JRadioButton("EMPTY");
            fullRec = new JRadioButton("FULL");
            topRec.add(emptyRec);
            topRec.add(fullRec);

            g1.add(emptyRec);
            g1.add(fullRec);

            topRec.add(new JLabel("               "));

            DrawRec = new JButton("DRAW RECTANGLE");
            DrawRec.setFocusPainted(false);
            DrawRec.setBackground(Color.WHITE);
            topRec.add(DrawRec);
            //IsFilled

            SwingUtilities.updateComponentTreeUI(this);
        }

        // ----------------------------------------------------------------
        // ----------------------------------------------------------------


    // ----------------------------------------------------------------
    // Draw Circle
    // ----------------------------------------------------------------

    public void circButtons() {
        SpinnerModel value3 = new SpinnerNumberModel(0, 0, 800, 50);
        SpinnerModel value4 = new SpinnerNumberModel(0, 0, 800, 50);

        JLabel wid = new JLabel("Width: ");
        wid.setFont(new Font("Calinri", 1, 15));
        topCir.add(wid);
        JSpinner w2 = new JSpinner(value3);

        w2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                cirW = (int) ((JSpinner) ce.getSource()).getValue();
            }
        });
        topCir.add(w2);

        topCir.add(new JLabel("        "));

        JLabel hei = new JLabel("Width: ");
        hei.setFont(new Font("Calinri", 1, 15));
        topCir.add(hei);
        JSpinner h2 = new JSpinner(value4);
        h2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                cirH = (int) ((JSpinner) ce.getSource()).getValue();
            }
        });
        topCir.add(h2);

        topCir.add(new JLabel("        "));

        setCirCol = new JButton("SET COLOR");
        setCirCol.setFocusPainted(false);
        setCirCol.setBackground(Color.WHITE);
        topCir.add(setCirCol);

        //ISFileed
        ButtonGroup g1 = new ButtonGroup();
        topCir.add(new JLabel("      "));

        emptyCir = new JRadioButton("EMPTY");
        fullCir = new JRadioButton("FULL");
        topCir.add(emptyCir);
        topCir.add(fullCir);

        g1.add(emptyCir);
        g1.add(fullCir);

        topCir.add(new JLabel("               "));
        //IsFilled

        DrawCir = new JButton("DRAW OVAL");
        DrawCir.setFocusPainted(false);
        DrawCir.setBackground(Color.WHITE);
        topCir.add(DrawCir);

        SwingUtilities.updateComponentTreeUI(this);
    }

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    // ----------------------------------------------------------------
    // Draw Line
    // ----------------------------------------------------------------
    public void lineButtons() {
        SpinnerModel value4 = new SpinnerNumberModel(0, 0, 5, 1);
        JLabel s = new JLabel("Size: ");
        s.setFont(new Font("Calinri", 1, 15));
        topLine.add(s);

        JSpinner w5 = new JSpinner(value4);
        w5.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                lineSize = (int) ((JSpinner) ce.getSource()).getValue();
            }
        });
        topLine.add(w5);

        topLine.add(new JLabel("                       "));

        setLineCol = new JButton("SET COLOR");

        setLineCol.setFocusPainted(false);
        setLineCol.setBackground(Color.WHITE);
        topLine.add(setLineCol);

        topLine.add(new JLabel("              "));
        JLabel firstP = new JLabel("Please Click First Point and Drag to Second Point");
        firstP.setFont(new Font("Calibri", 1, 20));
        topLine.add(firstP);

    }

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // Adding [[ Action Listeners  ]] for All Buttons
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    public void dutyButtons() {

        // ----------------------------------------------------------------
        // ----------- LEFT ------------------------
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        // Save Button
        // ----------------------------------------------------------------
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                takeSnapShot(center);
            }
        });

        // ----------------------------------------------------------------
        // Rectangle Button
        // ----------------------------------------------------------------
        rect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                topRec();

            }
        });


        // ----------------------------------------------------------------
        // Circle Button
        // ----------------------------------------------------------------
        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                topCir();
            }
        });

        // ----------------------------------------------------------------
        // Line Button
        // ----------------------------------------------------------------
        lne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                topLine();
            }
        });


        // ----------------------------------------------------------------
        // Remove Button
        // ----------------------------------------------------------------
        rmv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (remove == true) {
                    remove = false;
                    rmv.setIcon(tic);

                } else {
                    rmv.setIcon(del);
                    remove = true;
                }

            }

        });


        // ----------------------------------------------------------------
        // Clear All Button
        // ----------------------------------------------------------------
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DrawingArea.shapes.clear();
                center.drawing();
            }

        });
        // ----------------------------------------------------------------
        // ----------- End - LEFT ------------------------
        // ----------------------------------------------------------------


        // ----------------------------------------------------------------
        // ----------- TopREC ------------------------
        // ----------------------------------------------------------------

        setRecCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Color c = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
                if (c != null) {
                    currentCol = c;
                }
            }
        });

        DrawRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (fullRec.isSelected()) {
                    DrawingArea.shapes.add(new Rectangle(rnd.nextInt(800), rnd.nextInt(600), recW, recH, currentCol, 1));
                    center.drawing();
                } else {
                    DrawingArea.shapes.add(new Rectangle(rnd.nextInt(800), rnd.nextInt(600), recW, recH, currentCol, 0));
                    center.drawing();
                }
            }
        });
        // ----------------------------------------------------------------
        // ----------- End - TopREC ------------------------
        // ----------------------------------------------------------------


        // ----------------------------------------------------------------
        // -----------  TopCir ------------------------
        // ----------------------------------------------------------------
        setCirCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Color c = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
                if (c != null) {
                    currentCol = c;
                }
            }
        });

        DrawCir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (fullCir.isSelected()) {
                    DrawingArea.shapes.add(new Circle(rnd.nextInt(800), rnd.nextInt(600), cirW, cirH, currentCol, 1));
                } else {
                    DrawingArea.shapes.add(new Circle(rnd.nextInt(800), rnd.nextInt(600), cirW, cirH, currentCol, 0));
                }
                center.drawing();
            }
        });
        // ----------------------------------------------------------------
        // ----------- End - TopCir ------------------------
        // ----------------------------------------------------------------


        // ----------------------------------------------------------------
        // ----------- TopLine ------------------------
        // ----------------------------------------------------------------
        setLineCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Color c = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
                if (c != null) {
                    lineCol = c;
                }
            }
        });
        // ----------------------------------------------------------------
        // ----------- End - TopLine ------------------------
        // ----------------------------------------------------------------

    }


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // This is the Method that will Save the Images in "JPG" format.
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    void takeSnapShot(JPanel panel) {
        BufferedImage bufImage = new BufferedImage(panel.getSize().width, panel.getSize().height, BufferedImage.TYPE_INT_RGB);
        panel.paint(bufImage.createGraphics());

        // parent component of the dialog
        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("File will be saved as jpeg format");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                if (!new File(fileToSave.getAbsolutePath() + ".jpg").isFile()) {
                    ImageIO.write(bufImage, "jpeg", new File((fileToSave.getAbsolutePath() + ".jpg")));
                    JOptionPane.showMessageDialog(panel, "The image has been saved successfully");
                } else {
                    String[] options = {"Yes", "No"};
                    int x = JOptionPane.showOptionDialog(null, "Do you want to overwrite " + fileToSave.getAbsolutePath() + ".jpg",
                            "Click a button",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (x == 0) {
                        ImageIO.write(bufImage, "jpeg", new File((fileToSave.getAbsolutePath() + ".jpg")));
                        JOptionPane.showMessageDialog(panel, "The image has been saved successfully");
                    } else {
                        takeSnapShot(panel);
                    }

                }
            } catch (Exception ex) {
            }
        }
    }



    public static void main(String args[]) throws Exception{

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DrawingEditor app = new DrawingEditor();

            }
        });


    }



}
