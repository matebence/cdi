package scope.conversation;

import javax.enterprise.context.ConversationScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import javax.enterprise.context.Conversation;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@ConversationScoped
@Named(value = "recipeResource")
public class RecipeResource implements Serializable {

    @Inject
    @Getter
    @Setter
    private Conversation conversation;

    @Getter
    @Setter
    private String message;

    private String[] words = {"Hello!!", "Have a nice day!!", "Goodbye..", "Hi!", "Goodmorning!", "Bye..", "Good evening.."};

    @PostConstruct
    public void onCreate() {
        if (message == null) {
            message = "Hello Conversation scoped..";
        }
    }

    @PreDestroy
    public void onDestroy() {
        message = "Destroyed on conversation.end() and also recreate because we redirect to the initial page";
    }

    public void initConversation() {
        if (!FacesContext.getCurrentInstance().isPostback() && conversation.isTransient()) {
            conversation.begin();
        }
    }

    public String endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return "recepieOne?faces-redirect=true";
    }

    public void sendMessage() {
        message = words[new Random().nextInt(7)];
    }
}
