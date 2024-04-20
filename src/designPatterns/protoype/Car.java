package designPatterns.protoype;

public class Car implements Cloneable {

    private String steer;
    private String music;
    private Integer speed;
    private Boolean isBraked;

    public String getSteer() {
        return steer;
    }

    public void setSteer(String steer) {
        this.steer = steer;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Boolean getBraked() {
        return isBraked;
    }

    public void setBraked(Boolean braked) {
        isBraked = braked;
    }


    @Override
    public Car clone() {
        try {
            Car clone = (Car) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
