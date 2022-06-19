package observer;

import javax.enterprise.event.ObservesAsync;
import javax.enterprise.context.Dependent;
import javax.annotation.Priority;
import javax.ejb.LocalBean;
import javax.inject.Named;

@Dependent
@LocalBean
@Named("crashNotificationBot")
public class CrashNotificationBot {

    public void action(@ObservesAsync @Priority(50) PriceChangeEvent priceChangeEvent) {
        if (priceChangeEvent.getPriceChange() / priceChangeEvent.getPrice() < -0.1) {
            System.out.println("WARNING: possible stock crash in progress with: " + priceChangeEvent.getStock());
        }
    }
}
