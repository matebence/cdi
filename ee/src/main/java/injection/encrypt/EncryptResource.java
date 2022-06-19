package injection.encrypt;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@RequestScoped
@Named(value = "encrypt")
public class EncryptResource {

    @Inject
    @Code(type = Code.Type.SHA256, locale = Code.Locale.FRENCH)
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
