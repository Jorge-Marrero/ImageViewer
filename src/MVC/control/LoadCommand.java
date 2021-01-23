package MVC.control;

import MVC.app.mock.MockImageLoader;
import java.util.List;
import MVC.model.Image;
import MVC.view.ImageDisplay;
import MVC.view.ImageLoader;

public class LoadCommand implements Command{

    private final ImageLoader loader;
    private final List<Image> imageList;
    private final ImageDisplay imageDisplay;

    public LoadCommand(ImageLoader loader, List<Image> imageList, ImageDisplay imageDisplay) {
        this.imageList = imageList;
        this.imageDisplay = imageDisplay;
        this.loader = loader;
    }

    @Override
    public void execute() {
        this.imageList.clear();
        this.imageList.addAll(loader.load());
        imageDisplay.display(imageList.get(0));
    }
    
}
