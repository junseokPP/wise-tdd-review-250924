import com.back.App;
import com.back.AppContext;

public class Main {
    public static void main(String[] args) {
        AppContext.init();
        new App().run();

    }
}
