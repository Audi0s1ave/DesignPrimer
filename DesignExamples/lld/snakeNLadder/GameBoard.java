package lld.snakeNLadder;


public class GameBoard {
    private class Snake{
        int head;
        int tail;


    }
    private class Ladder{
        int top;
        int bottom;

    }
    private class Square{

    }

    private Square squares[];
    private Snake snakes[];
    private Ladder ladders[];

    public GameBoard(int squareSize, int snakesSize, int laddersSize){
        this.squares = new Square[squareSize];
        this.snakes = new Snake[snakesSize];
        this.ladders = new Ladder[laddersSize];

    }

    public void moveGamePiece(GamePiece gamePiece){
        for(Snake snake : snakes){
            if(gamePiece.getPosition()==snake.head){
                gamePiece.setPosition(snake.tail);
                break;
            }
        }
        for(Ladder ladder : ladders){
            if(gamePiece.getPosition()==ladder.bottom){
                gamePiece.setPosition(ladder.top);
                break;
            }
        }

    }




}
