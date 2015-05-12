package exxxx;

import javax.naming.*;
import javax.naming.directory.*;

import java.net.InetAddress;
import java.util.*;

public class ex9191   { 
    public static void main(String[] args)  { 
        
    	try {
            Hashtable env = new Hashtable();
            env.put("java.naming.factory.initial","com.sun.jndi.dns.DnsContextFactory");

            DirContext ctx = new InitialDirContext(env);
            Attributes attrs = ctx.getAttributes("24.177.104.166.in-addr.arpa",new String[] {"PTR"});

            for (NamingEnumeration ae = attrs.getAll();ae.hasMoreElements();) {
                Attribute attr = (Attribute)ae.next();
                String attrId = attr.getID();
                for (Enumeration vals = attr.getAll();vals.hasMoreElements();
                System.out.println(attrId + ": " + vals.nextElement()));
            }

            ctx.close();
        }   

        catch(Exception e) {
            System.out.println("NO REVERSE DNS");
        }
    }
}
	
