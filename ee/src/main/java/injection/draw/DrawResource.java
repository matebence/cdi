package injection.draw;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@RequestScoped
@Named(value = "draw")
public class DrawResource {

    @Inject
    @Named("Rectangle")
    private Shape shape;

    @Getter
    @Setter
    private String value;

    @PostConstruct
    public void onCreate() {
        this.value = shape.draw();
    }

    @PreDestroy
    public void onDestroy() {
        this.value = null;
    }
}
