package MVP.app;

import MVP.control.ImagePresenter;
import MVP.model.Image;
import MVP.view.ImageDisplay;
import java.awt.PopupMenu;
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
        this.setTitle("ImageViewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        List<Image> list = new ArrayList<>();
        list.add(new Image("fotos/burgos1.jpg"));
        list.add(new Image("fotos/burgos2.jpg"));
        list.add(new Image("fotos/burgos3.jpg"));
        this.getContentPane().add(createImagePanel());
        this.imageDisplay.display(list.get(0));
        this.imagePresenter = new ImagePresenter(list, imageDisplay);
    }

    private void execute() {
        this.setVisible(true);
    }

    private JPanel createImagePanel() {
        ImagePanel imagePanel = new ImagePanel();
        this.imageDisplay = imagePanel;
        return imagePanel;
    }
}
