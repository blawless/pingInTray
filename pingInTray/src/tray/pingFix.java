package tray;


import java.util.Scanner;
public class pingFix {

	public pingFix() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isReachableByPing(String host) {
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

            if(myProcess.exitValue() == 0) {
            	return true;
            } else {
            	return false;
            }

	    } catch( Exception e ) {
	
	            e.printStackTrace();
	            return false;
	    }
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
	public static void main(String[] args) {
		
		Stopwatch timer = new Stopwatch();
		sop("Enter IP to test");
		
		Scanner in = new Scanner(System.in);
		String ip = in.nextLine();
		System.out.println(isReachableByPing(ip));
		
		int ms = 0;
		timer.start();
		isReachableByPing(ip);
		timer.stop();
		System.out.println("Replay from host " + timer.getElapsedMilliseconds() + "ms");

	}

}