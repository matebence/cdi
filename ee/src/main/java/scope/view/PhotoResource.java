package scope.view;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@ViewScoped
@Named(value = "photoResource")
public class PhotoResource implements Serializable {

    @Getter
    @Setter
    private String value;

    @PostConstruct
    public void onCreate() {
        this.value = "It is usually created on an HTTP request. The bean gets destroyed when the user post-backs to a different view.";
    }

    @PreDestroy
    public void onDestroy() {
        this.value = null;
    }
}
