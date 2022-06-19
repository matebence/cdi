package observer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class PriceChangeEvent {

    @Getter
    @Setter
    private String stock;

    @Getter
    @Setter
    private float price;

    @Getter
    @Setter
    private float priceChange;

    @Override
    public String toString() {
        return "PriceChangeEvent{" +
                "stock='" + stock + '\'' +
                ", price=" + price +
                ", priceChange=" + priceChange +
                '}';
    }
}
