package tray;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class NumberToImage {

	public Image intToImage(Integer pingValue) {
		
		String stringOfPingValue = Integer.toString(pingValue); 
	    JLabel text = new JLabel(stringOfPingValue);
	    text.setSize(25,20);
	    BufferedImage image = getImage(text);
//	    try {
//            ImageIO.write(image, "png", new File("C:/temp/img.png"));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
	    return  image;
	}
	
	private BufferedImage getImage(JComponent c) {
	    Rectangle region = c.getBounds();
	    BufferedImage image = new BufferedImage(region.width, region.height, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2d = image.createGraphics();
	    g2d.translate(-region.x, -region.y);
	    g2d.setColor(c.getBackground() );
	    g2d.fillRect(region.x, region.y, region.width, region.height);
	    c.paint(g2d);
	    g2d.dispose();
	    return image;
	}

}

