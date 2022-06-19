package injection.draw.shapes;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ejb.Local;

import injection.draw.Shape;

@Local
@Dependent
@Named("Square")
public class Square implements Shape {

    @Override
    public String draw() {
        return "Inside Cube::injection.draw() method.";
    }
}