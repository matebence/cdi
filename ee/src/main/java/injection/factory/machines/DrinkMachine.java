package injection.factory.machines;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ejb.Local;

import injection.factory.Machine;
import injection.factory.Type;

@Local
@Dependent
@Type(name = Type.Name.DRINK)
@Named(value = "DrinkMachine")
public class DrinkMachine implements Machine {

    @Override
    public String create() {
        return "DrinkMachine";
    }
}
