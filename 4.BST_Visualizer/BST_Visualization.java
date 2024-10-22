
package BST_Visualizer_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;


//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//

public class BST_Visualization extends JFrame  implements ActionListener, KeyListener {

    private Node root;
    private JPanel topPanel, treePanel, infoPanel;
    private JPanel topLeftPanel, topRightPanel;
    private JButton btnAdd, btnDelete;
    private JTextField tf;
    private int X = 300, Y = 75;
    private Graphics2D g2;
    private Rectangle size;
    private JLabel labelInorder, labelPreorder, labelPostorder, labelHeight;
    private JLabel ansInorder, ansPreorder, ansPostorder, ansHeight;
    private FontMetrics fontMatrix;


    // Node Structure

    // --------------------------------
    // Understood all the lines! الحمدلله
    // Except this line:   what is "setOpaque"  (( data.setOpaque(true); ))
    // --------------------------------
    private static class Node {
        static int TEXT_WIDTH = 40;
        static int TEXT_HEIGHT = 40;


        JLabel data;
        Node left;
        Node right;
        Points p;

        Node(int info) {
            data = new JLabel(info + "", SwingConstants.CENTER);
            data.setFont(new Font("Arial", Font.BOLD, 20));
            data.setBorder(BorderFactory.createLineBorder(Color.cyan));
            data.setOpaque(true);
            data.setBackground(Color.PINK);
            p = null;
        }
    }

    // Points structure

    // --------------------------------
    // Understood all the lines! الحمدلله
    // The Dicatnce Between the Nodes
    //How the Nodes are being Connected with the help of the Straight Line.
    // The Black Lines
    // --------------------------------
    private static class Points {
        int x1 = 0, x2 = 0, y2 = 0, y1 = 0;

        Points(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y2 = y2;
            this.y1 = y1;
        }
        public String toString() {
            return "x1 = " + x1 + ", y1 = " + y1 + ", x2 = " + x2 + ", y2 = " + y2;
        }
    }


    // For storing the Height of the root,left and right child height.

    // --------------------------------
    // Understood all the lines! الحمدلله
    // To Calculate the Height of the BS-Tree
    // --------------------------------
    private static class Height {
        int root, left, right;

        Height() {
            this.root = 0;
            this.left = 0;
            this.right = 0;
        }

        Height(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return Integer.toString(this.root);
        }
    }


    // For Printing the Lines between the Nodes Graphically
    public void paint(Graphics g) {
        super.paintComponents(g);

        g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3.0f));

        Stack<Node> s = new Stack<>();
        Node curr = root;
        Points pts;
        int offset = topPanel.getBounds().height;
        while (!s.isEmpty() || curr != null) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            if (!s.isEmpty())
                curr = s.pop();
            pts = curr.p;
            g2.drawLine(pts.x1 + 7, pts.y1 + 30 + offset, pts.x2 + 3, pts.y2 + 10 + offset);
            curr = curr.right;
        }
    }



    public BST_Visualization() {
        // Initialize the frame.
        initialize();
    }

    private void initialize() {
        setSize(1300, 700); // frame size

        size = getBounds();
        X = size.width / 2;

        // The title Show
        topPanel = new JPanel(new BorderLayout());
        Rectangle top = topPanel.getBounds();

        // Height Show
        topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topPanel.add(topLeftPanel, BorderLayout.WEST);

        // Add/Delete buttons Show
        topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(topRightPanel, BorderLayout.EAST);

        // Tree Show
        treePanel = new JPanel(null);
        treePanel.setPreferredSize(new Dimension(size.width, size.height - 300));

        // Traversal Show
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setPreferredSize(new Dimension(size.width, 200));

//        ----------------------------------------------------------------
//        Till Here Understood - 6:52-PM
//        ----------------------------------------------------------------

        // Height of BST label
        labelHeight = new JLabel("BST Height : ");
        labelHeight.setFont(new Font("Calibri", Font.BOLD, 20));
        topLeftPanel.add(labelHeight);

        // Height of BST answer
        ansHeight = new JLabel("0");
        ansHeight.setFont(new Font("Calibri", Font.BOLD, 20));
        ansHeight.setPreferredSize(new Dimension(50, 30));
        topLeftPanel.add(ansHeight);


//        ----------------------------------------------------------------
//        Till Here Understood - 6:59-PM

//        But I have a question: how we set "ansHeight" = "0" and where we use it?
//        When it will be changed?
//        I tried to change its value to 5 and 1 then there in no change!
//        It may be in the next lines! IDK
//        ----------------------------------------------------------------

//        ----------------------------------------------------------------
//        Above for Preference the Show
//        Here is for Setting the Data
//        ----------------------------------------------------------------

//        The Add text Field
        // For geting data.
        tf = new JTextField("");
        tf.setFont(new Font("Arial", Font.BOLD, 20));
        tf.setPreferredSize(new Dimension(150, 30));
        tf.addKeyListener(this);
        topRightPanel.add(tf);


//        Add/Delete Buttons

        // Add Button
        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Arial", Font.BOLD, 20));
        btnAdd.addActionListener(this);
        topRightPanel.add(btnAdd);

        // Delete Button
        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
        btnDelete.addActionListener(this);
        topRightPanel.add(btnDelete);


//        $$$ In-Order Label and Answer$$$

        // Inorder label
        labelInorder = new JLabel("Inorder :");
        labelInorder.setFont(new Font("Times New Roman", Font.BOLD, 20));
        infoPanel.add(labelInorder);
        infoPanel.add(Box.createRigidArea(new Dimension(7, 5)));

        // Inorder traversal answer
        ansInorder = new JLabel("BST is empty.");
        ansInorder.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(ansInorder);

        infoPanel.add(Box.createRigidArea(new Dimension(7, 15)));

        //    $$$ Pre-Order Label and Answer$$$

        // Preorder label
        labelPreorder = new JLabel("Preorder :");
        labelPreorder.setFont(new Font("Times New Roman", Font.BOLD, 20));
        infoPanel.add(labelPreorder);

        infoPanel.add(Box.createRigidArea(new Dimension(7, 5)));


        // Preorder traversal answer
        ansPreorder = new JLabel("BST is empty.");
        ansPreorder.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(ansPreorder);

        infoPanel.add(Box.createRigidArea(new Dimension(7, 15)));

        //   $$$ Post-Order Label and Answer$$$

        // Postorder label
        labelPostorder = new JLabel("Postorder :");
        labelPostorder.setFont(new Font("Times New Roman", Font.BOLD, 20));
        infoPanel.add(labelPostorder);

        // Postorder traversal answer
        ansPostorder = new JLabel("BST is empty.");
        ansPostorder.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(ansPostorder);

        // Understood 60%
        tf.requestFocusInWindow();

//        Put the Panels on Their Positions
        add(topPanel, BorderLayout.NORTH);
        add(treePanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);

        setTitle("Binary Search Tree Visualization"); // Title Frame
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//		----------------------------------------------------------------
//		----------------------------------------------------------------
//		Done! Till 8:00-PM
//		----------------------------------------------------------------
//		----------------------------------------------------------------


//    ----------------------------------------------------------------
//    ----------------------------------------------------------------
//    -------------------- The Action Listener    --------------------
//    for  Checking User's Input and whether it is by pressing the Buttons
//    or with the Text Field - How the Application is going to handle the Inputs
//    ----------------------------------------------------------------
//    ----------------------------------------------------------------


    @Override
    public void actionPerformed(ActionEvent evt) {
        if (tf.isEnabled()) {
            try {
                int data = Integer.parseInt(tf.getText());
                if (evt.getSource() == btnAdd) {
                    add(data);
                } else {
                    delete(data);
                }
                tf.setText("");
                tf.requestFocusInWindow();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please Enter Integer.");
            }
        }
    }


    //----------------------------------------------------------------
    //------ This method is for "Preventing Write Non-Integer! -------
    //----------------------------------------------------------------

    @Override
    public void keyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!tf.isEnabled()) {
            return;
        } else if (c == 'a' || c == 'A' || c == '\n') {
            try {
                String data = tf.getText();
                evt.consume(); // Not type 'a' or 'A' character in textfield
                if (!data.isEmpty()) {
                    // ----------------------------------------------------------------
                    // Try and Accept and [[ ADD ]] just Integers
                    //----------------------------------------------------------------
                    add(Integer.parseInt(data));
                } else {

                    throw new Exception();
                }
                tf.requestFocusInWindow();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please Enter Integer.");
            }
            tf.setText("");
        } else if (c == 'd' || c == 'D') {
            try {
                String data = tf.getText();
                evt.consume(); // Not type 'd' or 'D' character in textfield
                if (!data.isEmpty()) {
                    // ----------------------------------------------------------------
                    // Try and Accept and [[ DELETE ]] just Integers
                    //----------------------------------------------------------------
                    delete(Integer.parseInt(data));
                }
                tf.requestFocusInWindow();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please Enter Integer.");
            }
            tf.setText("");
        } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
            evt.consume();
        }
        // ----------------------------------------------------------------
        // This part of lines is Mine!
        // I've created them after reading from Ascii Table!
        // ----------------------------------------------------------------
        else if (c >= '!' && c <= '/' || c >= ':' && c <= '@' ){
            evt.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {
    }

    @Override
    public void keyReleased(KeyEvent evt) {
    }






//    ----------------------------------------------------------------
//    ----------------------------------------------------------------
//    ---------------------- Add Method   ----------------------------
//    ----------------------------------------------------------------
//    ----------------------------------------------------------------



    // Add element in BST.
    public void add(int info) {
        Node newNode = new Node(info);
        int width = getWidth(newNode);

        // If the Tree is Empty
        if (root == null) {
            root = newNode;
            newNode.data.setBounds(treePanel.getBounds().width / 2, 10, width, 40);
            newNode.p = new Points(0, 0, 0, 0);
        }

        else {

            Node curr = root, pre = root;
            int currData;
            X = treePanel.getBounds().width / 2;

            while (curr != null) {
                pre = curr;
                currData = Integer.parseInt(curr.data.getText());
                if (info == currData) {
                    JOptionPane.showMessageDialog(null, info + " .الرقم موجود يا محترم");
                    return;
                } else if (currData > info) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }

                //----------------------------------------------------------------
                // ---------------------- SO IMPORTANT !!!!!!! -------------------
                //  ------ This line is for the "Points" Black Lines!
                // ----------------------------------------------------------------
                X /= 2;

            }

            currData = Integer.parseInt(pre.data.getText());
            int x = pre.data.getX();
            int y = pre.data.getY();
            Dimension preDimension = pre.data.getSize();
            Dimension currDimension = new Dimension(width, Node.TEXT_HEIGHT);

            if (currData > info) {
                pre.left = newNode;
                newNode.data.setBounds(x - X, y + Y, width, 40);
                newNode.p = new Points(x, y + preDimension.height / 2, x - X + currDimension.width / 2,
                        y + Y + currDimension.height / 2);
            } else {
                pre.right = newNode;
                newNode.data.setBounds(x + X, y + Y, width, 40);
                newNode.p = new Points(x + preDimension.width, y + preDimension.height / 2,
                        x + X + currDimension.width / 2, y + Y + currDimension.height / 2);
            }
        }

        // Set all traversal and height of BST
        setInfo();

        // paint(treePanel.getGraphics());
        treePanel.add(newNode.data);
        treePanel.validate();
        treePanel.repaint();
        validate();
        repaint();
    }



//    ----------------------------------------------------------------
//    ----------------------------------------------------------------
//    ---------------------- Delete Method   -------------------------
//    ----------------------------------------------------------------
//    ----------------------------------------------------------------


    // Delete Node from BST
    public void delete(int data) {
        if (root == null) {
            JOptionPane.showMessageDialog(null, "BST is empty.");
        } else {
            Node curr = root, pre = root;

            while (curr != null) {
                int info = Integer.parseInt(curr.data.getText());
                if (info == data) {
                    break;
                } else if (info > data) {
                    pre = curr;
                    curr = curr.left;
                } else {
                    pre = curr;
                    curr = curr.right;
                }
            }

            if (curr == null) { // data is not find.
                JOptionPane.showMessageDialog(null, data + " is not available.");
                return;

                // ------------------
                // data has 0 or 1 child
                // ------------------
            } else if (curr.left == null || curr.right == null) {
                treePanel.remove(curr.data);
                treePanel.validate();
                treePanel.repaint();
                validate();
                repaint();

                if (curr != root) {
                    Node address = curr.left != null ? curr.left : curr.right;
                    // curr.data>pre.data
                    int preData = Integer.parseInt(pre.data.getText());
                    int currData = Integer.parseInt(curr.data.getText());
                    if (currData > preData) {
                        pre.right = address;
                    } else {
                        pre.left = address;
                    }
                } else {
                    if (curr.left != null) {
                        root = curr.left;
                    } else {
                        root = curr.right;
                    }
                }

            }
            // ------------------
            // data has 2 child.
            // ------------------
            else {

                treePanel.remove(curr.data);
                treePanel.validate();
                treePanel.repaint();

                validate();
                repaint();

                /*
                ----- Important ----
                ----------------------------------------------------------------
                 * It sets another node [[ depending ]] upon the height of left and right subTree.
                 ----------------------------------------------------------------
                 */
                Node nextRoot = null, preRoot = curr;
                Height height = calculateHeight(curr);

                //----------------------------------------------------------------
                /* For taking maximum element from the left Side. */
                //----------------------------------------------------------------

                if (height.left > height.right) {
                    nextRoot = curr.left;
                    while (nextRoot.right != null) {
                        preRoot = nextRoot;
                        nextRoot = nextRoot.right;
                    }

                    if (preRoot != curr) {
                        preRoot.right = nextRoot.left;
                    } else {
                        preRoot.left = nextRoot.left;
                    }
                }

                else {
                    //----------------------------------------------------------------
                    /* For taking minimum element from the right Side. */
                    //----------------------------------------------------------------

                    nextRoot = curr.right;
                    while (nextRoot.left != null) {
                        preRoot = nextRoot;
                        nextRoot = nextRoot.left;
                    }

                    if (preRoot != curr) {
                        preRoot.left = nextRoot.right;
                    } else {
                        preRoot.right = nextRoot.right;
                    }
                }

                curr.data = nextRoot.data;
            }
            reArrangeNode(root, root, treePanel.getBounds().width / 2);
        }

        // Set all traversal and height of BST
        setInfo();
    }


    //    ----------------------------------------------------------------
//    ----------------------------------------------------------------
//    ----------- Set all traversal and height of BST   --------------
//    ----------------------------------------------------------------
//    ----------------------------------------------------------------
    // Set all traversal and height of BST
    private void setInfo() {
        Height height = calculateHeight(root);

        if (height.root == 0) {
            ansInorder.setText("BST is empty.");
            ansPostorder.setText("BST is empty.");
            ansPreorder.setText("BST is empty.");
        } else {
            ansInorder.setText(inorder(root));
            ansPostorder.setText(postorder(root));
            ansPreorder.setText(preorder(root));
        }

        ansHeight.setText(height.root + "");
    }


//    ----------------------------------------------------------------
//    ----------------------------------------------------------------
//    ---------------------- Get Width   ----------------------------
//    ----------------------------------------------------------------
//    ----------------------------------------------------------------

    private int getWidth(Node node) {
        fontMatrix = getFontMetrics(node.data.getFont());
        int width = fontMatrix.stringWidth(node.data.getText());
        return width < Node.TEXT_WIDTH ? Node.TEXT_WIDTH : (width + 5);
    }


    //    ----------------------------------------------------------------
//    ----------------------------------------------------------------
//    ------------- Pre-In-Post Order Traversal   --------------------
//    ----------------------------------------------------------------
//    ----------------------------------------------------------------
    // Inorder logic
    private String inorder(Node root) {
        if (root == null)
            return "";

        return inorder(root.left) + root.data.getText() + " " + inorder(root.right);
    }

    // Preorder logic
    public String preorder(Node root) {
        if (root == null)
            return "";

        return root.data.getText() + " " + preorder(root.left) + preorder(root.right);
    }

    // Postorder logic
    public String postorder(Node root) {
        if (root == null)
            return "";

        return postorder(root.left) + postorder(root.right) + root.data.getText() + " ";
    }

//    ----------------------------------------------------------------
//    ----------------------------------------------------------------
//    ------ Calculate Height of BST using recursive method.   -------
//    ----------------------------------------------------------------
//    ----------------------------------------------------------------

    private Height calculateHeight(Node root) {
        if (root == null) {
            return new Height();
        }
        Height leftChild = calculateHeight(root.left);
        Height rightChild = calculateHeight(root.right);
        Height current = new Height(leftChild.root, rightChild.root);
        current.root = 1 + Math.max(leftChild.root, rightChild.root);
        return current;
    }


//    ----------------------------------------------------------------
//    ----------------------------------------------------------------
//    --------------------- Rearrange nodes   ------------------------
//    ----------------------------------------------------------------
//    ----------------------------------------------------------------

    private void reArrangeNode(Node node, Node pre, int X) {
        if (node == null)
            return;

        int width = getWidth(node);

        if (root == node) {
            node.data.setBounds(X, 10, width, Node.TEXT_HEIGHT);
        } else {
            int x = pre.data.getX();
            int y = pre.data.getY();
            Dimension preDimension = pre.data.getSize();
            Dimension currDimension = new Dimension(width, Node.TEXT_HEIGHT);

            int preData = Integer.parseInt(pre.data.getText());
            int nodeData = Integer.parseInt(node.data.getText());
            if (nodeData < preData) {
                node.data.setBounds(x - X, y + Y, width, Node.TEXT_HEIGHT);
                node.p = new Points(x, y + preDimension.height / 2, x - X + currDimension.width / 2,
                        y + Y + currDimension.height / 2);
            } else {
                node.data.setBounds(x + X, y + Y, width, Node.TEXT_HEIGHT);
                node.p = new Points(x + preDimension.width, y + preDimension.height / 2,
                        x + X + currDimension.width / 2, y + Y + currDimension.height / 2);
            }
        }
        reArrangeNode(node.left, node, X / 2);
        reArrangeNode(node.right, node, X / 2);
    }

    public static void main(String arg[]) {

        BST_Visualization bst = new BST_Visualization();

        bst.add(500);
        bst.add(250);
        bst.add(350);
        bst.add(200);
        bst.add(750);
        bst.add(1000);
        bst.add(700);
        bst.add(740);

    }
}


