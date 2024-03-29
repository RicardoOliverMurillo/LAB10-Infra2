// File Name GreetingClient.java
import java.net.*;
import java.io.*;

public class Cliente {

   public static void main(String [] args) {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      
      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket socket = new Socket(serverName, port);
         
         System.out.println("Just connected to " + socket.getRemoteSocketAddress());
         OutputStream outToServer = socket.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         
         out.writeUTF("Hello from " + socket.getLocalSocketAddress());
         InputStream inFromServer = socket.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         
         System.out.println("Server says " + in.readUTF());
         socket.close();
      } 
      catch (UnknownHostException e) {
          System.err.println("I can't find " + e  );
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }
}