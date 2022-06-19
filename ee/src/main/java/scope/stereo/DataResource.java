package scope.stereo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@Action
public class DataResource {

    @Getter
    @Setter
    private String value;

    @PostConstruct
    public void onCreate() {
        this.value = "Custom Stereotype with @Transactional and @ApplicationScoped " + (new Random().nextInt(5) + 15);
    }

    @PreDestroy
    public void onDestroy() {
        this.value = null;
    }
}
