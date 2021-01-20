import java.io.*;
import java.net.*;

public class Task1server{
public static void main(String args[]) throws IOException{

ServerSocket s=new ServerSocket(1000);

System.out.println("Waiting for Client connection");

Socket c=s.accept();
System.out.println("Connection established");
System.out.println("-----------------------------------------------------------");

PrintStream ps = new PrintStream(c.getOutputStream());

String msg="Message from Server machine";

ps.write(msg.getBytes());

c.close();

}
}

