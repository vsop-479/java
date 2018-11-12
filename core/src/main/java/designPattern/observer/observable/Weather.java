package designPattern.observer.observable;

import java.util.Observable;

public class Weather extends Observable {
    private float temperature = 20.0f;
    private float humidity = 64.5f;
    private float pm2p5 = 50.0f;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPm2p5() {
        return pm2p5;
    }

    public void setPm2p5(float pm2p5) {
        this.pm2p5 = pm2p5;
    }

    public void setChanged(){
        super.setChanged();
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pm2p5=" + pm2p5 +
                '}';
    }
}
