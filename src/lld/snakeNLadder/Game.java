package lld.snakeNLadder;

public class Game {
    private GameBoard gameBoard;
    private Dice dice;
    private GamePiece[] gamePieces;
    private int currentPlayer;

    public Game(int numPlayers){
        gamePieces = new GamePiece[numPlayers];
        currentPlayer = 0;
        gameBoard = new GameBoard(Constant.NUM_SQUARES, 10, 10);
        dice = new Dice();
        for(int i = 0 ; i < numPlayers ; i++){
            gamePieces[i] = new GamePiece();
        }
    }

    public void playTurn(){

        int diceNum = dice.rollDice();
        gamePieces[currentPlayer].movePiece(diceNum);
        gameBoard.moveGamePiece(gamePieces[currentPlayer]);
        currentPlayer++;
        if(currentPlayer == gamePieces.length){
            currentPlayer = 0;
        }
    }

    public int getWinner(){
        for(int i = 0 ; i < gamePieces.length ; i++){
            if(gamePieces[i].getHasEnded()){
                return i;
            }
        }
        return -1;
    }







}
