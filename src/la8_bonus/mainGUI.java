/*
 * March 4, 2018
 * Julian Perge
 * CIT-142-A Lab 8 Bonus
 * RockPaperScissors - Event Handling
 * Modified version for the inclusion of Lizard and Spock
 */

package la8_bonus;

import java.awt.*;
import javax.swing.*;

public class mainGUI extends JFrame
{ private static final long serialVersionUID = 1L;

// Step 1 - instantiate the new game class
private CompAndWinnerSelection compSelection = new CompAndWinnerSelection(this);

// Step 4 - ImageIcons for displaying in labels

public ImageIcon rockIco; // pngs are 40x40 pixels
public ImageIcon paperIco;
public ImageIcon scissorsIco;
public ImageIcon lizardIco;
public ImageIcon spockIco;

public ImageIcon icoSet[] = new ImageIcon[]
		{
				rockIco = new ImageIcon("rockN.png"),
				paperIco = new ImageIcon("paperN.png"),
				scissorsIco = new ImageIcon("scissorsN.png"),
				lizardIco = new ImageIcon("lizardN.png"),
				spockIco = new ImageIcon("spockN.png")
		};

// row 1
private JPanel row1 = new JPanel();
private JLabel row1Msg = new JLabel("Welcome to Rock-Paper-Scissors. Click on a button below to make your selection");

// row 2, buttons and images
private JPanel row2 = new JPanel();
private JButton btnRock = new JButton("Rock");
private JButton btnPaper = new JButton("Paper");
private JButton btnScissors = new JButton("Scissors");
private JButton btnLizard = new JButton("Lizard");
private JButton btnSpock = new JButton("Spock");

// row 3, text
private JPanel row3 = new JPanel();
private JLabel row3UserMsg = new JLabel("Your Choice ");
private JLabel row3CompMsg = new JLabel(" Comp Choice");

// row 4
private JPanel row4 = new JPanel();
public JLabel userAction = new JLabel();
public JLabel computerAction = new JLabel();

// row 5
public JPanel row5 = new JPanel();
public JLabel row5WinnerMsg = new JLabel();

	public mainGUI()
	{
		super("Rock-Paper-Scissors-Lizard-Spock");
		setSize(680, 270);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// needed for proper overall layout for each individual layout
		GridLayout layout = new GridLayout(5, 2, 5, 2);
		setLayout(layout);
		
		// add buttons and set icons
		ButtonGroup RPS = new ButtonGroup();
		RPS.add(btnRock);
		RPS.add(btnPaper);
		RPS.add(btnScissors);
		
		// set image icons
		btnRock.setIcon(rockIco);
		btnPaper.setIcon(paperIco);
		btnScissors.setIcon(scissorsIco);
		btnLizard.setIcon(lizardIco);
		btnSpock.setIcon(spockIco);
		
		// Step 2 - ActionListeners for the 3 buttons
		btnRock.addActionListener(compSelection);
		btnPaper.addActionListener(compSelection);
		btnScissors.addActionListener(compSelection);
		btnLizard.addActionListener(compSelection);
		btnSpock.addActionListener(compSelection);
		
		//row1
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 5, 15);
		row1.setLayout(layout1);
		row1.add(row1Msg);
		add(row1);
		
		// row2
		GridLayout grid = new GridLayout(1, 2, 0, 2);
		row2.setLayout(grid);
		row2.add(btnRock);
		row2.add(btnPaper);
		row2.add(btnScissors);
		row2.add(btnLizard);
		row2.add(btnSpock);
		add(row2);
		
		// row3
		FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER, 25, 25);
		row3.setLayout(layout3);
		row3.add(row3UserMsg);
		row3.add(row3CompMsg);
		add(row3);

		// row4
		FlowLayout layout4 = new FlowLayout(FlowLayout.CENTER, 50, 0);
		row4.setLayout(layout4);
		row4.add(userAction).setVisible(false);
		row4.add(computerAction).setVisible(false);
		add(row4);
		
		// row5
		FlowLayout layout5 = new FlowLayout(FlowLayout.CENTER, 0, 10);
		row5.setLayout(layout5);
		row5.add(row5WinnerMsg);
		add(row5);
	}

	public static void main(String[] args) 
	{
		mainGUI displayFrame = new mainGUI();
	}
}
