package designPatterns.adapter;

public class Honda implements Car{
    private String steer;
    private String music;
    private Integer speed;
    private Boolean isBraked;

    @Override
    public Integer getSpeed() {
        return this.speed;
    }

    @Override
    public String getMusic() {
        return this.music;
    }

    @Override
    public Boolean getBraked() {
        return this.isBraked;
    }

    @Override
    public String getSteer() {
        return this.steer;
    }
}
