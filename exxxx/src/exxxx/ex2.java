package exxxx;
import java.net.*;

public class ex2 {

	public static void main(String[] args){
		
		InetAddress ipAddress = null;
		
		try{
			ipAddress = InetAddress.getByName("125.209.222.142");
			System.out.println("getHostName:"+ipAddress.getHostName());
			System.out.println("getHostAddr:"+ipAddress.getHostAddress());
			System.out.println("getHostName1:" +ipAddress.getCanonicalHostName());
			System.out.println("toString:"+ipAddress.toString());
		}
		catch(UnknownHostException e)
		{
			System.out.println(e);
		}
		System.out.println("----------------------------");
		try{
			ipAddress = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName:"+ipAddress.getHostName());
			System.out.println("getHostAddr:"+ipAddress.getHostAddress());
			System.out.println("toString:"+ipAddress.toString());
		}catch(UnknownHostException e){
			System.out.println(e);
		}
	}
	
}
