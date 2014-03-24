package gameGUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GameUserInterface extends JFrame{
	Game game;
	GamePanel gamePanel;
	InitPanel initialSetup;
	
	CoordinatesPanel coordinatesPanel;
	
    JMenuBar mb;
    JMenu m;
    JMenuItem q, r, s, t;
    int numShips, gridSize;
    
//    InitPanel variables
    JLabel shipsLabel, gridLabel;
    JTextField shipsField, gridField;
    JButton jbInitSetup;
    
    int[] coordinates;
    
    JButton submit;
    
    public GameUserInterface(Game myGame) {
        game = myGame;
        game.setMyUserInterface(this);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 800));
        mb = new JMenuBar();
        setJMenuBar(mb);
        m = new JMenu("File");
        mb.add(m);
        m.add(q = new JMenuItem("Exit"));
//        Exit application when user clicks on "Exit"
        q.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
                 System.exit(0);
             }
        });
        
        JPanel southPanel = new JPanel(new GridLayout(1,2));
    
//      Add instructions
        initialSetup = new InitPanel();
        add("North", initialSetup);
        
        submit = new JButton("Play");
        add("East", submit);
        
        
        pack();
        setVisible(true);
    }
    
    public class InitPanel extends JPanel{
    	public InitPanel(){
    		shipsLabel = new JLabel("Enter the number of ships");
            add(shipsLabel);
            shipsField = new JTextField(5);
            add(shipsField);
            
            gridLabel = new JLabel("Enter grid dimensions (grid is a square)");
            add(gridLabel);
            gridField = new JTextField(5);
            add(gridField);
            
            jbInitSetup = new JButton("Enter");
            add(jbInitSetup);
            jbInitSetup.addActionListener(new InitSetupListener());
    	}
    }

	private class InitSetupListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(coordinatesPanel != null){
				remove(coordinatesPanel);
				game = new Game();
			}
//			//Add coordinates panel
	        numShips = Integer.parseInt(shipsField.getText());
	        gridSize = Integer.parseInt(gridField.getText());
	        coordinatesPanel = new CoordinatesPanel(numShips);
	        add("South", coordinatesPanel);
	        
	        if(gamePanel != null){
				remove(gamePanel);
				game = new Game();
			}
	      //Add game panel
			gamePanel = new GamePanel(game, numShips, gridSize);
	        add("Center", gamePanel);
	        
	        submit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					coordinatesPanel.setCoordinates();
					coordinates = coordinatesPanel.getCoordinates();
					System.out.println("Input coordinates" + coordinates);
					gamePanel.setCoordinates(coordinates);
					System.out.println(coordinates[3]);
				}
			});
	        
	        GameUserInterface.this.validate();
		}
	}
	
	
}