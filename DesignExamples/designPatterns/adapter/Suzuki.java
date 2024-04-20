package designPatterns.adapter;

public class Suzuki {

    private String steer;
    private String music;
    private Integer speed;
    private Boolean isBraked;

    public Integer retrieveSpeed() {
        return this.speed;
    }

    public String retrieveMusic() {
        return this.music;
    }

    public Boolean retrieveBraked() {
        return this.isBraked;
    }

    public String retrieveSteer() {
        return this.steer;
    }
}