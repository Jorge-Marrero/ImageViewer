package MVP.app;

import MVP.control.ImagePresenter;
import MVP.model.Image;
import MVP.view.ImageDisplay;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
    private ImageDisplay imageDisplay;
    private ImagePresenter imagePresenter;
    
    public static void main(String[] args) {
        new Main().execute();
    }

    public Main() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        List<Image> list = new FileImageLoader(new File("fotos")).load();
        this.getContentPane().add(imagePanel());
        this.imageDisplay.display(list.get(0));
        this.imagePresenter = new ImagePresenter(list, imageDisplay);
    }

    private void execute() {
        this.setVisible(true);
    }

    private JPanel imagePanel() {
        ImagePanel imagePanel = new ImagePanel();
        this.imageDisplay = imagePanel;
        return imagePanel;
    }
}
