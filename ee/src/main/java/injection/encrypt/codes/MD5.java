package injection.encrypt.codes;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import injection.encrypt.CodeGenerator;
import injection.encrypt.Code;

@Dependent
@Named("MD5")
@Code(type = Code.Type.MD5, locale = Code.Locale.ENGLISH)
public class MD5 implements CodeGenerator {

    @Override
    public String generateCode() {
        return "DF4S6123132AF243TY54334789";
    }
}
