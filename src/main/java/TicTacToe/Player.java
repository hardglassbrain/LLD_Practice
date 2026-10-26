package TicTacToe;

public class Player {
    String name;
    Tile chosenTile;

    public Player(String name, Tile chosenTile){
        this.name = name;
        this.chosenTile = chosenTile;
    }

    public String getName() {
        return name;
    }

    public Tile getChosenTile() {
        return chosenTile;
    }
}
