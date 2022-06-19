package scope.request;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@RequestScoped
@Named(value = "carResource")
public class CarResource {

    @Getter
    @Setter
    private String value;

    @PostConstruct
    public void onCreate() {
        this.value = "The variables create on request and destroyed on end of the request";
    }

    @PreDestroy
    public void onDestroy() {
        this.value = null;
    }
}
