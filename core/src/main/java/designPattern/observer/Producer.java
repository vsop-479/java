package designPattern.observer;

import designPattern.observer.observable.Weather;
import designPattern.observer.observer.BTV;
import designPattern.observer.observer.CCTV;

public class Producer {
    public static void main(String[] args){
        Weather w = new Weather();
        w.addObserver(new CCTV());
        w.addObserver(new BTV());

        //change pm2p5
        w.setPm2p5(10.0f);
        w.setChanged();
//        notify observers
        w.notifyObservers();
    }

}
