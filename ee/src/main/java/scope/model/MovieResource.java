package scope.model;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.annotation.PreDestroy;

import lombok.Getter;
import lombok.Setter;

@Model
public class MovieResource {

    @Getter
    @Setter
    private String value;

    @PostConstruct
    public void onCreate() {
        this.value = "The built-in stereotype intended for use with beans that define the model layer of an MVC web application architecture such as JSF. Same as @Named @RequestScoped";
    }

    @PreDestroy
    public void onDestroy() {
        this.value = null;
    }
}
