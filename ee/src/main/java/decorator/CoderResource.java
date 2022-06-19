package decorator;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@RequestScoped
@Named(value = "coderResource")
public class CoderResource {

    @Inject
    @Named("SimpleCoder")
    private Coder coder;

    @Getter
    @Setter
    private String value;

    @PostConstruct
    public void onCreate() {
        this.value = coder.codeString("ecneb", 5);
    }

    @PreDestroy
    public void onDestroy() {
        this.value = null;
    }
}
