package scope.application;

import javax.enterprise.context.ApplicationScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@ApplicationScoped
@Named(value = "streetResource")
public class StreetResource {

    @Getter
    @Setter
    private String value;

    @PostConstruct
    public void onCreate() {
        this.value = "The value will never change until application shutdown " + (new Random().nextInt(6) + 5);
    }

    @PreDestroy
    public void onDestroy() {
        this.value = null;
    }
}
