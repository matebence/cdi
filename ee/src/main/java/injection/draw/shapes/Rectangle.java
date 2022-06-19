package injection.draw.shapes;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ejb.Local;

import injection.draw.Shape;

@Local
@Dependent
@Named("Rectangle")
public class Rectangle implements Shape {

    @Override
    public String draw() {
        return "Inside Rectangle::injection.draw() method.";
    }
}