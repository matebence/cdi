package injection.otp.codes;

import injection.otp.CodeGenerator;
import injection.otp.Code;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ejb.Local;

@Local
@Dependent
@Named("EAN1Barcode")
@Code(type = Code.Type.EAN1)
public class EAN1Barcode implements CodeGenerator {

    @Override
    public String generateCode() {
        return "EAN13: 123456789";
    }
}
