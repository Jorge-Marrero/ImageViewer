package MVC.control;

import java.util.List;
import MVC.model.Image;
import MVC.view.ImageDisplay;

public class NextImageCommand implements Command{
    
    private final List<Image> imageList;
    private final ImageDisplay imageDisplay;

    public NextImageCommand(List<Image> imageList, ImageDisplay imageDisplay) {
        this.imageList = imageList;
        this.imageDisplay = imageDisplay;
    }
 
    @Override
    public void execute() {
        imageDisplay.display(next());
    }

    private Image next() {
        int index = imageList.indexOf(imageDisplay.current());
        index = (index+1) % imageList.size();
        return imageList.get(index);
    }
    
}
