package injection.factory;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@RequestScoped
@Named(value = "machineResource")
public class MachineResource {

    @Inject
    @MachineFactory
    @Type(name = Type.Name.COFFEE)
    private Machine machine;

    @Getter
    @Setter
    private String value;

    @PostConstruct
    public void onCreate() {
        this.value = machine.create();
    }

    @PreDestroy
    public void onDestroy() {
        this.value = null;
    }
}
