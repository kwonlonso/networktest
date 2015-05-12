package exxxx;

import java.net.*;

	public class ex7 {

		  public static void main (String[] args) throws UnknownHostException {
	
			  InetAddress ia = InetAddress.getByName("208.201.239.100");
		    System.out.println(ia.getCanonicalHostName());
		  }
		}


