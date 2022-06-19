package observer;

import javax.enterprise.event.ObservesAsync;
import javax.enterprise.context.Dependent;
import javax.annotation.Priority;
import javax.ejb.LocalBean;
import javax.inject.Named;

@Dependent
@LocalBean
@Named("buyTradingBot")
public class BuyTradingBot {

    //this will be executed first
    public void action(@ObservesAsync @Priority(1) PriceChangeEvent priceChangeEvent) {
        if (priceChangeEvent.getPriceChange() > 0) {
            System.out.println("BUY: " + priceChangeEvent.getStock());
        }
    }
}
