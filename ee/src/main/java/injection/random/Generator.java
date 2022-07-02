package injection.random;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.Random;

@Dependent
@Named("Generator")
public class Generator {

    @Produces
    @SessionScoped
    public ArrayList<Integer> get(){
        Random random = new Random();
        return new ArrayList<Integer>() {{
            add(random.nextInt(6) + 5);
            add(random.nextInt(6) + 10);
            add(random.nextInt(6) + 15);
            add(random.nextInt(6) + 25);
        }};
    }

    public void onDestroy(@Disposes ArrayList<Integer> numbers) {
        numbers.clear();
    }
}
