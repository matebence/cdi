package decorator;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("SimpleCoder")
public class SimpleCoder implements Coder {

    @Override
    public String codeString(String value, int number) {
        return "SimpleCoder";
    }
}
