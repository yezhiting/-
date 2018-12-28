package com.server;

import java.io.*;
import java.net.*;
import java.sql.*;

import com.model.User;
import com.usejdbc.*;

public class Server implements Runnable {

	// 用户
	final int LOGIN = 1001; // 登陆
	final int SIGNUP = 1002;// 注册
	// 旅客
	final int SELECTUSERINFO = 1003;// 信息初始化
	final int CHANGEINFO = 1004; // 更改用户信息
	final int SEEANNO = 1005; // 查看公告
	final int SEEFILGHT = 1006; // 选航班
	final int SELECTSEAT = 1007; // 选飞机、座位
	final int QueryTicket = 1008; // 查看机票
	final int DelectTicket = 1009; // 退机票
	final int BuyTicket = 1010; // 买机票

	// 航空公司
	final int InsertFlight = 1011; // 增加航班
	final int DeleteFlight = 1012; // 删除航班
	final int UpdateFlight = 1013; // 更改航班
	final int QueryFlight = 1014; // 查看航班
	final int InsertPlane = 1015; // 增加飞机
	final int Deleteplane = 1016; // 删除飞机
	final int UpdatePlane = 1017; // 更改飞机
	final int QueryPlane = 1018; // 查看飞机

	// 管理员
	final int InsertComp = 1019; // 增加公司
	final int DeleteComp = 1020; // 删除公司
	final int UpdateComp = 1021; // 更改公司
	final int QueryComp = 1022; // 查看公司
	final int InsertUser = 1023; // 增加用户
	final int DeletaUser = 1024; // 删除用户
	final int UpdateUser = 1025; // 更改用户
	final int QueryUser = 1026; // 查看用户
	final int InsertAnno = 1027; // 发布公告
	final int DeleteAnno = 1028; // 删除公告

	ObjectInputStream ois;
	ObjectOutputStream oos;
	Socket s;

	public Server() throws IOException {

		ServerSocket ss = new ServerSocket(11111);
		while (true) {
			s = ss.accept();
			new Thread(this).start();
		}
	}

	public Server(int i) {
		System.out.println(1);
	}

	// 用户
	public void LOGIN() throws IOException, SQLException,

	ClassNotFoundException {
		User u = null;
		String fname = ois.readUTF();
		String pw = ois.readUTF();
		String  power = ois.readUTF();
		String[] param = {fname,pw,power};
		String sql = "select * from user where u_fname=? and u_pw=? and u_power = ?";
		Database db = new Database();
		ResultSet rs = db.executQuery(sql, param);
		if (rs.next()) {
			u = new User(rs.getInt(1), rs.getString(5), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8));
		}
		oos.writeObject(u);
		oos.flush();
		System.out.println("传输成功");

	}

	public void SIGNUP() throws IOException, SQLException,

	ClassNotFoundException {
		String u_fname = ois.readUTF();
		String u_pw = ois.readUTF();
		String u_tname = ois.readUTF();
		String u_iden = ois.readUTF();
		String u_mail = ois.readUTF();
		int u_phone = ois.readInt();

		oos.flush();

		System.out.println("传输成功");

	}

	// 旅客
	// 信息初始化
	private void SELECTUSERINFO() throws IOException {
		// TODO Auto-generated method stub
		String u_fname = ois.readUTF();
		String u_pw = ois.readUTF();
		String u_tname = ois.readUTF();
		String u_iden = ois.readUTF();
		String u_mail = ois.readUTF();
		int u_phone = ois.readInt();
		oos.flush();
		System.out.println("传输成功");
	}

	// 更改用户信息
	private void CHANGEINFO() throws IOException {
		String u_fname = ois.readUTF();
		String u_pw = ois.readUTF();
		String u_tname = ois.readUTF();
		String u_iden = ois.readUTF();
		String u_mail = ois.readUTF();
		int u_phone = ois.readInt();
		oos.flush();
		System.out.println("传输成功");
	}

	// 看公告
	private void SEEANNO() throws IOException {
		// TODO Auto-generated method stub
		String a_detail = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	// 选航班
	private void SEEFILGHT() throws IOException {
		// TODO Auto-generated method stub
		String f_sdate = ois.readUTF();
		String f_edate = ois.readUTF();
		String f_scity = ois.readUTF();
		String f_ecity = ois.readUTF();
		String f_stime = ois.readUTF();
		String f_etime = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	// 选飞机、座位
	private void SELECTSEAT() throws IOException {
		// TODO Auto-generated method stub
		String f_id = ois.readUTF();
		int p_id = ois.readInt();
		int p_seat = ois.readInt();
		oos.flush();
		System.out.println("传输成功");
	}

	// 查、退、买机票
	private void QueryTicket() throws IOException {
		// TODO Auto-generated method stub
		int u_id = ois.readInt();
		oos.flush();
		System.out.println("传输成功");
	}

	private void DelectTicket() throws IOException {
		// TODO Auto-generated method stub
		int t_id = ois.readInt();
		oos.flush();
		System.out.println("传输成功");
	}

	private void BuyTicket() throws IOException {
		// TODO Auto-generated method stub
		int p_id = ois.readInt();
		String t_scity = ois.readUTF();
		String t_ecity = ois.readUTF();
		String t_sdate = ois.readUTF();
		String t_edate = ois.readUTF();
		String f_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	// 增删改查航班
	private void InsertFlight() throws IOException {
		// TODO Auto-generated method stub
		String f_scity = ois.readUTF();
		String f_sdate = ois.readUTF();
		String f_stime = ois.readUTF();
		String f_ecity = ois.readUTF();
		String f_edate = ois.readUTF();
		String f_etime = ois.readUTF();
		String f_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void DeleteFlight() throws IOException {
		// TODO Auto-generated method stub
		String f_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void UpdateFlight() throws IOException {
		// TODO Auto-generated method stub
		String f_id = ois.readUTF();
		String getColumn = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void QueryFlight() throws IOException {
		// TODO Auto-generated method stub
		String f_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	// 增删改查飞机
	private void InsertPlane() throws IOException {
		// TODO Auto-generated method stub
		String p_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void Deleteplane() throws IOException {
		// TODO Auto-generated method stub
		String p_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void UpdatePlane() throws IOException {
		// TODO Auto-generated method stub
		String getColumn = ois.readUTF();
		String p_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void QueryPlane() throws IOException {
		// TODO Auto-generated method stub
		String p_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	// 增删改查公司
	private void InsertComp() throws IOException {
		// TODO Auto-generated method stub
		String c_id = ois.readUTF();
		String c_name = ois.readUTF();
		String cregist = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void DeleteComp() throws IOException {
		// TODO Auto-generated method stub
		String c_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void UpdateComp() throws IOException {
		// TODO Auto-generated method stub
		String getColumn = ois.readUTF();
		String c_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void QueryComp() throws IOException {
		// TODO Auto-generated method stub
		String c_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	// 增删改查用户
	private void InsertUser() throws IOException {
		// TODO Auto-generated method stub
		String u_fname = ois.readUTF();
		String u_tname = ois.readUTF();
		String u_iden = ois.readUTF();
		String u_pw = ois.readUTF();
		String u_mail = ois.readUTF();
		String u_phone = ois.readUTF();
		String u_power = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void DeletaUser() throws IOException {
		// TODO Auto-generated method stub
		String u_tname = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void UpdateUser() throws IOException {
		// TODO Auto-generated method stub
		String u_fname = ois.readUTF();
		String u_tname = ois.readUTF();
		String u_iden = ois.readUTF();
		String u_pw = ois.readUTF();
		String u_mail = ois.readUTF();
		String u_phone = ois.readUTF();
		String u_power = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void QueryUser() throws IOException {
		// TODO Auto-generated method stub
		String u_fname = ois.readUTF();
		String u_tname = ois.readUTF();
		String u_iden = ois.readUTF();
		String u_pw = ois.readUTF();
		String u_mail = ois.readUTF();
		String u_phone = ois.readUTF();
		String u_power = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	// 公告管理
	private void InsertAnno() throws IOException {
		// TODO Auto-generated method stub
		String a_id = ois.readUTF();
		String a_time = ois.readUTF();
		String adetail = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}

	private void DeleteAnno() throws IOException {
		// TODO Auto-generated method stub
		String a_id = ois.readUTF();
		oos.flush();
		System.out.println("传输成功");
	}


	public static void main(String[] args) {

		try {
			new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void run() {
		// TODO Auto-generated method stub
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			int i;
			i = ois.readInt();
			// 用户
			if (i == LOGIN) {
				LOGIN();
			}
			if (i == SIGNUP) {
				SIGNUP();
			}
			//旅客
			if (i == SELECTUSERINFO) {
				SELECTUSERINFO();
			}
			if (i == CHANGEINFO) {
				CHANGEINFO();
			}
			if (i == SEEANNO) {
				SEEANNO();
			}
			if (i == SEEFILGHT) {
				SEEFILGHT();
			}
			if (i == SELECTSEAT) {
				SELECTSEAT();
			}
			if (i == QueryTicket) {
				QueryTicket();
			}
			if (i == DelectTicket) {
				DelectTicket();
			}
			if (i == BuyTicket) {
				BuyTicket();
			}
			//航空公司
			if (i == InsertFlight) {
				InsertFlight();
			}
			if (i == DeleteFlight) {
				DeleteFlight();
			}
			if (i == UpdateFlight) {
				UpdateFlight();
			}
			if (i == QueryFlight) {
				QueryFlight();
			}
			if (i == InsertPlane) {
				InsertPlane();
			}
			if (i == Deleteplane) {
				Deleteplane();
			}
			if (i == UpdatePlane) {
				UpdatePlane();
			}
			if (i == QueryPlane) {
				QueryPlane();
			}
			//管理员
			if (i == InsertComp) {
				InsertComp();
			}
			if (i == DeleteComp) {
				DeleteComp();
			}
			if (i == UpdateComp) {
				UpdateComp();
			}
			if (i == QueryComp) {
				QueryComp();
			}
			if (i == InsertUser) {
				InsertUser();
			}
			if (i == DeletaUser) {
				DeletaUser();
			}
			if (i == UpdateUser) {
				UpdateUser();
			}
			if (i == QueryUser) {
				QueryUser();
			}
			if (i == InsertAnno) {
				InsertAnno();
			}
			if (i == DeleteAnno) {
				DeleteAnno();
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

}
