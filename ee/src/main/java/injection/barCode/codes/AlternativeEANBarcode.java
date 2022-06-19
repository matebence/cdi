package injection.barCode.codes;

import javax.enterprise.inject.Alternative;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ejb.Local;

import injection.barCode.CodeGenerator;
import injection.barCode.EAN13;

@EAN13
@Local
@Dependent
@Alternative
@Named("AlternativeEANBarcode")
public class AlternativeEANBarcode implements CodeGenerator {

    @Override
    public String generateCode() {
        return "EAN13: Alternative";
    }
}
