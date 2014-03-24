package gameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel{
	JPanel topPanel, middlePanel, bottomPanel, leftPanel, rightPanel;
    Game game;
    JLabel prompt;
    JButton[] jbGridSquare;
    JLabel[] jlGridUp, jlGridLeft;
    int numShips, gridSize;
    int[] buttonsPressed, coordinates;
    int[] xCoordinate, yCoordinate;
    int[] multiplicationResults;
          
    public void setCoordinates(int[] coordinates) {
		this.coordinates = coordinates;
	}

    public int getNumShips() {
		return numShips;
	}
    
	public GamePanel(Game container, int numShips, int gridSize) {
        this.game = container;
        this.setLayout(new BorderLayout());
        this.numShips = numShips;
        this.gridSize = gridSize;
        
//     	Upper coordinates
        topPanel = new JPanel(new GridLayout(1, gridSize));
        add("North", topPanel);
        jlGridUp = new JLabel[(gridSize)];
        xCoordinate = new int[gridSize];
        for (int x = 0; x < (gridSize); x++)
        {
//        	jlGridUp[x] = new JLabel(Integer.toString(x));
        	int value = (int) Math.round((Math.random()*9));
        	jlGridUp[x] = new JLabel(Integer.toString(value));
            topPanel.add(jlGridUp[x]);
            
            xCoordinate[x] = value;
        }
        
//     	Left coordinates
        leftPanel = new JPanel(new GridLayout(gridSize, 1));
        add("West", leftPanel);
        jlGridLeft = new JLabel[(gridSize)];
        yCoordinate = new int[gridSize];
        for (int x = 0; x < (gridSize); x++)
        {
//        	jlGridLeft[x] = new JLabel(Integer.toString(x));
        	int value = (int) Math.round((Math.random()*9));
        	jlGridLeft[x] = new JLabel(Integer.toString(value));
            leftPanel.add(jlGridLeft[x]);
            
            yCoordinate[x] = value;
        }
        
//      Store array of multiplication results from coordinates
        multiplicationResults = new int[gridSize*gridSize];
        int resultsCounter = 0;
    	for (int j = 0; j < gridSize; j++) {
			for (int k = 0; k < gridSize; k++) {
				System.out.println(xCoordinate[j]);
	        	System.out.println(yCoordinate[k]);
				multiplicationResults[resultsCounter] = xCoordinate[k]*yCoordinate[j];
				resultsCounter++;
			}
		}
		
//        Debugging
        for (int i = 0; i < multiplicationResults.length; i++) {
        	
        	System.out.println("multiplicationResults:" + multiplicationResults[i]);
		}
        

//      Attack buttons
        middlePanel = new JPanel(new GridLayout(gridSize, gridSize));
        add("Center", middlePanel);
        jbGridSquare = new JButton[(gridSize*gridSize)];
//      Used to track what buttons have been pressed on the grid with 0s and 1s
        buttonsPressed = new int[gridSize*gridSize];
    	int[] buttonCoordinates = new int[2];
		for (int x = 0; x < (gridSize*gridSize); x++)
        {
        	
        	jbGridSquare[x] = new JButton(Integer.toString(x));
            middlePanel.add(jbGridSquare[x]);
            final int buttonMultiplication = multiplicationResults[x];
            jbGridSquare[x].addActionListener(new ActionListener(){ 	
				public void actionPerformed(ActionEvent e) {
						boolean hit = false;
						int btnPressed = Integer.parseInt((e.getActionCommand())); 
//						System.out.println("Action command: " + e.getActionCommand());

//						System.out.println("Coordinates: " + coordinates[0]);
						for (int i = 0; i < coordinates.length; i++) {
							System.out.println("btnPressed: " + btnPressed);
							System.out.println("coordinates[i]: " + coordinates[i]);
							if(btnPressed == coordinates[i]){
								hit = true;
							}
						}
						
						JButton source;
//						Cast getSource so we can work with it and change background color in ifElse
						source = (JButton) e.getSource();
						if(hit){
							source.setBackground(Color.red);
						}else{
							source.setBackground(Color.blue);
						}
					
				}}); 			
            
		}
        
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        add("South", bottomPanel);
        rightPanel = new JPanel();
        add("East", rightPanel);
        
        
	}		 
	}