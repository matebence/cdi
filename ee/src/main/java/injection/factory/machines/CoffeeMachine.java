package injection.factory.machines;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ejb.Local;

import injection.factory.Machine;
import injection.factory.Type;

@Local
@Dependent
@Type(name = Type.Name.COFFEE)
@Named(value = "CoffeeMachine")
public class CoffeeMachine implements Machine {

    @Override
    public String create() {
        return "CoffeeMachine";
    }
}
