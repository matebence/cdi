package injection.otp;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@RequestScoped
@Named(value = "otpCode")
public class OtpCodeResource {

    @Inject
    @Code(type = Code.Type.EAN1)
    private CodeGenerator codeGenerator;

    @Getter
    @Setter
    private String value;

    @PostConstruct
    public void onCreate() {
        this.value = codeGenerator.generateCode();
    }

    @PreDestroy
    public void onDestroy() {
        this.value = null;
    }
}
