package observer;

import interceptor.Logged;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Logged
@Dependent
@Named("stockObserver")
public class StockObserver {

    @Inject
    private Event<PriceChangeEvent> event;

    public void priceChange(PriceChangeEvent priceChangeEvent) {
        // If exception occurs other subscriber events will be canceled
        // This can be solved via async actions or catch all exceptions
        event.fireAsync(priceChangeEvent);
    }
}
