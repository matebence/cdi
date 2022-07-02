package injection.draw.shapes;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import injection.draw.Shape;

@Dependent
@Named("Circle")
public class Circle implements Shape {

    @Override
    public String draw() {
        return "Inside Triangle::injection.draw() method.";
    }
}