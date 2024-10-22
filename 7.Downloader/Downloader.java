package Downloader_7;


import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;


//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//

// The Download Manager.
public class Downloader extends JFrame  implements Observer{

    // Add download text field.
    private JTextField addTextField;

    // Download table's data model.
    private DownloadsTableModel tableModel;

    // Table listing downloads.
    private JTable table;

    // These are the buttons for managing the selected download.
    private JButton pauseButton, resumeButton;
    private JButton cancelButton, clearButton;

    // Currently selected download.
    private Download selectedDownload;

    // Flag for whether or not table selection is being cleared.
    private boolean clearing;

    public Downloader() {
        // Set application title.
        setTitle("Kaser Download Manager");

        // Set window size.
        setSize(640, 480);

        // Handle window closing events.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                actionExit();
            }
        });

        // Set up file menu.
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        // To set the shortcut for the JMenus
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem fileExitMenuItem = new JMenuItem("Exit",
                KeyEvent.VK_X);

        // Action Listener
        fileExitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionExit();
            }
        });
        fileMenu.add(fileExitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Set up add panel.

        // important: The panel for putting the link of Downloads
        JPanel addPanel = new JPanel();

        // important --> "30" is the size of the panel.
        addTextField = new JTextField(30);
        addPanel.add(addTextField);

        // Set up Button "Add Download"
        JButton addButton = new JButton("Add Download");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionAdd();
            }
        });
        addPanel.add(addButton);



        // Set up Downloads table.
        tableModel = new DownloadsTableModel();
        table = new JTable(tableModel);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                tableSelectionChanged();
            }
        });

        // Allow only one row at a time to be selected.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        // Set up ProgressBar as renderer for progress column.
        ProgressRenderer renderer = new ProgressRenderer(0, 100);
        renderer.setStringPainted(true); // show progress text
        table.setDefaultRenderer(JProgressBar.class, renderer);

        // Set table's row height large enough to fit JProgressBar.
        table.setRowHeight(
                (int) renderer.getPreferredSize().getHeight());



        // Set up downloads panel.
        JPanel downloadsPanel = new JPanel();
        downloadsPanel.setBorder( BorderFactory.createTitledBorder("Downloads"));
        downloadsPanel.setLayout(new BorderLayout());
        downloadsPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // ----------------------------------------------------------------
        //-----------------------------------------------------------------
        // So important:
        // Set up buttons panel.
        // ----------------------------------------------------------------
        // ----------------------------------------------------------------

        JPanel buttonsPanel = new JPanel();

        // ----------------------------------------------------------------

        // Pause Button
        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPause();
            }
        });

        pauseButton.setEnabled(false);
        buttonsPanel.add(pauseButton);

        // ----------------------------------------------------------------

        // Resume Button
        resumeButton = new JButton("Resume");
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionResume();
            }
        });

        resumeButton.setEnabled(false);
        buttonsPanel.add(resumeButton);

        // ----------------------------------------------------------------



        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionCancel();
            }
        });

        cancelButton.setEnabled(false);
        buttonsPanel.add(cancelButton);

        // ----------------------------------------------------------------

        // Clear Button
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionClear();
            }
        });

        clearButton.setEnabled(false);
        buttonsPanel.add(clearButton);

        // ----------------------------------------------------------------


        // ----------------------------------------------------------------
        // ----------------------------------------------------------------
        // Add panels to display.
        // ----------------------------------------------------------------
        // ----------------------------------------------------------------

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(addPanel, BorderLayout.NORTH);
        getContentPane().add(downloadsPanel, BorderLayout.CENTER);
        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);


    }


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // -------------------- Adding the Action Listeners ---------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------


    // Exit this program.
    private void actionExit() {
        System.exit(0);
    }

    // ----------------------------------------------------------------

    // Pause the selected download.
    private void actionPause() {
        selectedDownload.pause();
        updateButtons();
    }

    // ----------------------------------------------------------------

    // Resume the selected download.
    private void actionResume() {
        selectedDownload.resume();
        updateButtons();
    }

    // ----------------------------------------------------------------

    // Cancel the selected download.
    private void actionCancel() {
        selectedDownload.cancel();
        updateButtons();
    }

    // ----------------------------------------------------------------

    // Clear the selected download.
    private void actionClear() {
        clearing = true;
        tableModel.clearDownload(table.getSelectedRow());
        clearing = false;
        selectedDownload = null;
        updateButtons();
    }

    // ----------------------------------------------------------------


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // Add a new Download and Verify URL.
    // ----------------------------------------------------------------
    //----------------------------------------------------------------
    private void actionAdd() {
        URL verifiedUrl = verifyUrl(addTextField.getText());
        if (verifiedUrl != null) {
            tableModel.addDownload(new Download(verifiedUrl));
            addTextField.setText(""); // reset add text field
        } else {
            JOptionPane.showMessageDialog(this,
                    "Invalid Download URL", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ----------------------------------------------------------------

    // Verify download URL.
    private URL verifyUrl(String url) {
        // Only allow HTTP URLs.
        if (!url.toLowerCase().startsWith("http://") && !url.toLowerCase().startsWith("https://"))
            return null;

        // Verify format of URL.
        URL verifiedUrl = null;
        try {
            verifiedUrl = new URL(url);
        } catch (Exception e) {
            return null;
        }

        // Make sure URL specifies a file.
        if (verifiedUrl.getFile().length() < 2)
            return null;

        return verifiedUrl;
    }

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    // Called when table row selection changes.
    private void tableSelectionChanged() {
    /* Unregister from receiving notifications
       from the last selected download. */
        if (selectedDownload != null)
            selectedDownload.deleteObserver(Downloader.this);

    /* If not in the middle of clearing a download,
       set the selected download and register to
       receive notifications from it. */
        if (!clearing) {
            selectedDownload = tableModel.getDownload(table.getSelectedRow());
            selectedDownload.addObserver(Downloader.this);
            updateButtons();
        }
    }

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------


    /* Update each button's state based off of the
       currently selected download's status. */
    private void updateButtons() {
        if (selectedDownload != null) {
            int status = selectedDownload.getStatus();
            switch (status) {
                case Download.DOWNLOADING:
                    pauseButton.setEnabled(true);
                    resumeButton.setEnabled(false);
                    cancelButton.setEnabled(true);
                    clearButton.setEnabled(false);
                    break;
                case Download.PAUSED:
                    pauseButton.setEnabled(false);
                    resumeButton.setEnabled(true);
                    cancelButton.setEnabled(true);
                    clearButton.setEnabled(false);
                    break;
                case Download.ERROR:
                    pauseButton.setEnabled(false);
                    resumeButton.setEnabled(true);
                    cancelButton.setEnabled(false);
                    clearButton.setEnabled(true);
                    break;
                default: // COMPLETE or CANCELLED
                    pauseButton.setEnabled(false);
                    resumeButton.setEnabled(false);
                    cancelButton.setEnabled(false);
                    clearButton.setEnabled(true);
            }
        } else {
            // No download is selected in table.
            pauseButton.setEnabled(false);
            resumeButton.setEnabled(false);
            cancelButton.setEnabled(false);
            clearButton.setEnabled(false);
        }
    }

    /* Update is called when a Download [[ notifies ]] its
       observers of any changes. */
    public void update(Observable o, Object arg) {
        // Update buttons if the selected download has changed.
        if (selectedDownload != null && selectedDownload.equals(o))
            updateButtons();
    }


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // ------------------------ Main Method ---------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    // Run the Download Manager.
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Downloader manager = new Downloader();
        ImageIcon img = new ImageIcon("icon.png");
        manager.setIconImage(img.getImage());
        manager.show();
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        // ----------------------------------------------------------------
        // This is from ChatGPT to display the [[ icon ]]
        // ----------------------------------------------------------------

        /*
        Downloader manager = new Downloader();
        try {
            // Load the icon image
            ImageIcon img = new ImageIcon("icon.png");
            manager.setIconImage(img.getImage());
        } catch (Exception e) {
            // Log any exceptions that occur while loading the icon
            e.printStackTrace();
        }
        // Show the application
        manager.setVisible(true);

*/


    }
}

