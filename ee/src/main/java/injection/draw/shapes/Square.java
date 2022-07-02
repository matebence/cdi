package injection.draw.shapes;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import injection.draw.Shape;

@Dependent
@Named("Square")
public class Square implements Shape {

    @Override
    public String draw() {
        return "Inside Cube::injection.draw() method.";
    }
}