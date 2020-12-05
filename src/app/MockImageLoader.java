package app;

import java.util.ArrayList;
import java.util.List;
import model.Image;
import view.ImageLoader;

public class MockImageLoader implements ImageLoader {

    public List<Image> load() {
        List<Image> list = new ArrayList<Image>();
        list.add(new Image("Hola"));
        list.add(new Image("mundo"));
        list.add(new Image("bienvenido"));
        return list;
    }


}
