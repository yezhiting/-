package com.server;

import java.io.*;
import java.net.*;
import java.sql.*;

import com.model.User;
import com.usejdbc.*;

public class Server implements Runnable {

	// �û�
	final int LOGIN = 1001; // ��½
	final int SIGNUP = 1002;// ע��
	// �ÿ�
	final int SELECTUSERINFO = 1003;// ��Ϣ��ʼ��
	final int CHANGEINFO = 1004; // �����û���Ϣ
	final int SEEANNO = 1005; // �鿴����
	final int SEEFILGHT = 1006; // ѡ����
	final int SELECTSEAT = 1007; // ѡ�ɻ�����λ
	final int QueryTicket = 1008; // �鿴��Ʊ
	final int DelectTicket = 1009; // �˻�Ʊ
	final int BuyTicket = 1010; // ���Ʊ

	// ���չ�˾
	final int InsertFlight = 1011; // ���Ӻ���
	final int DeleteFlight = 1012; // ɾ������
	final int UpdateFlight = 1013; // ���ĺ���
	final int QueryFlight = 1014; // �鿴����
	final int InsertPlane = 1015; // ���ӷɻ�
	final int Deleteplane = 1016; // ɾ���ɻ�
	final int UpdatePlane = 1017; // ���ķɻ�
	final int QueryPlane = 1018; // �鿴�ɻ�

	// ����Ա
	final int InsertComp = 1019; // ���ӹ�˾
	final int DeleteComp = 1020; // ɾ����˾
	final int UpdateComp = 1021; // ���Ĺ�˾
	final int QueryComp = 1022; // �鿴��˾
	final int InsertUser = 1023; // �����û�
	final int DeletaUser = 1024; // ɾ���û�
	final int UpdateUser = 1025; // �����û�
	final int QueryUser = 1026; // �鿴�û�
	final int InsertAnno = 1027; // ��������
	final int DeleteAnno = 1028; // ɾ������

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

	// �û�
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
		System.out.println("����ɹ�");

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

		System.out.println("����ɹ�");

	}

	// �ÿ�
	// ��Ϣ��ʼ��
	private void SELECTUSERINFO() throws IOException {
		// TODO Auto-generated method stub
		String u_fname = ois.readUTF();
		String u_pw = ois.readUTF();
		String u_tname = ois.readUTF();
		String u_iden = ois.readUTF();
		String u_mail = ois.readUTF();
		int u_phone = ois.readInt();
		oos.flush();
		System.out.println("����ɹ�");
	}

	// �����û���Ϣ
	private void CHANGEINFO() throws IOException {
		String u_fname = ois.readUTF();
		String u_pw = ois.readUTF();
		String u_tname = ois.readUTF();
		String u_iden = ois.readUTF();
		String u_mail = ois.readUTF();
		int u_phone = ois.readInt();
		oos.flush();
		System.out.println("����ɹ�");
	}

	// ������
	private void SEEANNO() throws IOException {
		// TODO Auto-generated method stub
		String a_detail = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	// ѡ����
	private void SEEFILGHT() throws IOException {
		// TODO Auto-generated method stub
		String f_sdate = ois.readUTF();
		String f_edate = ois.readUTF();
		String f_scity = ois.readUTF();
		String f_ecity = ois.readUTF();
		String f_stime = ois.readUTF();
		String f_etime = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	// ѡ�ɻ�����λ
	private void SELECTSEAT() throws IOException {
		// TODO Auto-generated method stub
		String f_id = ois.readUTF();
		int p_id = ois.readInt();
		int p_seat = ois.readInt();
		oos.flush();
		System.out.println("����ɹ�");
	}

	// �顢�ˡ����Ʊ
	private void QueryTicket() throws IOException {
		// TODO Auto-generated method stub
		int u_id = ois.readInt();
		oos.flush();
		System.out.println("����ɹ�");
	}

	private void DelectTicket() throws IOException {
		// TODO Auto-generated method stub
		int t_id = ois.readInt();
		oos.flush();
		System.out.println("����ɹ�");
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
		System.out.println("����ɹ�");
	}

	// ��ɾ�Ĳ麽��
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
		System.out.println("����ɹ�");
	}

	private void DeleteFlight() throws IOException {
		// TODO Auto-generated method stub
		String f_id = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	private void UpdateFlight() throws IOException {
		// TODO Auto-generated method stub
		String f_id = ois.readUTF();
		String getColumn = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	private void QueryFlight() throws IOException {
		// TODO Auto-generated method stub
		String f_id = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	// ��ɾ�Ĳ�ɻ�
	private void InsertPlane() throws IOException {
		// TODO Auto-generated method stub
		String p_id = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	private void Deleteplane() throws IOException {
		// TODO Auto-generated method stub
		String p_id = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	private void UpdatePlane() throws IOException {
		// TODO Auto-generated method stub
		String getColumn = ois.readUTF();
		String p_id = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	private void QueryPlane() throws IOException {
		// TODO Auto-generated method stub
		String p_id = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	// ��ɾ�Ĳ鹫˾
	private void InsertComp() throws IOException {
		// TODO Auto-generated method stub
		String c_id = ois.readUTF();
		String c_name = ois.readUTF();
		String cregist = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	private void DeleteComp() throws IOException {
		// TODO Auto-generated method stub
		String c_id = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	private void UpdateComp() throws IOException {
		// TODO Auto-generated method stub
		String getColumn = ois.readUTF();
		String c_id = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	private void QueryComp() throws IOException {
		// TODO Auto-generated method stub
		String c_id = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	// ��ɾ�Ĳ��û�
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
		System.out.println("����ɹ�");
	}

	private void DeletaUser() throws IOException {
		// TODO Auto-generated method stub
		String u_tname = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
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
		System.out.println("����ɹ�");
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
		System.out.println("����ɹ�");
	}

	// �������
	private void InsertAnno() throws IOException {
		// TODO Auto-generated method stub
		String a_id = ois.readUTF();
		String a_time = ois.readUTF();
		String adetail = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
	}

	private void DeleteAnno() throws IOException {
		// TODO Auto-generated method stub
		String a_id = ois.readUTF();
		oos.flush();
		System.out.println("����ɹ�");
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
			// �û�
			if (i == LOGIN) {
				LOGIN();
			}
			if (i == SIGNUP) {
				SIGNUP();
			}
			//�ÿ�
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
			//���չ�˾
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
			//����Ա
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
