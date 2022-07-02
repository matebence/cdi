package injection.encrypt.codes;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import injection.encrypt.CodeGenerator;
import injection.encrypt.Code;

@Dependent
@Named("SHA512")
@Code(type = Code.Type.SHA512, locale = Code.Locale.SPANISH)
public class SHA512 implements CodeGenerator {

    @Override
    public String generateCode() {
        return "WQESA156Q743198GD14134132";
    }
}
