package injection.barCode.codes;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ejb.Local;

import injection.barCode.CodeGenerator;
import injection.barCode.EAN13;

@EAN13
@Local
@Dependent
@Named("EAN13Barcode")
public class EAN13Barcode implements CodeGenerator {

    @Override
    public String generateCode() {
        return "EAN13: 9780735200449";
    }
}
