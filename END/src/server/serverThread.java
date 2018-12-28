package server;

import java.io.*; 
import java.net.Socket; 

public class serverThread extends Thread { 
  
  //�ͱ��߳���ص�Socket 
    Socket socket = null; 
    
    public serverThread(Socket socket){ 
    this.socket = socket; 
  } 
  
  //�߳�ִ�еĲ�������Ӧ�ͻ��˵����� 
  public void run(){ 
  
    InputStream is = null; 
    InputStreamReader isr = null; 
    BufferedReader br = null; 
  
    OutputStream os = null; 
    PrintWriter pw = null; 
    try { 
      //��ȡһ��������������ȡ�ͻ��˵���Ϣ 
      is = socket.getInputStream(); 
      isr = new InputStreamReader(is); //���ֽ���ת��Ϊ�ַ��� 
      br = new BufferedReader(isr);    //��ӻ��� 
      String info = null; 
      //ѭ����ȡ���� 
      while ((info = br.readLine()) != null){ 
    	  
        System.out.println("���Ƿ��������ͻ���˵: " +info); 
      
      } 
  
      socket.shutdownInput(); //�ر������� 
  
      //��ȡ���������Ӧ�ͻ��˵����� 
      os = socket.getOutputStream(); 
      pw = new PrintWriter(os); //��װΪ��ӡ�� 
      pw.write("��ӭ��"); 
      pw.flush(); //��������� 
  
    } catch (IOException e) { 
      e.printStackTrace(); 
    }finally { 
    	
        try { 
          //�ر���Դ 
          if (pw != null) 
            pw.close(); 
          if (os != null) 
            os.close(); 
          if (is != null) 
            is.close(); 
          if (isr != null) 
            isr.close(); 
          if (br != null) 
            br.close(); 
          if (socket != null) 
            socket.close(); 
        } catch (IOException e) { 
          e.printStackTrace(); 
        } 
    } 
  } 
}