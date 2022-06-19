package decorator;

import javax.enterprise.inject.Any;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.inject.Named;

@Decorator
@Named(value = "CoderDecorator")
public abstract class CoderDecorator implements Coder {

    @Any
    @Inject
    @Delegate
    private Coder coder;

    @Override
    public String codeString(String s, int tval) {
        int len = s.length();

        return "\"" + s + "\" becomes " + "\"" + coder.codeString(s, tval)
                + "\", " + len + " characters in length";
    }
}
