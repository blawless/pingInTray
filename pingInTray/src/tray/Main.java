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

	 TrayIcon trayIcon;
	 SystemTray tray;
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
	        trayIcon = new TrayIcon(image, "tray icon");
	        trayIcon.setImageAutoSize(true);
	        tray = SystemTray.getSystemTray();
	       
	        // Create as pop-up menu components
	        
	        MenuItem exitItem = new MenuItem("Exit");
	        exitItem.addActionListener(this);
	        exitItem.setActionCommand("Exit");
	        //Add components to pop-up menu
	       
	        popup.add(exitItem);
	       
	        trayIcon.setPopupMenu(popup);
	        
	        startUpdater();
	        
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
	
	//rubbish
	public void startUpdater()
	{ 	
			Thread updater = new Thread(new TrayUpdater(trayIcon,tray));
		    updater.start();   
	}
}
