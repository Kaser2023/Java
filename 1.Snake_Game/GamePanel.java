package Snake_Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel  extends JPanel implements ActionListener{
	
	static final int Screen_Width = 600; // ok
	static final int Screen_Height = 600; // ok
	static final int Unit_Size = 25; // ok 
	static final int Game_Unit = (Screen_Width * Screen_Height) / Unit_Size; // ok => 144
	static final int Delay = 75; // ok
	static final int x [] = new int [Game_Unit]; // = 144 -> ok
	static final int y [] = new int [Game_Unit]; // = 144 -> ok
	int bodyParts = 6; // ok
	int applesEaten = 0 ; // ok => 0
	int appleX; // ok => 0
	int appleY; // ok => 0
	char direction = 'R'; // ok -> by Default the direction is => Right!
	boolean running = false; // ok -> by Default the direction is => false
	Timer timer; // ok
	Random random; // ok
	String replay = "no";
	

	GamePanel(){
		random = new Random(); // -> ok
		this.setPreferredSize(new Dimension(Screen_Width, Screen_Height)); // ok -> The window Size 
		this.setBackground(Color.black); //  BG -> ok
		this.setFocusable(true); // the Focusavle -> Ok
		this.addKeyListener(new MyKeyAdapter()); // mmm -> I think the problem is here ! ! ! !
		startGame();   // Method of => Starting the Game! -> Ok
		
	}
	
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(Delay, this);
		timer.start();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		
	}
	
	public void draw(Graphics g) {
		
		if(running) {
			
			
			//Draw the lines
			for(int i = 0; i <Screen_Width/Unit_Size; i++ ) {
				
				g.drawLine(i*Unit_Size, 0, i*Unit_Size, Screen_Height);
				g.drawLine(0, i*Unit_Size, Screen_Width, i*Unit_Size);
	
			}
			
			
			
			// The Apple's Color
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, Unit_Size, Unit_Size);
			
			
			//Set the Colors of the Snake
			for(int i = 0; i< bodyParts; i++) {
				
				// This color for the Head of the Snake
				if(i == 0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], Unit_Size, Unit_Size);
				}
				
				// This color for the Body of the Snake
				else{
					g.setColor(new Color(24, 150,0));
					//g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
					g.fillRect(x[i], y[i], Unit_Size, Unit_Size);
				}
			}
			
			
			 // This line I put it here and it runs okay with no Problem
			 // But with his code he added it in the GameOver()  Method!
			//Score Screen
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free", Font.BOLD, 40));
			FontMetrics metrics1 = getFontMetrics(g.getFont());
			g.drawString(("Score: " + applesEaten), (Screen_Width - metrics1.stringWidth("Score: " + applesEaten)) / 2 , g.getFont().getSize() );
//			
			 
		}
		
		else {
			
			gameOver(g);
		
		}
		
	}
	
	
//	public void newApple() {
//		appleX = random.nextInt((int)(Screen_Width/Unit_Size) * Unit_Size); // here is problem
//		appleY = random.nextInt((int)(Screen_Height/Unit_Size) * Unit_Size); // here is problem
//
//	}
	public void newApple() {
	    appleX = random.nextInt((int)(Screen_Width/Unit_Size)) * Unit_Size;
	    appleY = random.nextInt((int)(Screen_Height/Unit_Size)) * Unit_Size;
	}

	public void move() {
		
		for(int i = bodyParts ; i > 0 ; i-- ) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
			
			case 'U': y[0] = y[0] - Unit_Size;
			break;
			case 'D': y[0] = y[0] + Unit_Size;
			break;
			case 'L': x[0] = x[0] - Unit_Size;
			break;
			case 'R': x[0] = x[0] + Unit_Size;
			break;
		
		}
//		
		
	}
	
	public void checkApple() {
		
		
		if((x[0] == appleX && y[0] == appleY) && running) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
		
	}
	public void checkCollisions() {
		
		//check if head collides with body
		for(int i = bodyParts; i > 0; i--) { 
			if((x[0] == x[i] && y[0] == y[i])) {
				running = false;
			}
		}
		
		//check if head touches LEFT border
		if(x[0] < 0) {
			running = false;
		}
		//check if head touches RIGHT border
		 if(x[0] > Screen_Width) {
			running = false;
		}
		//check if head touches TOP border
		 if(y[0] < 0) {
			running = false;
		}
		//check if head touches BOTTOM border
		 if(y[0] > Screen_Height) {
			running = false;
		}
		
		if(!running) {
			timer.stop();
		}
					
				
		
		
	}
	
	public void gameOver(Graphics g) {
		
		char endGame = 0;
		
		
		//Score Screen
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString(("Score: " + applesEaten), (Screen_Width - metrics1.stringWidth("Score: " + applesEaten)) / 2 , g.getFont().getSize() );
//		
//		
		//Game Over Text
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over!", (Screen_Width - metrics2.stringWidth("Game Over !")) / 2 ,Screen_Height / 2);
		
		//reset the Game
		running = false;
		bodyParts = 6;
		applesEaten = 0;
		startGame();
		
		
		g.setColor(Color.blue);
		g.setFont(new Font("Ink Free", Font.BOLD, 20));
		FontMetrics metrics3 = getFontMetrics(g.getFont());
		g.drawString("Do You Want to Play again?", (Screen_Width - metrics3.stringWidth("Do You Want to Play again?")) / 2 ,Screen_Height/4 );
			
		
		
		
		//Do-while loop to keep the game running until the user says no
//		do {
//		String input = JOptionPane.showInputDialog("Play again? (yes/no)");
//		if (input.equals("no")) {
//		break; // This statement is now outside of the loop
//		} else if (input.equals("yes")) {
//		startGame();
//		} else {
//		JOptionPane.showMessageDialog(null, "Invalid input. Please enter yes or no.");
//		}
//		} while (true);
		
		
		//Do-while loop to keep the game running until the user says no
//		do {
//		String input = JOptionPane.showInputDialog("Play again? (yes/no)");
//		if (input.equals("no")) {
//		break;
//			}
//		else if (input.equals("yes")) {
//		startGame();
//			}
//		else {
//		JOptionPane.showMessageDialog(null, "Invalid input. Please enter yes or no.");
//			}
//		
//		}while (true);
//		
		
		//Loop until the user says no
//		boolean playAgain = true;
//		while (playAgain) {
//		String input = JOptionPane.showInputDialog("Play again? (yes/no)");
//		if (input.equals("no")) {
//		playAgain = false;
//		} else if (input.equals("YES")) {
//			
////		startGame();
//		playAgain = true;
//		startGame();
//		
//		} else {
//		JOptionPane.showMessageDialog(null, "Invalid input. Please enter yes or no.");
//		}
//		
//		}
		
//		System.out.println("Do you want to Play again? Y/N");

		//Loop until the user says no
//		while (true) {
//			String playAgain = JOptionPane.showInputDialog("Play again? (yes/no)");
//			if (playAgain.equals("no")) {
//				break;
//			} else if (playAgain.equals("yes")) {
//				startGame();
//				break;
//			} else {
//				JOptionPane.showMessageDialog(null, "Invalid input. Please enter yes or no.");
//			}
//		}
//		
	
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (running){
			move();
			checkApple();
			checkCollisions();
		}
		
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			switch(e.getKeyCode()) {
			

			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
				}
					break;
				
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
				}
					break;
					
				
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
				}
					break;
				
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
				}
					break;
					
			case KeyEvent.VK_0:
				if(replay != "no") {
					replay = "yes";
					GamePanel m = new GamePanel();
					m.startGame();
//					
//				}
			}
				break;
//			
		}
		 
	}
	
	
	}
}
