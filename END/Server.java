package tool;

import info.Company;
import info.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tool.Datahandle;
import info.Employee;



public class Server implements Runnable{
	final int ELOGIN =1;
	final int CLOGIN =2;
	final int BUFF2IMG = 3;
	final int TRANSACTION = 4;
	final int NOTE = 5;
	final int ADDMON = 6;
	final int SHOWVIP = 7;
	final int DOWNVIP = 8;
	final int GETTICKET = 9;
	final int OPERATION = 10;
	final int DOWNFILM = 11;
	final int CHOOSESEAT = 12;
	final int GETCOMMODITY = 13;
	final int ADDCARD = 14;
	final int SETNEWFILM = 15;
	final int SHOWFILM = 16;
	final int MANAGEHALL = 17;
	final int SHOWCOMMDITY = 18;
	final int DELETECOMMODITY = 19;
	final int SETNEWCOMMODITY = 20;
	final int TRAILER = 21;
	final int GETVIP = 22;
	
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Socket s;
	public Server() throws IOException, ClassNotFoundException, SQLException {
		
		 ServerSocket ss = new ServerSocket(21213);
		 while(true){
		 s = ss.accept();
		 new Thread(this).start();
		 }
		}
	
	public Server(int i){System.out.println(1);}
public void  ELogin() throws IOException, SQLException, ClassNotFoundException{//员工登录
	String ID = ois.readUTF();
	String pw = ois.readUTF();
	String sql = "select * from employee where ID ='"+ID+"' and pw ='"+pw+"'";
	ResultSet rs = Datahandle.getStatement().executeQuery(sql);
	Employee e=null;
	if(rs.next()){
		e =new Employee(rs.getString(1),rs.getString(2),rs.getString(3));
		
} 
	oos.writeObject(e);
		 oos.flush();
		 System.out.println("传输成功");
		 }
public void CLogin() throws IOException, SQLException, ClassNotFoundException{//公司登录
	String ID = ois.readUTF();
	String pw =ois.readUTF();
	String sql = "select * from company where ID ='"+ID+"' and pw ='"+pw+"'";
	ResultSet rs = Datahandle.getStatement().executeQuery(sql);
	Company cm=null;
	if(rs.next()){
		cm =new Company(rs.getString(1),rs.getString(2));
		
} 
	oos.writeObject(cm); 
		 oos.flush();
}
public void buff2img() throws IOException{//上传图片
	File f = new File("e:/"+"img"+".jpg");
	 FileOutputStream fos = new FileOutputStream(f);
	 InputStream is =s.getInputStream();
	 byte[] buf=new byte[1024];
		int len=0;
		while ((len=is.read(buf))!=-1) {
			fos.write(buf, 0, len);
			}
		fos.close();
		s.close();
}
private void manageHall()throws IOException {//管理影厅
	// TODO Auto-generated method stub
	String Hid = ois.readUTF();
	String size = ois.readUTF();
	
	oos.flush();
	System.out.println("传输成功");
}

private void ShowFilm() throws IOException{//查看电影
	// TODO Auto-generated method stub
	String Fid = ois.readUTF();
	String Fname = ois.readUTF();
	String cover = ois.readUTF();
	String content = ois.readUTF();
	float Price = ois.readFloat();
	
	oos.flush();
	System.out.println("传输成功");
}

private void setNewFilm() throws IOException{//电影上新
	// TODO Auto-generated method stub
	String Fid = ois.readUTF();
	String Fname = ois.readUTF();
	String cover = ois.readUTF();
	float Price = ois.readFloat();
	
	oos.flush();
	System.out.println("传输成功");
}

private void DowmFilm()throws IOException {//下架电影
	// TODO Auto-generated method stub
	String Fid = ois.readUTF();
	String Fname = ois.readUTF();
	float Price = ois.readFloat();
	
	oos.flush();
	System.out.println("传输成功");
}

public void getTicket()throws IOException{//购票
	String Tid = ois.readUTF();
	String Fname = ois.readUTF();
	String Hname = ois.readUTF();
	String Seat = ois.readUTF();
	String Time = ois.readUTF();
	float Price = ois.readFloat();
	
	oos.flush();
	System.out.println("传输成功");
}

private void chooseSeat()throws IOException {//选座
	// TODO Auto-generated method stub
	String HID = ois.readUTF();
	String SeatID = ois.readUTF();
	String isSelect = ois.readUTF();
	
	oos.flush();
	System.out.println("传输成功");
}

private void setNewCommodity()throws IOException {//商品上新
	// TODO Auto-generated method stub
	String Cid = ois.readUTF();
	String Cname = ois.readUTF();
	float Price = ois.readFloat();
	String cover = ois.readUTF();
	
	oos.flush();
	System.out.println("传输成功");
}

private void DeleteCommodity()throws IOException {//删除商品
	// TODO Auto-generated method stub
	String Cid = ois.readUTF();
	String Cname = ois.readUTF();
	float Price = ois.readFloat();
	
	oos.flush();
	System.out.println("传输成功");
}

private void ShowCommodity()throws IOException {//查看商品
	// TODO Auto-generated method stub
	String Cid = ois.readUTF();
	String Cname = ois.readUTF();
	String cover = ois.readUTF();
	String content = ois.readUTF();
	String inventory = ois.readUTF();
	float Price = ois.readFloat();
	
	oos.flush();
	System.out.println("传输成功");
}

private void getCommodity()throws IOException {//购买商品
	// TODO Auto-generated method stub
	String Cid = ois.readUTF();
	String Cname = ois.readUTF();
	String cover = ois.readUTF();
	String content = ois.readUTF();
	String inventory = ois.readUTF();
	float Price = ois.readFloat();
	
	oos.flush();
	System.out.println("传输成功");
}

private void addCard() throws IOException{//会员卡办理
	// TODO Auto-generated method stub
	String ID = ois.readUTF();
	
	oos.flush();
	System.out.println("传输成功");
}

private void Operation()throws IOException {//查看员工操作记录
	// TODO Auto-generated method stub
	String ID = ois.readUTF();
	String name = ois.readUTF();
	String time = ois.readUTF();
	String operation = ois.readUTF();
	
	oos.flush();
	System.out.println("传输成功");
}

public void addMoney(){//客户卡充值
	try {
		String id = ois.readUTF();
		float addmon = ois.readFloat();
		String sql1="select money from vip where ID ='"+id+"'";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql1);
		if(rs.next()){
			addmon = addmon + rs.getFloat("money");
			String sql2="update vip set money='"+addmon+"'where ID ='"+id+"'";
			Datahandle.getStatement().executeUpdate(sql2);
		}else{
			addmon = -1;
		}
		oos.writeFloat(addmon);
		oos.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void TRANSACTION(){//交易
	try {
		String id = ois.readUTF();
		String name = ois.readUTF();
		String remarks = ois.readUTF();
		String sql = "insert into vip values('"+id+"','"+name+"','"+remarks+"','0')";
		Datahandle.getStatement().executeUpdate(sql);
		oos.writeUTF("ok");
		oos.flush();
		s.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void MakeOpreationNote() throws IOException, SQLException, ClassNotFoundException{//记录员工操作记录
	String id = ois.readUTF();
	String name = ois.readUTF();
	String time = ois.readUTF();
	String operation = ois.readUTF();
	String sql = "insert into operation values('"+id+"','"+name+"','"+time+"','"+operation+"','"+0+")";
	Datahandle.getStatement().executeUpdate(sql);
	oos.writeUTF("okay");
	oos.flush();
	s.close();
}

public void getVip()throws IOException{//查找会员
	String name = ois.readUTF();

oos.flush();
System.out.println("传输成功");
}

public void showvip(){//查看会员
	try {
		String sql = "select * from vip";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List viplist = new ArrayList();
		while(rs.next()){
			String id = rs.getString(1);
			String name = rs.getString(2);
			String remasks = rs.getString(3);
			float money = rs.getFloat(4);
			Object[] vip = {id,name,remasks,money};
			viplist.add(vip);
		}
		oos.writeObject(viplist);
		oos.flush();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	

	public void downvip(){//删除会员
		try {
			String id = ois.readUTF();
			String sql ="delete from vip where id='"+id+"'";
			Datahandle.getStatement().executeUpdate(sql);
			oos.writeUTF("OK");
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Trailer() throws IOException{//预告片
		// TODO Auto-generated method stub
		String Path = ois.readUTF();
		String TID = ois.readUTF();
		String TNAME = ois.readUTF();
		
		oos.flush();
		System.out.println("传输成功");
	}
	
	
	
	
	public void run() {
		// TODO Auto-generated method stub
		 try {
			ois = new ObjectInputStream(s.getInputStream()); 
			 oos = new ObjectOutputStream(s.getOutputStream());
			 int i ;
			 i = ois.readInt();
			 if(i==ELOGIN){
				 ELogin();		
			 }
			 if(i==CLOGIN){
				 CLogin();
			 }
			 if(i==BUFF2IMG){
				 buff2img(); 
			 }
			if (i==TRANSACTION){
				TRANSACTION();
			}
			if(i==NOTE){
				MakeOpreationNote();
			}
			if(i==ADDMON){
				addMoney();
			}
			if(i==SHOWVIP){
				showvip();
			}
			if(i==DOWNVIP){
				downvip();
			}
			if(i==GETTICKET){
				getTicket();
			}
			if(i==OPERATION){
				Operation();
			}
			if(i==DOWNFILM){
				DowmFilm();
			}
			if(i==CHOOSESEAT){
				chooseSeat();
			}
			if(i==GETCOMMODITY){
				getCommodity();
			}
			if(i==ADDCARD){
				addCard();
			}
			if(i==SETNEWFILM){
				setNewFilm();
			}
			if(i==SHOWFILM){
				ShowFilm();
			}
			if(i==MANAGEHALL){
				manageHall();
			}
			if(i==SHOWCOMMDITY){
				ShowCommodity();
			}
			if(i==DELETECOMMODITY){
				DeleteCommodity();
			}
			if(i==SETNEWCOMMODITY){
				setNewCommodity();
			}
			if(i==TRAILER){
				Trailer();
			}
			if(i==GETVIP){
				getVip();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 	
	}

	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
