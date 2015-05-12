package exxxx;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;

public class ex9999 {
	

	
		public static void main(String[] args) throws UnknownHostException{
			
		try{
			int ipLo = ipToInt(InetAddress.getByName("166.104.177.1"));
	        int ipHi = ipToInt(InetAddress.getByName("166.104.177.255"));//ip 검색 범위 설정. 
	        
	        for(int i=ipLo; i<ipHi; i++){
	        	
	        	String ipAddress = getHostName(intToIp(i));
	        	InetAddress j = InetAddress.getByName(intToIp(i));
	        	boolean b = ipAddress.contains("kr");
	        	boolean c = ipAddress.contains("com");
		        
		        if(b){
		        	System.out.println(j + " / " + ipAddress);
		        }
		        else if(c){
		        	System.out.println(j + " / " + ipAddress);
		        }
		        else{
		        	System.out.println(j + " / " + " do not exist");
		        }
	        }
	        
		}
		catch(Exception e){
					System.out.println("Exception : " + e.getMessage());
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
	       
	        private static String getHostName(String ip)
	        {
	          String retVal = null;
	          final String[] bytes = ip.split("\\.");
	          if (bytes.length == 4)
	          {
	             try
	             {
	                final java.util.Hashtable<String, String> env = new java.util.Hashtable<String, String>();
	                env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
	                final javax.naming.directory.DirContext ctx = new javax.naming.directory.InitialDirContext(env);
	                final String reverseDnsDomain = bytes[3] + "." + bytes[2] + "." + bytes[1] + "." + bytes[0] + ".in-addr.arpa";
	                final javax.naming.directory.Attributes attrs = ctx.getAttributes(reverseDnsDomain, new String[]
	                {
	                   "PTR",
	                });
	                for (final javax.naming.NamingEnumeration<? extends javax.naming.directory.Attribute> ae = attrs.getAll(); ae.hasMoreElements();)
	                {
	                   final javax.naming.directory.Attribute attr = ae.next();
	                   final String attrId = attr.getID();
	                   for (final java.util.Enumeration<?> vals = attr.getAll(); vals.hasMoreElements();)
	                   {
	                      String value = vals.nextElement().toString();
	                      // System.out.println(attrId + ": " + value);

	                      if ("PTR".equals(attrId))
	                      {
	                         final int len = value.length();
	                         if (value.charAt(len - 1) == '.')
	                         {
	                            // Strip out trailing period
	                            value = value.substring(0, len - 1);
	                         }
	                         retVal = value;
	                      }
	                   }
	                }
	                ctx.close();
	             }
	             catch (final javax.naming.NamingException e)
	             {
	                // No reverse DNS that we could find, try with InetAddress
	                System.out.print(""); // NO-OP
	             }
	          }
	          if (null == retVal)
	          {
	             try
	             {
	                retVal = java.net.InetAddress.getByName(ip).getCanonicalHostName();
	             }
	             catch (final java.net.UnknownHostException e1)
	             {
	                retVal = ip;
	             }
	          }
	          return retVal;
	        }
	    }





