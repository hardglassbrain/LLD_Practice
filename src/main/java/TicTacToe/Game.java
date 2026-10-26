package TicTacToe;

import java.util.Scanner;

public class Game {

    Board board;
    Player player1;
    Player player2;
    GameStatus status;

    public Game( Player player1, Player player2){
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.status = GameStatus.IDLE;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public GameStatus getStatus() {
        return status;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public static void playGame(){
        String player1_name;
        String player2_name;
        Tile player1_tile;
        Tile player2_tile;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Player Name");
        player1_name = scanner.next();
        System.out.println("Enter First Player Tile - X or O");
        if(scanner.next().equals("X")){
            player1_tile = Tile.X;
            player2_tile = Tile.O;
        }
        else {
            player1_tile = Tile.O;
            player2_tile = Tile.X;
        }
        System.out.println("Enter Second Player Name");
        player2_name = scanner.next();


        Game game = new Game(new Player(player1_name,player1_tile), new Player(player2_name,player2_tile));
        boolean turn = true;
        int moves = 0;
        while(game.getStatus()!= GameStatus.FINISHED){
            if(moves==9){
                game.setStatus(GameStatus.FINISHED);
                System.out.println("MATCH DRAW");
                break;
            }
            int i_coord = -1;
            int j_coord = -1;
            if(turn){
                System.out.println("Player1 -> Enter 2 coordinates seperated by space");
                i_coord = scanner.nextInt();
                j_coord = scanner.nextInt();
                boolean res = fillAndCheck(game,turn,i_coord,j_coord);

                if(res){
                    turn = false;
                    moves++;
                }
                else {
                    System.out.println("Box Already Filled, Find a new place");
                }

            }else{
                System.out.println("Player2 -> Enter 2 coordinates seperated by space");
                i_coord = scanner.nextInt();
                j_coord = scanner.nextInt();
                boolean res = fillAndCheck(game,turn,i_coord,j_coord);
                if(res){
                    moves++;
                    turn = true;
                }
                else {
                    System.out.println("Box Already Filled, Find a new place");
                }
            }
        }

    }

    private static boolean fillAndCheck(Game game, boolean turn, int iCoord, int jCoord) {
        Tile[][] board = game.getBoard().getBoard();
        if(iCoord>2 || iCoord<0 || jCoord>2 || jCoord<0) {
            System.out.println("Enter correct coordinates");
            return false;
        }
        if(board[iCoord][jCoord]==Tile.E){
            Tile tile = (turn)?game.getPlayer1().getChosenTile() : game.getPlayer2().getChosenTile();
            board[iCoord][jCoord] = tile;
            printBoard(board);
            if(didPlayerWin(board,tile,iCoord,jCoord)) {
                game.setStatus(GameStatus.FINISHED);
                if(turn) System.out.println("Player1 Wins");
                else System.out.println("Player2 wins");
            }

            return true;
        }else{
            return false;
        }
    }

    private static void printBoard(Tile[][] board) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                if (board[i][j] == Tile.E) {
                    System.out.print(" ");
                } else {
                    System.out.print(board[i][j]);
                }
                if (j != 2) System.out.print("|");
            }
            System.out.println();
            if(i!=2) System.out.print("_ _ _");
            System.out.println();
        }
    }

    private static boolean didPlayerWin(Tile[][] board, Tile tile, int iCoord, int jCoord) {
        boolean hor = true;
        boolean ver = true;
        boolean dia=true;

        for(int j=0;j<3;j++){
            if(board[iCoord][j]!=tile) {
                hor=false;
                break;
            }
        }

        for(int i=0;i<3;i++){
            if(board[i][jCoord]!=tile) {
                ver=false;
                break;
            }
        }

        if(Math.abs(iCoord-jCoord)!=1){
            if(iCoord==jCoord){
                int i=0;
                int j=0;
                while(i<=2 && j<=2){
                    if(board[i++][j++]!=tile){
                        dia = false;
                        break;
                    }
                }
            }else{
                int i=0;
                int j=2;
                while(i<=2 && j>=0){
                    if(board[i++][j--]!=tile){
                        dia = false;
                        break;
                    }
                }
            }
        }else{
            dia = false;
        }

        return hor||ver||dia;
    }
    }


