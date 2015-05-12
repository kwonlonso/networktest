package exxxx;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ex4 {

	public static void main(String[] args) throws UnknownHostException {
		
	
		
		System.out.println(InetAddress.getLocalHost().getHostAddress());
		InetAddress[] inetAddresses = InetAddress.getAllByName("www.hanyang.ac.kr");
		
		for (InetAddress ipAddress : inetAddresses){
			System.out.println(ipAddress);
		}
	}
}
