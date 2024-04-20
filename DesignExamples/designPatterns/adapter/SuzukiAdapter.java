package designPatterns.adapter;

public class SuzukiAdapter implements Car{

    private String steer;
    private String music;
    private Integer speed;
    private Boolean isBraked;

    public SuzukiAdapter(Suzuki suzuki){
        this.isBraked = suzuki.retrieveBraked();
        this.music = suzuki.retrieveMusic();
        this.speed = suzuki.retrieveSpeed();
        this.steer = suzuki.retrieveSteer();
    }
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
