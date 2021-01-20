import java.io.*;
import java.net.*;

public class Task1client{
public static void main(String args[]) throws IOException,ClassNotFoundException{

Socket c=new Socket("localhost",1000);

BufferedReader bis=new BufferedReader(new InputStreamReader(c.getInputStream()));

System.out.println(bis.readLine());


bis.close();
c.close();

}
}