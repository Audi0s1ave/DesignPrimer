package lld.snakeNLadder;

public class GamePiece {
    private int position;
    private boolean hasEnded;

    public GamePiece(){
        this.position = 0;
        this.hasEnded = false;
    }

    public boolean getHasEnded() {
        return hasEnded;
    }

    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void movePiece(int num){
        if(num + position <= Constant.NUM_SQUARES){
            this.setPosition(num + position);
        }
        if(position == Constant.NUM_SQUARES){
            this.setHasEnded(true);
        }
    }
}
