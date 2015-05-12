package exxxx;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;

public class ex99 {

	public static void main(String[] args) throws UnknownHostException{
		
		InetAddress ipAddress = null;
		int ipLo = ipToInt(InetAddress.getByName("166.104.255.240"));
        int ipHi = ipToInt(InetAddress.getByName("166.104.255.255"));//ip 검색 범위 설정. 
        
        for(int i=ipLo; i<ipHi; i++){
        		    	
        	InetAddress ipAddress11 = InetAddress.getByName(intToIp(i));
        if(ipAddress11.isReachable(5000)==true){
        	
        	System.out.println(ipAddress11);
       
        }
        }  
   	}
	
        
        
        
        public static int ipToInt(InetAddress ip) {
            try {
                byte[] bytes = ip.getAddress();
                int octet1 = (bytes[0] & 0xFF) << 24;
                int octet2 = (bytes[1] & 0xFF) << 16;
                int octet3 = (bytes[2] & 0xFF) << 8;
                int octet4 = bytes[3] & 0xFF;
                int address = octet1 | octet2 | octet3 | octet4;

                return address;
            } catch (Exception e) {
                e.printStackTrace();

                return 0;
            }
        }

        public static String intToIp(int ipAddress) {
            int octet1 = (ipAddress & 0xFF000000) >>> 24;
            int octet2 = (ipAddress & 0xFF0000) >>> 16;
            int octet3 = (ipAddress & 0xFF00) >>> 8;
            int octet4 = ipAddress & 0xFF;

            return new StringBuffer().append(octet1).append('.').append(octet2)
                                     .append('.').append(octet3).append('.')
                                     .append(octet4).toString();
        }
}
