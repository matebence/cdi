package injection.factory;

import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Any;
import javax.inject.Named;

import injection.factory.machines.CoffeeMachine;
import injection.factory.machines.DrinkMachine;

@Dependent
@Named("Factory")
public class Factory {

    @Produces
    @MachineFactory
    public Machine getMachine(@Any Instance<Machine> instance, InjectionPoint injectionPoint) {
        Type.Name type = injectionPoint
                .getAnnotated()
                .getAnnotation(Type.class)
                .name();

        if (type.equals(Type.Name.COFFEE)) {
            return new CoffeeMachine();

        } else if (type.equals(Type.Name.DRINK)) {
            return new DrinkMachine();
        }
        return null;
    }

    public void onDestroy(@MachineFactory @Disposes Machine machine) {
        machine = null;
    }
}
