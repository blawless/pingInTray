package tray;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;

public class TrayUpdater implements Runnable {

	TrayIcon trayIcon;
	SystemTray tray;
	public TrayUpdater(TrayIcon trayIcon, SystemTray tray) {
		this.trayIcon=trayIcon;
		this.tray=tray;
	}

	@Override
	public void run() {
		    boolean t=true;
	        int x=1;
	     
	        while(true){
	        pingFix p = new pingFix();
	        int time = p.obtainPingTime("www.google.ie");
	        
	        NumberToImage num = new NumberToImage();
	        Image image2 = num.intToImage(time);
	  
	        	try {
	        		
	        		trayIcon.setImage(image2);
	            	tray.add(trayIcon);
	            	try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	tray.remove(trayIcon);
	        	} catch (AWTException e) {
	        		System.out.println("TrayIcon could not be added.");
	        	}
	        	
	        }
		
	}

}
