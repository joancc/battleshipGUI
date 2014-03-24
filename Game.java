package gameGUI;

public class Game {
	private int numShips;
	private int[] coordinates;	//Hold coordinates per ship
	private int[] boardDimensions;
	GameUserInterface myUserInterface;

//	User interface to talk between View and Model
	public void setMyUserInterface(GameUserInterface myUserInterface) {
		this.myUserInterface = myUserInterface;
	}
	public int getNumShips() {
		return numShips;
	}
	public void setNumShips(int numShips) {
		this.numShips = numShips;
	}
	public int[] getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(int[] coordinates) {
		this.coordinates = coordinates;
	}
	public int[] getBoardDimensions() {
		return boardDimensions;
	}
	public void setBoardDimensions(int[] boardDimensions) {
		this.boardDimensions = boardDimensions;
	}

}

