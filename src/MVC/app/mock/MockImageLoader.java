package MVC.app.mock;

import java.util.ArrayList;
import java.util.List;
import MVC.model.Image;
import MVC.view.ImageLoader;

public class MockImageLoader implements ImageLoader {

    public List<Image> load() {
        List<Image> list = new ArrayList<Image>();
        list.add(new Image("Hola"));
        list.add(new Image("mundo"));
        list.add(new Image("bienvenido"));
        return list;
    }


}
