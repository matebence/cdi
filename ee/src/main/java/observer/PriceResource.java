package observer;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@RequestScoped
@Named(value = "priceResource")
public class PriceResource {

    @Inject
    private StockObserver stockObserver;

    @Getter
    @Setter
    private PriceChangeEvent priceChangeEvent;

    @PostConstruct
    public void onCreate() {
        priceChangeEvent = new PriceChangeEvent("Lenovo", 15.5f, 18.5f);
        stockObserver.priceChange(priceChangeEvent);
    }

    @PreDestroy
    public void onDestroy() {
        priceChangeEvent = null;
    }
}
