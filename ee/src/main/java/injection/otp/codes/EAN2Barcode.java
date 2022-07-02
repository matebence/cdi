package injection.otp.codes;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import injection.otp.CodeGenerator;
import injection.otp.Code;

@Dependent
@Named("EAN2Barcode")
@Code(type = Code.Type.EAN2)
public class EAN2Barcode implements CodeGenerator {

    @Override
    public String generateCode() {
        return "EAN13: 987654321";
    }
}
