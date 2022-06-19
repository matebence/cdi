package scope.session;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.inject.Named;

import java.io.Serializable;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

/* @RolesAllowed and @DenyAll are active on EJB not on CDI Managed Bean */

@Stateful
@SessionScoped
@Named(value = "houseResource")
public class HouseResource implements Serializable {

    @Getter
    @Setter
    private String value;

    @PostConstruct
    public void onCreate() {
        this.value = "The variables create on new session and destroyed on session destroy (or on new session) " + (new Random().nextInt(5) + 15);
    }

    @PreDestroy
    public void onDestroy() {
        this.value = null;
    }

    @RolesAllowed("admin")
    public void deleteCurrentSession() {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(true);
        session.invalidate();
    }
}
