package MVP.app;

import MVP.model.Image;
import MVP.view.ImageDisplay;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements ImageDisplay{
    private Image image;
    private Image image2;
    BufferedImage actual;
    BufferedImage next;
    int offset;
    private Shift shift;
    private int x;
    
    public ImagePanel() {
        MouseHandler mouseHandler = new MouseHandler();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }
    
    @Override
    public void paint(Graphics g){
        actual = load(this.image);
        g.drawImage(actual, x, 0, null);
        if(x != 0){
            next = load(this.image2);
            offset = x > 0 ? -(next.getWidth() - x) : x + actual.getWidth();
            g.drawImage(next, offset, 0, null);
        }
        
    }
    
    private BufferedImage load(Image image){
        try{
            return ImageIO.read(new File(image.getName()));
        }catch(IOException e){
            return null;
        }
    }
    
    @Override
    public void display(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public Image image() {
        return this.image;
    }

    @Override
    public void on(Shift shift) {
        this.shift = shift;
    }

    private class MouseHandler implements MouseListener, MouseMotionListener{
        private int initial;
        
        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {
            this.initial = e.getX();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(Math.abs(e.getX() - initial) > getWidth() / 2){
                image = image2;
            }
            x = 0;
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseDragged(MouseEvent e) {
            x = e.getX() - initial;
            repaint();
            if(x > 0){
                image2 = shift.right();
            }
            if(x < 0){
                image2 = shift.left();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {}
    }    
}
