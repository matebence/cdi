package injection.encrypt.codes;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import injection.encrypt.CodeGenerator;
import injection.encrypt.Code;

@Dependent
@Named("SHA256")
@Code(type = Code.Type.SHA256, locale = Code.Locale.FRENCH)
public class SHA256 implements CodeGenerator {

    @Override
    public String generateCode() {
        return "SADWQE7W897SD4A56SD4WQ1D32AS123414566";
    }
}
