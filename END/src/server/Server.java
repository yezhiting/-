package server; 
  
import java.io.*; 
import java.net.InetAddress; 
import java.net.ServerSocket; 
import java.net.Socket; 
  
public class Server { 
  
  public static void main(String[] args) { 
  
    try { 
      //创建一个服务器端Socket,即ServerSocket, 指定绑定的端口，并监听此端口 
      ServerSocket serverSocket = new ServerSocket(3306); 
      Socket socket = null; 
      //记录客户端的数量 
      int count = 0; 
      System.out.println("***服务器即将启动，等待客户端的链接***"); 
      //循环监听等待客户端的链接 
      while (true){ 
        //调用accept()方法开始监听，等待客户端的链接 
        socket = serverSocket.accept(); 
        //创建一个新的线程 
        serverThread serverThread = new serverThread(socket); 
        //启动线程 
        serverThread.start(); 
  
        count++; //统计客户端的数量 
        
        System.out.println("客户端的数量: " + count); 
        InetAddress address = socket.getInetAddress(); 
        System.out.println("当前客户端的IP ： " + address.getHostAddress()); 
        
      } 
  
    } catch (IOException e) { 
      e.printStackTrace(); 
    } 
  } 
}