package gameGUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CoordinatesPanel extends JPanel{
	private int numShips;

	private int[] coordinates;
	public int[] getCoordinates() {
		return coordinates;
	}
	
	public void setCoordinates() {
		for (int i = 0; i < (numShips*3); i++) {
			coordinates[i] = Integer.parseInt(jtfShipCoordinates[i].getText());
			System.out.println("Coordinates in CoordinatesPanel: " + coordinates[i]);
		}
	}
	
	JPanel coordinatesPanel;
	JButton submit;
	JTextField[] jtfShipCoordinates;
	JLabel[] jlShipCoordinates;
	
	public CoordinatesPanel(int numShips){
		this.numShips = numShips;
		coordinates = new int[numShips*3];
//    Enter coordinates
//    	Each ship is made up of 3 squares, and we add an extra row for headers
	    coordinatesPanel = new JPanel(new GridLayout(numShips*3 + 1, 3));
		add("Center", coordinatesPanel);
		jtfShipCoordinates = new JTextField[numShips*3];
		jlShipCoordinates = new JLabel[numShips];
		
		int counter = 0;
		
	    for (int x = 0; x < (numShips); x++)
	    {
	    	jlShipCoordinates[x] = new JLabel("Enter coordinates for ship " + (x+1));
	    	coordinatesPanel.add(jlShipCoordinates[x]);
	    	for (int i = 0; i < 3; i++) {
	    		if(i>0){
	    			coordinatesPanel.add(new JPanel());
	    		}
	    		jtfShipCoordinates[counter] = new JTextField();
		    	coordinatesPanel.add(jtfShipCoordinates[counter]);
		    	counter++;
			}
	    }

	}
	
	
	

}
