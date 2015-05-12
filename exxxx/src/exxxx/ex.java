package exxxx;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ex {
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		
		String host = "www.naver.com";
		int timeout = 5000;
		
		boolean result = InetAddress.getByName(host).isReachable(timeout);
		if(result == true)
			System.out.println("success");
		else
			System.out.println("fail");
		
		
	}
}
