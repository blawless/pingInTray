package tray;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class Main implements ActionListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("WOO !");
		Main main = new Main();
	}

	public Main()
	{
		 //Check the SystemTray is supported
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        else
        {	
        	String currentDir = System.getProperty("user.dir");
        	System.out.println("Current dir using System:" +currentDir);
	        PopupMenu popup = new PopupMenu();
	        Image image = new ImageIcon(currentDir+"\\src\\tray\\test.jpg").getImage();
	        TrayIcon trayIcon = new TrayIcon(image, "tray icon");
	        trayIcon.setImageAutoSize(true);
	        SystemTray tray = SystemTray.getSystemTray();
	       
	        // Create as pop-up menu components
	        
	        MenuItem exitItem = new MenuItem("Exit");
	        exitItem.addActionListener(this);
	        exitItem.setActionCommand("Exit");
	        //Add components to pop-up menu
	       
	        popup.add(exitItem);
	       
	        trayIcon.setPopupMenu(popup);
	        boolean t=true;
	        int x=1;
	     
	        
	        NumberToImage num = new NumberToImage();
	        Image image2 = num.intToImage(x);
	    
	        trayIcon.setImage(image2);
	        x++;
	        try {
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        Image image3 = num.intToImage(x);
	        trayIcon.setImage(image3);
	        	
	        
	        try {
	            tray.add(trayIcon);
	        } catch (AWTException e) {
	            System.out.println("TrayIcon could not be added.");
	        }
	        
        }
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		String action = event.getActionCommand();
		
		if(action.equals("Exit"))
		{
			System.out.println("Exiting");
			System.exit(0);
			
		}
		
	}
}
