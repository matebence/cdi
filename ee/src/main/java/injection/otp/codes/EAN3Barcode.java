package injection.otp.codes;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ejb.Local;

import injection.otp.CodeGenerator;
import injection.otp.Code;

@Local
@Dependent
@Named("EAN3Barcode")
@Code(type = Code.Type.EAN3)
public class EAN3Barcode implements CodeGenerator {

    @Override
    public String generateCode() {
        return "EAN13: 741852963";
    }
}
