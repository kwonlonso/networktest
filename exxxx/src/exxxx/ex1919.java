package exxxx;

	import java.io.*;
	import java.net.*;

	public class ex1919
		{
			public static void main(String[] args) {
				if (args.length != 1) {
					System.err.println("Usage: java DNSLookUp <IP name>");
					System.exit(0);
				}
					InetAddress hostAddress;
					try {
					hostAddress = InetAddress.getByName(args[0]);
					System.out.println(hostAddress.getHostAddress());
				}
				catch (UnknownHostException uhe) {
					System.err.println("Unknown host: " + args[0]);
				}
			}
		}

