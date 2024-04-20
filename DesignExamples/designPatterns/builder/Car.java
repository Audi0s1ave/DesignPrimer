package designPatterns.builder;

public class Car {

    private String steer;
    private String music;
    private Integer speed;
    private Boolean isBraked;

    public Car(Builder builder) {
        this.setBraked(builder.isBraked);
        this.setMusic(builder.music);
        this.setSteer(builder.steer);
        this.setSpeed(builder.speed);
    }

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

    public static class Builder{
        private String steer;
        private String music;
        private Integer speed;
        private Boolean isBraked;
        public Builder speed(Integer speed){
            this.speed = speed;
            return this;
        }
        public Builder steer(String steer){
            this.steer = steer;
            return this;
        }

        public Builder music(String music){
            this.music = music;
            return this;
        }

        public Builder isBraked(Boolean isBraked){
            this.isBraked = isBraked;
            return this;
        }

        public Car build(){
            return new Car(this);
        }

    }




}
