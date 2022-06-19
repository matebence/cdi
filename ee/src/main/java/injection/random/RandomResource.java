package injection.random;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@RequestScoped
@Named(value = "random")
public class RandomResource {

    @Inject
    @Getter
    @Setter
    private ArrayList<Integer> numbers;

    @PostConstruct
    public void onCreate() {
        System.out.println("Stat of request");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("End of request");
    }
}
