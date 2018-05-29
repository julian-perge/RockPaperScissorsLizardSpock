/*
 * March 4, 2018
 * Julian Perge
 * CIT-142-A Lab 8 Bonus
 * RockPaperScissors - Event Handling
 * Modified version for the inclusion of Lizard and Spock
 */

package la8_bonus;

import java.util.Random;
import java.awt.event.*;

public class CompAndWinnerSelection implements ActionListener
{
	// Object name for the GUI
	mainGUI gui;
	
	public CompAndWinnerSelection(mainGUI in) 
	{
		// Method for connecting GUI to object name of GUI
		gui = in;
	}

	// Listens for button press from user
	public void actionPerformed(ActionEvent event)
	{
		// String and boolean array for looping through later on
		String command = event.getActionCommand();
		boolean bCOMMAND[] = new boolean[]
				{
					command.equals("Rock"),
					command.equals("Paper"),
					command.equals("Scissors"), 
					command.equals("Lizard"), 
					command.equals("Spock")
				};

		// initialize and assign variables
		boolean bWinner = false;
		boolean bTieGame = false;
		int intUserChoice = 0;
		int intComputerAnswer = 0;
		
		// array to loop through whether or not the bCOMMAND boolean is true for the respective button press 
		for (int i = 0; i < bCOMMAND.length; i++)
		{	// if button press iteration is true
			if (bCOMMAND[i])
			{
				// set user selection to respective ImageIcon
				gui.userAction.setIcon(gui.icoSet[i]);
				// set user choice to current iteration
				intUserChoice = i;
				break;
			}
		}
		gui.userAction.setVisible(true);

		// Called method for finding the winner
		// passes along another method, intCompSelection, for then passing the computers answer along to WhoIsTheWinner method
		WhoIsTheWinner(intUserChoice, intCompSelection(intComputerAnswer), bWinner, bTieGame);
		gui.row5.setVisible(true);
	}

	// Created method for returning computer's answer 
	public int intCompSelection(int intComp)
	{
		Random rand = new Random();

		// Randomized computer choice from 0 to 4
		intComp = rand.nextInt(5);
		
		for (int i = 0; i < 5; i++)
		{
			// if computer answer is equal to iteration
			if (intComp == i)
			{
				// set computer label's icon respectively
				gui.computerAction.setIcon(gui.icoSet[i]);
				break;
			}
		}
		gui.computerAction.setVisible(true);

		// Calls method for comparing each parties selections,
		// and determining the winner
		return intComp;
	}
	// Method for comparing user's answer to computer's answer,
	// and determining the winner
	public void WhoIsTheWinner(int intUser, int intComp, boolean bWin, boolean bTie)
	{
			// if statements to determine if you've won
			// any other scenario you lose
			// 0 rock, 1 paper, 2 scissors, 3 lizard, 4 spock
		if (intUser == intComp)
		{
			bTie = true;
			bWin = false;
		}
		else if (intUser == 0)
		{
			if (intComp == 2 || intComp == 3)
				bWin = true;
		}
		else if (intUser == 1)
		{
			if (intComp == 0 || intComp == 4)
				bWin = true;
		}
		else if (intUser == 2)
		{
			if (intComp == 1 || intComp == 3)
				bWin = true;
		}
			
		else if (intUser == 3)
		{
			if (intComp == 1 || intComp == 4)
				bWin = true;	
		}
		else if (intUser == 4)
		{
			if (intComp == 0 || intComp == 2)
				bWin = true;
		}
		else
		{
			bTie = false;
			bWin = false;
		}
			
		if (bTie)
			gui.row5WinnerMsg.setText("It's a Tie!");
		else if (bWin)
			gui.row5WinnerMsg.setText("You Won!");
		else
			gui.row5WinnerMsg.setText("Computer Won!");
	}
}
