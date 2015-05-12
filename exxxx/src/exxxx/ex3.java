package exxxx;
import org.xbill.DNS.*;
import java.io.IOException;

    public class ex3 {

       public static String reverseDns(String hostIp) throws IOException {

             Record opt = null;
             Resolver res = new ExtendedResolver();
             Name name = ReverseMap.fromAddress(hostIp);
             int type = Type.PTR;
             int dclass = DClass.IN;
             Record rec = Record.newRecord(name, type, dclass);
             Message query = Message.newQuery(rec); 
             Message response = res.send(query);
             Record[] answers = response.getSectionArray(Section.ANSWER);

             if (answers.length == 0)
                return hostIp;
             else
                return answers[0].rdataToString();
       }

       public static void main(String args[]) throws IOException {
             long now = System.currentTimeMillis();
             System.out.println(reverseDns("192.222.1.13")); 
             System.out.println(reverseDns("208.201.239.36"));
             long after = System.currentTimeMillis();

             System.out.println((after - now) + " ms");
       }

    }


