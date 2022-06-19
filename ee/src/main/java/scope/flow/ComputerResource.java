package scope.flow;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@FlowScoped(value = "computer")
@Named(value = "computerResource")
public class ComputerResource implements Serializable {

    @Getter
    @Setter
    private int itemCount;

    @Getter
    @Setter
    private String address;

    @PostConstruct
    public void onCreate() {
        System.out.println("onCreate");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("onDestroy");
    }
}
