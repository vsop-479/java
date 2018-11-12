package designPattern.observer.observer;

import designPattern.observer.observable.Weather;

import java.util.Observable;
import java.util.Observer;

public class BTV implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Weather){
            System.out.println("weather condition: " + o.toString());
        }else{
            System.out.println("unknown weather condition: " + o.toString());
        }

    }
}
