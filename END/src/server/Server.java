package server; 
  
import java.io.*; 
import java.net.InetAddress; 
import java.net.ServerSocket; 
import java.net.Socket; 
  
public class Server { 
  
  public static void main(String[] args) { 
  
    try { 
      //����һ����������Socket,��ServerSocket, ָ���󶨵Ķ˿ڣ��������˶˿� 
      ServerSocket serverSocket = new ServerSocket(3306); 
      Socket socket = null; 
      //��¼�ͻ��˵����� 
      int count = 0; 
      System.out.println("***�����������������ȴ��ͻ��˵�����***"); 
      //ѭ�������ȴ��ͻ��˵����� 
      while (true){ 
        //����accept()������ʼ�������ȴ��ͻ��˵����� 
        socket = serverSocket.accept(); 
        //����һ���µ��߳� 
        serverThread serverThread = new serverThread(socket); 
        //�����߳� 
        serverThread.start(); 
  
        count++; //ͳ�ƿͻ��˵����� 
        
        System.out.println("�ͻ��˵�����: " + count); 
        InetAddress address = socket.getInetAddress(); 
        System.out.println("��ǰ�ͻ��˵�IP �� " + address.getHostAddress()); 
        
      } 
  
    } catch (IOException e) { 
      e.printStackTrace(); 
    } 
  } 
}