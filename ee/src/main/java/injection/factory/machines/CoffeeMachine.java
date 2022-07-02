package injection.factory.machines;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import injection.factory.Machine;
import injection.factory.Type;

@Dependent
@Type(name = Type.Name.COFFEE)
@Named(value = "CoffeeMachine")
public class CoffeeMachine implements Machine {

    @Override
    public String create() {
        return "CoffeeMachine";
    }
}
