package FileBroswer_8;
// ----------------------------------------------------------------
// AWT Package
// ----------------------------------------------------------------
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
// ----------------------------------------------------------------
// AWT  Event Package
// ----------------------------------------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
// ----------------------------------------------------------------
// Input and Output Package
// ----------------------------------------------------------------
import java.beans.Transient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
// ----------------------------------------------------------------
// Input and Output "IO Exception" Package
// ----------------------------------------------------------------
import java.io.IOException;
// ----------------------------------------------------------------
// Input and Output Package
// ----------------------------------------------------------------
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
// ----------------------------------------------------------------
// Swing Package - [[ JTree ]], JFrame, JButton, JLabel,
// JMenuBar, Jpanel, JTextArea, JScrollPane
// ----------------------------------------------------------------
import javax.swing.*;
// ----------------------------------------------------------------
// Swing Event Tree Package
// ----------------------------------------------------------------
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
// ----------------------------------------------------------------
// Swing File
// ----------------------------------------------------------------
import javax.swing.filechooser.FileSystemView;
// ----------------------------------------------------------------
// Delicious: Swing Tree Package
// ----------------------------------------------------------------
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
public class FileBrowser  extends JPanel implements ComponentListener  {


//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//

    private static final long serialVersionUID = 1L;
    private JFrame frame;

    // This is for Showing: 
    // 1.Bar Panel [Return Button and Path of files] and 
    // 2.Footer Panel [Buttons New File, Rename, New Folder...] ans Countering number of files/folders.
    private JPanel displayPanel;

    // This for Showing the Tree Folders
    private JPanel   showPanel;

    private JButton renameFileButton, addFileButton, addFolderButton,
    /* Back Button */ retButton, saveFileButton;
    private JLabel footerInfoLabel;
    private DefaultMutableTreeNode computer, root;
    private DefaultTreeModel treeModel;
    private JTree tree;
    private JTextField treeTextField;
    private JScrollPane treeScroll, showScrollPane;
    private String currentFolder = "", selectedFolder = null;
    private int width = 1000;
    private int height = 700;
    private FileSystemView fileSystemView;
    private JTextArea textArea;

    // ----------------------------------------------------------------
    // --------------------- So important: ----------------------------
    // ----------------------------------------------------------------
    // This build() method contains Every Component inside the Frame.
    // ----------------------------------------------------------------
    private void build() {
        frame = new JFrame("Kaser File Browser");
        // ----------------------------------------------------------------
        // For the size of the Frame of the Program
        frame.setPreferredSize(new Dimension(width, height));
        frame.setSize(frame.getPreferredSize());
        frame.setLocationRelativeTo(null);
        // If we did not Pack the Frame,
        // then the full size of the Frame will not be Visible!
        frame.pack();
        // ----------------------------------------------------------------

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setFocusable(true);
        frame.setBackground(Color.black);
        frame.setIconImage(getImg("img/fil e4.jpg"));
        frame.add(this, BorderLayout.CENTER);

        setPreferredSize(new Dimension(width, height));
        setSize(getPreferredSize());
        setBackground(Color.black);
        setFocusable(true);
        setBorder(BorderFactory.createBevelBorder(0, Color.black, Color.black));
        setLayout(new BorderLayout(0, 0));


        // ----------------------------------------------------------------
        // My trying to set the background Image
        // ----------------------------------------------------------------
        // Assuming you have an image file named "background.jpg" in the same directory as your Java program.

        // Create a JLabel to hold the background image
        //		JLabel backgroundLabel = new JLabel(new ImageIcon("background7.jpeg"));

        // Set layout of the content pane to BorderLayout to cover the entire frame
        //setLayout(new BorderLayout());

        // Add the background label to the content pane as the bottom layer
        //		add(backgroundLabel, BorderLayout.CENTER);

        // Now, you can add your other components on top of the background label

        // ----------------------------------------------------------------
        // ----------------------------------------------------------------

        retButton = new JButton(" ");
        retButton.setIcon(new ImageIcon(getImg("img/back.jpg", 40, 30).getImage()));
        retButton.setBackground(new Color(0, 0, 0, 0));
//        retButton.setBackground(Color.white);
        retButton.setOpaque(false);
        retButton.setFocusable(false);

        // ----------------------------------------------------------------
        // This is for the Label of Text "My Computer".
        // ----------------------------------------------------------------
        treeTextField = new JTextField("K-My Computer");
        treeTextField.setEditable(false);
        treeTextField.setOpaque(false);
        treeTextField.setForeground(Color.white);
        treeTextField.setFont(new Font("Tahoma", Font.BOLD, 14));

        showPanel = new JPanel();
        showPanel.setOpaque(false);
        showPanel.setLayout(new FlowLayout(0));

        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        //  New [[ Folder ]] Button
        // ----------------------------------------------------------------
        addFolderButton = new JButton("new Folder");
        addFolderButton.setOpaque(false);
        addFolderButton.setBackground(new Color(0, 0, 0, 0));
        addFolderButton.setForeground(Color.WHITE);

        // ----------------------------------------------------------------
        // Why we use this [[ setFocusable ]] and what it will do?
        addFolderButton.setFocusable(false);
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        // New [[ File ]] Button
        // ----------------------------------------------------------------
        addFileButton = new JButton("new File");
        addFileButton.setOpaque(false);
        addFileButton.setBackground(new Color(0, 0, 0, 0));
        addFileButton.setForeground(Color.WHITE);
        addFileButton.setFocusable(false);
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        // New [[ Rename ]] Button
        // ----------------------------------------------------------------
        renameFileButton = new JButton("Rename");
        renameFileButton.setOpaque(false);
        renameFileButton.setBackground(new Color(0, 0, 0, 0));
        renameFileButton.setForeground(Color.WHITE);
        renameFileButton.setFocusable(false);
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        // New [[ Save ]] Button
        // ----------------------------------------------------------------
        saveFileButton = new JButton("Save");
        saveFileButton.setOpaque(false);
        saveFileButton.setBackground(new Color(0, 0, 0, 0));
        saveFileButton.setForeground(Color.WHITE);
        saveFileButton.setFocusable(false);
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        //  [[ Buttons Footer Panel ]] 
        // ----------------------------------------------------------------
		JPanel bttonsFooterPanel = new JPanel();
		bttonsFooterPanel.setOpaque(false);
		bttonsFooterPanel.setLayout(new FlowLayout(0));
		//bttonsFooterPanel.setLayout(new BorderLayout(6,6));
		//bttonsFooterPanel.setLayout(new GridLayout(1,4,1,8));
		bttonsFooterPanel.add(saveFileButton);
		bttonsFooterPanel.add(renameFileButton);
		bttonsFooterPanel.add(addFileButton);
		bttonsFooterPanel.add(addFolderButton);
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        //  [[ Counter ]] for the number of Files/Folders in the Folder.
        // ----------------------------------------------------------------
		File file = new File(currentFolder);
		footerInfoLabel = new JLabel();
        // Here to set the Icon for The Current Folder that we're in.
		footerInfoLabel.setIcon(fileSystemView.getSystemIcon(file));

		// [[ setText ]] this is by default will show "3 element(s)"
		// But this is not True! maybe it will be 2,3,4,5?
		// BTW- It shouldn't be declared any number.
		footerInfoLabel.setText(" 3 element(s)");

        // This is the Responsible for Counting the Numbers of Files/Folders
        // Depending on the "Path" that we're in "file.getPath()".
		footerInfoLabel.setToolTipText(file.getPath());
        // The Dimension of the Panel.
		footerInfoLabel.setPreferredSize(new Dimension(120, 60));
		footerInfoLabel.setSize(footerInfoLabel.getPreferredSize());
		footerInfoLabel.setForeground(Color.white);
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        //  [[ Footer Panel ]]
        // ----------------------------------------------------------------
        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(750, getHeight() / 20));
        footerPanel.setSize(footerPanel.getPreferredSize());
        footerPanel.setBackground(Color.black);
        footerPanel.setLayout(new BorderLayout(0, 0));
        // Where will be the Direction for Panel of Countering Files/Folders
        footerPanel.add(footerInfoLabel, BorderLayout.EAST);
        // Where will be the Direction for Panel of Buttons [ Rename, Save, New File, New Folder ]
        footerPanel.add(bttonsFooterPanel, BorderLayout.WEST);
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        //  This is the [[ Bar Panel ]] for  shwing
        //  1.Return Button.
        //  2.Path of Files.
        // ----------------------------------------------------------------
        JPanel barPanel = new JPanel();
        barPanel.setOpaque(false);
        barPanel.setLayout(new BorderLayout(0, 0));
        //  1.Return Button.
        barPanel.add(retButton, BorderLayout.WEST);
        //  2.Path of Files.
        barPanel.add(treeTextField, BorderLayout.CENTER);
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        //  This is the [[ Display Panel ]] for Showing:
        // 1.Return Button and Path of Files.
        // 2. Footer Panel, which is showing
        // ----------------------------------------------------------------
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(getWidth() * 7 / 10, getHeight()));
        displayPanel.setOpaque(false);
        displayPanel.setBorder(BorderFactory.createBevelBorder(0, Color.black, Color.black));
        displayPanel.setLayout(new BorderLayout(0, 0));
        // 1.Return Button
        // 2.Path of Files.
        displayPanel.add(barPanel, BorderLayout.SOUTH);
        // 2. Footer Panel, which is showing the:
        // 1.Panel of "Buttons" [ Rename, Save, New File, New Folder ]
        // 2.Panel of "Countering" Files/Folders
        displayPanel.add(footerPanel, BorderLayout.NORTH);

        // Finally, الحمدلله -- I've finished this Method :)
        // it's tired me, but I get Every single line of this Code. الحمدلله

    }

    @SuppressWarnings("deprecation")
    public FileBrowser() {

        fileSystemView = FileSystemView.getFileSystemView();
		build();

		computer = new DefaultMutableTreeNode("");
		DefaultMutableTreeNode node1 = null;
		File[] files = File.listRoots();
		for (File file : files) {
			node1 = new DefaultMutableTreeNode(file);
			computer.add(node1);
			node1.add(new DefaultMutableTreeNode(new Boolean(true)));
			remplirShowPane(file, 0);
		}

        treeModel = new DefaultTreeModel(computer);
		tree = new JTree(treeModel);
		tree.setOpaque(false);
		tree.setShowsRootHandles(true);
		tree.setRootVisible(false);
 
        // ----------------------------------------------------------------
        // 1.Mouse Listener
        // 2.SetCellRenderer
        // ----------------------------------------------------------------
        tree.setCellRenderer(new FileTreeCellRenderer());
		tree.addMouseListener(new Mouse());
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			// Detect any File or Directory selected in JTree

			@SuppressWarnings("unused")
			@Override
			public void valueChanged(TreeSelectionEvent event) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) event.getPath().getLastPathComponent();
				File file = new File(node.getUserObject().toString());

                // ----------------------------------------------------------------
                // Change the Path of th folder Depending of the Path that you're in.
                // ----------------------------------------------------------------
				if (file != null) {
					currentFolder = file.getAbsolutePath();
					treeTextField.setText(currentFolder);
				}
                // ----------------------------------------------------------------
                // Or you're in the Root folder.
                // ----------------------------------------------------------------
                else {
					treeTextField.setText("Computer");
					currentFolder = "";
				}
				OpenFile(file);
				selectedFolder = null;
			}
		});


        // ----------------------------------------------------------------
        // ----------------------------------------------------------------
        // ----------------------------------------------------------------
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        // Thread Expanded Listener
        // ----------------------------------------------------------------
        tree.addTreeExpansionListener(new TreeExpansionListener() {
			// Make sure expansion is threaded and updating the tree model
			// only occurs within the event dispatching thread.
			@Override
			public void treeExpanded(TreeExpansionEvent event) {
				final DefaultMutableTreeNode node = (DefaultMutableTreeNode) event.getPath().getLastPathComponent();

				Thread runner = new Thread() {
					public void run() {
						node.removeAllChildren();
						createChildren(node);
						Runnable runnable = new Runnable() {
							public void run() {
								treeModel.reload(node);
							}
						};
						SwingUtilities.invokeLater(runnable);
					}
				};
				runner.start();
			}
			public void treeCollapsed(TreeExpansionEvent event) {
			}
		});
		tree.expandRow(1);

        // Tree Scroll Panel -- Vertical Scroll Panel and Horizontal Scroll Panel
        treeScroll = new JScrollPane(tree);
        treeScroll.setPreferredSize(new Dimension(250, (int) getHeight()));
        treeScroll.setOpaque(false);
        treeScroll.setBorder(BorderFactory.createBevelBorder(0, Color.black, Color.black));
        treeScroll.getViewport().setOpaque(false);


        // ----------------------------------------------------------------
        // Add Action Listener for [ Return ] Button
        // ----------------------------------------------------------------
        retButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (currentFolder != null && !currentFolder.equals("")) {
					currentFolder = new File(currentFolder).getParent();
					if (currentFolder != null && !currentFolder.equals("")) {

                        // Here to show the path of the current folder
                        // --------------------------------
						treeTextField.setText(currentFolder);
						OpenFile(new File(currentFolder));
					}
				}
				selectedFolder = null;
			}
		});
        // ----------------------------------------------------------------


        // ----------------------------------------------------------------
        // Add Action Listener for [ Add Folder ] Button
        // ----------------------------------------------------------------
        addFolderButton.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String nameFolder = JOptionPane.showInputDialog(frame, " Enter the Name of new Folder : ");
				if (nameFolder != null && !nameFolder.equals("")) {
					new File(currentFolder + "\\" + nameFolder).mkdirs();
					OpenFile(new File(currentFolder));
				}
				selectedFolder = null;
            }

        });
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        // Add Action Listener for [ Add File ] Button
        // ----------------------------------------------------------------

        addFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nameFile = JOptionPane.showInputDialog(frame, " Enter the Name of new File.txt : ");
				if (nameFile != null && !nameFile.equals("")) {
					if (selectedFolder == null) {

                        // Here after clicking "Add File" the Extension of the file will be ".txt",
                        // So if we want to let it without thie extension,
                        // Just remove the ".txt".

						currentFolder = currentFolder + "\\" + nameFile + ".txt";
                        // currentFolder = currentFolder + "\\" + nameFile;
						File f = new File(currentFolder);
						writeFile(f.toPath(), "");

						// ----------------------------------------------------------------
						// This line is for Opening the File [[ Directly! ]] after Creating it.
						// if I will comment it, it will create the file and NOT OPEN it Directly
						// ----------------------------------------------------------------

						OpenFile(f);

					} else {
						selectedFolder = selectedFolder + "\\" + nameFile + ".txt";
						currentFolder = selectedFolder;
						File f = new File(selectedFolder);
						writeFile(f.toPath(), "");

                        // ----------------------------------------------------------------
						// This line is for Opening the File [[ Directly! ]] after Creating it.
						// if I will comment it, it will create the file and NOT OPEN it Directly
						// ----------------------------------------------------------------
                         
						OpenFile(f);
					}
				}
				selectedFolder = null;
			}
		});
        // ----------------------------------------------------------------



        // ----------------------------------------------------------------
        // Add Action Listener for [ Rename File ] Button
        // ----------------------------------------------------------------
        renameFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (selectedFolder != null) {
					String nameFile = JOptionPane.showInputDialog(frame, " Enter the new Name : ");
					if (nameFile != null && !nameFile.equals("")) {
						File file = new File(selectedFolder);
						selectedFolder = file.getParent() + "\\" + nameFile;
						if (file.isDirectory())
							file.renameTo(new File(selectedFolder));
						else
							file.renameTo(new File(selectedFolder + ".txt"));
						OpenFile(new File(currentFolder));
						treeTextField.setText(currentFolder);
					}
					selectedFolder = null;
				}
			}
		});
        // ----------------------------------------------------------------


        // ----------------------------------------------------------------
        // Add Action Listener for [ Save ] Button
        // ----------------------------------------------------------------
        
		saveFileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				File f = new File(currentFolder);
				if (f.exists())
					try {
						String fileType = Files.probeContentType(f.toPath());
						if (fileType != null)
							if (fileType.equals("text/plain"))
								writeFile(f.toPath(), textArea.getText());
					} catch (IOException e) {
						System.out.println("!! Error : " + e);
					}
			}
		});
        // ----------------------------------------------------------------
        // ----------------------------------------------------------------
        // ----------------------------------------------------------------
        // ----------------------------------------------------------------




        // ----------------------------------------------------------------
        // The Scroll Panel Between [ Show Panel ] and [ Display Panel ]
        // ----------------------------------------------------------------
        JScrollPane AfficageScroll = new JScrollPane(showPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        AfficageScroll.setOpaque(false);
        AfficageScroll.getViewport().add(showPanel);
        AfficageScroll.getViewport().setOpaque(false);
        AfficageScroll.getViewport().validate();
        AfficageScroll.setPreferredSize(new Dimension(750, (int) AfficageScroll.getPreferredSize().getHeight()));
        displayPanel.add(AfficageScroll, BorderLayout.CENTER);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScroll, displayPanel);
        splitPane.setOpaque(false);
        add(splitPane, BorderLayout.CENTER);
        validate();
        // ----------------------------------------------------------------


        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent arg0) {
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
            }

            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                    retButton.doClick();
                else if ((event.getKeyCode() == KeyEvent.VK_N) && ((event.getModifiers() & KeyEvent.CTRL_MASK) != 0))
                    addFolderButton.doClick();
                else if ((event.getKeyCode() == KeyEvent.VK_R) && ((event.getModifiers() & KeyEvent.CTRL_MASK) != 0))
                    renameFileButton.doClick();
                else if ((event.getKeyCode() == KeyEvent.VK_M) && ((event.getModifiers() & KeyEvent.CTRL_MASK) != 0))
                    renameFileButton.doClick();
                else if ((event.getKeyCode() == KeyEvent.VK_K) && ((event.getModifiers() & KeyEvent.CTRL_MASK) != 0))
					saveFileButton.doClick();
            }
        });


        frame.validate();
        frame.setVisible(true);


    }


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // "Paint Component" --> shows how things are going to be look like on the Frame.
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);// clear and repaint
		g.drawImage(getImg("img/bg.jpg"), 0, 0, getWidth(), getHeight(), this);
		g.drawImage(getImg("img/background7.jpeg"), 0, 0, getWidth(), getHeight(), this);
		g.drawImage(getImg("img/download.jpg"), (int) treeScroll.getWidth(), 0,
				(int) getWidth() - treeScroll.getWidth(), getHeight(), this);
	}
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // "Open File" --> This is one of the most important methods.
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    public void OpenFile(File file) {
		if (file.exists()) {
			showPanel.removeAll();
			showPanel.setLayout(new FlowLayout(0));

			if (!file.isDirectory()) {

				footerInfoLabel.setText(" File size : " + file.length() + " bytes");
				footerInfoLabel.setIcon(fileSystemView.getSystemIcon(file));
				String fileType = "Undetermined";

				try {
					fileType = Files.probeContentType(file.toPath());
				} 
				
				catch (IOException ioException) {
					fileType = "Undetermined";
					System.out.println("!! ERROR: " + ioException);
				}

				
				if (fileType == null)
					fileType = "Undetermined";

                // ----------------------------------------------------------------
                // ----------------------------------------------------------------
				// This is for Opening the ".txt" files "text/plain"
				// ----------------------------------------------------------------
                // ----------------------------------------------------------------
				if (fileType.toString().equals("text/plain")) {   
                // || if (fileType.toString().equals("application/pdf")){

					if (fileType.toString().equals("text/plain"))
						textArea = new JTextArea(readFile(file.toString()));
					else
						textArea = new JTextArea(readPdf(currentFolder));

					// ----------------------------------------------------------------
                    // ----------------------------------------------------------------
					// This is for the Color and Background and Font of the ".txt" files
					// ----------------------------------------------------------------
                    // ----------------------------------------------------------------
					textArea.setBackground(Color.white);
					textArea.setForeground(Color.black);
					textArea.setFont(new Font("Tahoma", Font.BOLD, 20));
                    // ---------------------------------------------------------------
                    // ---------------------------------------------------------------

					showScrollPane = new JScrollPane();
					showScrollPane.getViewport().add(textArea, BorderLayout.CENTER);
					showScrollPane.setPreferredSize(showPanel.getSize());
					showScrollPane.validate();
					showPanel.add(showScrollPane, BorderLayout.CENTER);
					showPanel.validate();
				} 
                // ----------------------------------------------------------------
                // ----------------------------------------------------------------
				// This is for Opening the "Images" files "image/jpeg", "png, jpg, gif"...etc
				// ----------------------------------------------------------------
                // ----------------------------------------------------------------
                else {
					Image img;
					if (fileType.toString().equals("image/jpeg") || fileType.toString().equals("image/png")
							|| fileType.toString().equals("image/jpg") || fileType.equals("image/gif")) {

						img = new ImageIcon(file.toString()).getImage();

					} else {
						img = getImg("img/unsupported2.png");
						if (Desktop.isDesktopSupported()) {
							try {
								Desktop.getDesktop().open(file);
							} catch (IOException ex) {
								System.err.println("!! Error : " + ex);
							}
						}
					}
					img = img.getScaledInstance(showPanel.getWidth(), showPanel.getHeight(), Image.SCALE_SMOOTH);

					JLabel label = new JLabel(new ImageIcon(img));
					label.setPreferredSize(showPanel.getSize());
					showPanel.add(label, BorderLayout.CENTER);
				}

			} // End of the "if (!file.isDirectory())"
            // which means here if the "file is not a directory"            
            // Then: 
            else {
				showPanel.setLayout(new GridLayout(0, 6, 10, 10));
				File[] files = file.listFiles();
				if (files != null) {
					footerInfoLabel.setText(" " + files.length + " element(s)");
                    // Set and Icon for the Scroll Panel of Tree.
					footerInfoLabel.setIcon(fileSystemView.getSystemIcon(file));
					for (File f : files) {
						remplirShowPane(f, 1);
					}
				}
			}
			revalidate();
			repaint();
		}
	}

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // This is for "Show Pane" Left Panel --> the Tree Panel for Files and Folders
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
	private void remplirShowPane(File f, int chois) {
		JButton fileButton = new JButton();
		try {
			ImageIcon imgIcon = (ImageIcon) fileSystemView.getSystemIcon(f);
			Image img = imgIcon.getImage();
			img = img.getScaledInstance(25, 35, Image.SCALE_SMOOTH);
			fileButton.setIcon(new ImageIcon(img));
			fileButton.setText(fileSystemView.getSystemDisplayName(f));
			fileButton.setHorizontalTextPosition(SwingConstants.CENTER);
			fileButton.setVerticalTextPosition(JButton.BOTTOM);
			fileButton.setToolTipText(f.getPath());
			if (chois == 0)
				fileButton.setPreferredSize(new Dimension(140, 150));
			else
				fileButton.setPreferredSize(new Dimension(100, 120));
            
            // This is for Color and Background and Size of the Panel and Files
			fileButton.setSize(fileButton.getPreferredSize());
			fileButton.setBackground(new Color(0, 0, 0, 0));
			fileButton.setForeground(Color.white);
			fileButton.setOpaque(false);
			fileButton.addMouseListener(new Mouse(fileButton.getToolTipText()));
			showPanel.add(fileButton);
		} catch (Exception e) {
			System.out.println("!! Error : " + e);
		}
	}
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // "Read File" Method --> This is an important Method
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
	private String readFile(String file) {
		
		String lines = "";
		String line;

		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			while ((line = reader.readLine()) != null)
				lines += line + "\n";
			reader.close();
		} catch (Exception e) {
			lines = "An error occurred while reading the stream : " + e.getMessage();
		}
		return lines;
	}


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // "Write File" Method --> This is an important Method
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
	private void writeFile(Path pt, String content) {
		try (BufferedWriter bw = Files.newBufferedWriter(pt, Charset.forName("UTF-8"), StandardOpenOption.CREATE)) {
			bw.write(content);
		} catch (Exception e) {
			System.out.println("!! Error in function writeFile(Path pt, String content) :\n=>  " + e.getMessage());
		}
	}

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    //  "Read PDF" Method
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
	private String readPdf(String pdfFile) {

		return "";
	}

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // Creating Children 
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    @SuppressWarnings({ "deprecation" })
	private void createChildren(DefaultMutableTreeNode node) {
		File fileRoot = new File(node.getUserObject().toString());
		File[] files = fileRoot.listFiles();
		if (files != null) {
			for (File file : files) {
				DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file);
				node.add(childNode);
				if (file.isDirectory())
					childNode.add(new DefaultMutableTreeNode(new Boolean(true)));
			}
		} else
			node.add(new DefaultMutableTreeNode(new Boolean(true)));
	}  
    // ----------------------------------------------------------------


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    //  "Get Image" Methods
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    public Image getImg(String sh) {
        try {
            return new ImageIcon("src\\"+sh).getImage();
        } catch (Exception e) {
            System.out.println("!! Error : image {\"" + sh + "\"} not found :: " + e.getMessage());
        }
        return null;
    }

    public ImageIcon getImg(String sh, int width, int height) {
        try {
            Image img = getImg(sh);
            img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } catch (Exception e) {
            System.out.println("!! Error : image {\"" + sh + "\"} not found :: " + e.getMessage());
            return null;
        }
    }
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------

    // Show Message Dialog
    private void showMessageDialog(String sh) {
		JOptionPane.showMessageDialog(this, sh, "Not Enabled", JOptionPane.ERROR_MESSAGE);
	}
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------


    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // Mouse Adapter -> Following the Behavior of the Mouse
    // Clicking, Pressing, Moving ...
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
	public class Mouse extends MouseAdapter {
		private String sh;

		public Mouse(String sh) {
			this.sh = sh;
		}

		public Mouse() {
			super();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger())
				doPop(e);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger())
				doPop(e);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() != tree) {
				if (e.getClickCount() == 1) {
					selectedFolder = sh;
				} else {
					currentFolder = sh;
					OpenFile(new File(currentFolder));
					treeTextField.setText(currentFolder);
					selectedFolder = null;
				}
			}
		}

        // ----------------------------------------------------------------
        // The Pop Up
        // ----------------------------------------------------------------
		private void doPop(MouseEvent e) {
			PopUpDemo menu = new PopUpDemo(e);
			menu.show(e.getComponent(), e.getX(), e.getY());
		}

        // ----------------------------------------------------------------
        // This is important, when you click on the Right mouse 
        // --> then this what shows to you
        // ----------------------------------------------------------------
		class PopUpDemo extends JPopupMenu {
			private static final long serialVersionUID = 1L;

            // Declarations for these Buttons:
			JMenuItem rename, addFolder, addFile, openInDesktop;

			public PopUpDemo(MouseEvent e) {

                // ----------------------------------------------------------------
                // When Clicking on the "Rename {K}" button
                // ----------------------------------------------------------------
				rename = new JMenuItem("-> Rename {K}");
				rename.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						renameFileButton.doClick();
					}
				});

                // ----------------------------------------------------------------
                // When Clicking on the "new Folder {K}" button
                // ----------------------------------------------------------------
				addFolder = new JMenuItem("-> new Folder {K} ");
				addFolder.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						addFolderButton.doClick();
					}
				});

                // ----------------------------------------------------------------
                // When Clicking on the "new File {K}" button
                // ----------------------------------------------------------------
				addFile = new JMenuItem("-> new File {K} ");
				addFile.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						addFileButton.doClick();
					}
				});

                // ----------------------------------------------------------------
                // When Clicking on the "Open in Desktop {K}" button
                // ----------------------------------------------------------------
				openInDesktop = new JMenuItem("-> Open in Desktop {K} ");
				openInDesktop.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String sh = "";
						if (selectedFolder == null || selectedFolder.equals(""))
							sh = currentFolder;
						else
							sh = selectedFolder;
						if (sh != null && !sh.equals("")) {
							File file = new File(sh);
							if (Desktop.isDesktopSupported()) {
								try {
									Desktop.getDesktop().open(file);
								} catch (IOException ex) {
									System.err.println("!! Error : " + ex);
								}
							}
						} else
							showMessageDialog("You chose select File");
					}
				});
                // ----------------------------------------------------------------

                // ----------------------------------------------------------------
                // Adding these "Buttons" to the "Pop Up Menu"
                // ----------------------------------------------------------------
				add(rename);
				add(addFolder);
				add(addFile);
				add(openInDesktop);


			}
		}
	}

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------


    
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
	// A Tree Cell Renderer for a File. 
    // This is for showing the Tree Folders on show Panel.
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
	class FileTreeCellRenderer extends DefaultTreeCellRenderer {
		private static final long serialVersionUID = 1L;

		private JLabel label;

		FileTreeCellRenderer() {
			label = new JLabel();
		}

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
				boolean leaf, int row, boolean hasFocus) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			File file = new File(node.getUserObject().toString());
			label.setIcon(fileSystemView.getSystemIcon(file));
			label.setText(fileSystemView.getSystemDisplayName(file));
			label.setToolTipText(file.getPath());
			label.setOpaque(false);
			return label;
		}
	}
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------





    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    
	@Override
	public void componentHidden(ComponentEvent arg0) {

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {

	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		width = getWidth();
		height = getHeight();
		revalidate();
		repaint();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {

	}


    
// 	public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
// 		new FileBrowser();
// //		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())

// 	}
	public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    new FileBrowser();
}



}
