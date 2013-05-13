package tray;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class pingFix {

	public pingFix() {
		// TODO Auto-generated constructor stub
	}
	
	public int isReachableByPing(String host) {
		try{
            String cmd = "";
            if(System.getProperty("os.name").startsWith("Windows")) {   
                    // For Windows
                    cmd = "ping -n 1 " + host;
            } else {
                    // For Linux and OSX
                    cmd = "ping -c 1 " + host;
            }
            
            Process myProcess = Runtime.getRuntime().exec(cmd);
            myProcess.waitFor();
            try {
            	myProcess.waitFor();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            BufferedReader reader=new BufferedReader(new InputStreamReader(myProcess.getInputStream())); 
            String line=reader.readLine(); 
            String mainResult="";
            while(line!=null) 
            { 
             
	            if(line.contains("time="))
	            {
	            	mainResult=line;
	            }
	            line=reader.readLine(); 
	            
	            
            } 
            
            String split1[] = mainResult.split(" ");
            String timeNeedsCleaning= split1[4];
            timeNeedsCleaning= timeNeedsCleaning.replace("time=", "");
            String timeString = timeNeedsCleaning.replace("ms", "");
            //System.out.println(timeString);
            
            int time = Integer.parseInt(timeString);
            return time;

	    } catch( Exception e ) {
	
	            e.printStackTrace();
	           
	    }
		return 0;
	}
	
	public static void sop(String print){
		System.out.println(print);
	}
	
	/*
	public static int pingTime(Object timer, String host){
		int ms = 0;
		
		do{
			timer.start();
		}while(isReachableByPing(host));
		
		
		return ms;
		
	}
	*/

	/**
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		
		
		isReachableByPing("www.google.ie");

		

	}*/

}