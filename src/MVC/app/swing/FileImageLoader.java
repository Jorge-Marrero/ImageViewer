package MVC.app.swing;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import MVC.model.Image;
import MVC.view.ImageLoader;

public class FileImageLoader implements ImageLoader{
    private final File root;
    private static final String[] imageExtensions = new String[]{".jpg", ".png", ".jpeg"};
    
    public FileImageLoader(File root) {
        this.root = root;
    }

    @Override
    public List<Image> load() {
        List<Image>list = new ArrayList<>();
        for(File file : root.listFiles(imageFilter())){
            list.add(new Image(file.getAbsolutePath()));
        }
        return list;
    }
    
    
    private FilenameFilter imageFilter() {
        return new FilenameFilter(){
            @Override
            public boolean accept(File parent, String name){
                for(String imageExtension : imageExtensions)
                    if (name.endsWith(imageExtension)) return true;
                return false;
            }
        };
    }
    

}
