package MVC.app.swing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import MVC.model.Image;
import MVC.view.ImageDisplay;

public class ImagePanel extends JPanel implements ImageDisplay{
    
    private Image image;
    private BufferedImage bufferedImage;
    
    public ImagePanel() {
    }
    
    @Override
    public void paint(Graphics g){
        Bound bound = new Bound(bufferedImage);
        g.drawImage(bufferedImage, bound.x, bound.y, bound.width, bound.height, null);
    }

    private BufferedImage load(String name){
        try{
            return ImageIO.read(new File(name));
        }catch (IOException e){
            return null;
        }
    }

    @Override
    public void display(Image image) {
        this.image = image;
        this.bufferedImage = load(image.getName());
        repaint();
    }

    @Override
    public Image current() {
        return image;
    }
    
    private class Bound{
        final int x;
        final int y;
        final int width;
        final int height;
        private final int pw;
        private final int ph;

        public Bound(BufferedImage image) {
            this.pw = getWidth();
            this.width = calculateWidth(image.getWidth(), image.getHeight());
            this.ph = getHeight();
            this.height = calculateHeight(image.getWidth(), image.getHeight());
            this.x = (ph - width)/2;
            this.y = (pw - height)/2;
        }

        private int calculateWidth(double ix, double iy) {
            double pr = (double) ph / pw;
            double ir = ix / iy;
            return ir > pr ? ph : (int) (ix * pw / iy);
        }

        private int calculateHeight(double ix, double iy) {
           double pr = (double) ph / pw;
           double ir = ix / iy;
           return ir > pr ? (int) (iy * ph / ix) : ph; 
        }
    }
}
