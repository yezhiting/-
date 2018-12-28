package com.server;

import java.io.*;
import java.net.*;

import com.model.*;

public class Client {

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

	ObjectOutputStream oos;
	ObjectInputStream ois;
	Socket s;

	// ���ӷ�����
	public Client() throws UnknownHostException, IOException {
		s = new Socket("127.0.0.1", 11111);
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
	}

	// �û�
	// ��¼
	public User LOGIN(String u_fname, String u_pw, String power)
			throws IOException, ClassNotFoundException {

		oos.writeInt(LOGIN);
		oos.flush();
		oos.writeUTF(u_fname);
		oos.flush();
		oos.writeUTF(u_pw);
		oos.flush();
		oos.writeUTF(power);
		oos.flush();

		return (User) ois.readObject();
	}

	public User SIGNUP(String u_fname, String u_pw, String u_tname,
			String u_iden, String u_mail, int u_phone) throws IOException,
			ClassNotFoundException {

		oos.writeInt(SIGNUP);
		oos.flush();
		oos.writeUTF(u_fname);
		oos.flush();
		oos.writeUTF(u_pw);
		oos.flush();
		oos.writeUTF(u_tname);
		oos.flush();
		oos.writeUTF(u_iden);
		oos.flush();
		oos.writeUTF(u_mail);
		oos.flush();
		oos.writeInt(u_phone);
		oos.flush();

		return (User) ois.readObject();
	}

	// �ÿ�
	// ��Ϣ��ʼ��
	public User SELECTUSERINFO(String u_fname, String u_tname, String u_iden,
			String u_mail, int u_phone) {

		return SELECTUSERINFO(u_fname, u_tname, u_iden, u_mail, u_phone);

	}

	// �����û���Ϣ
	public User CHANGEINFO(String u_fname, String u_pw, String u_tname,
			String u_iden, String u_mail, int u_phone) throws IOException,
			ClassNotFoundException {

		oos.writeInt(CHANGEINFO);
		oos.flush();
		oos.writeUTF(u_fname);
		oos.flush();
		oos.writeUTF(u_pw);
		oos.flush();
		oos.writeUTF(u_tname);
		oos.flush();
		oos.writeUTF(u_iden);
		oos.flush();
		oos.writeUTF(u_mail);
		oos.flush();
		oos.writeInt(u_phone);
		oos.flush();

		return (User) ois.readObject();

	}

	// ������
	public String SEEANNO(String a_detail) throws IOException,
			ClassNotFoundException {

		oos.writeInt(SEEANNO);
		oos.writeUTF(a_detail);
		oos.flush();

		return (String) ois.readUTF();
	}

	// ѡ����
	public User SEEFILGHT(String f_sdate, String f_edate, String f_scity,
			String f_ecity, String f_stime, String f_etime) throws IOException,
			ClassNotFoundException {

		oos.writeInt(SEEFILGHT);
		oos.writeUTF(f_sdate);
		oos.flush();
		oos.writeUTF(f_edate);
		oos.flush();
		oos.writeUTF(f_scity);
		oos.flush();
		oos.writeUTF(f_ecity);
		oos.flush();
		oos.writeUTF(f_stime);
		oos.flush();
		oos.writeUTF(f_etime);
		oos.flush();

		return (User) ois.readObject();

	}

	// ѡ�ɻ���λ
	public User SELECTSEAT(String f_id, int p_id, int p_seat)
			throws IOException, ClassNotFoundException {
		oos.writeInt(SELECTSEAT);
		oos.writeUTF(f_id);
		oos.flush();
		oos.writeInt(p_id);
		oos.flush();
		oos.writeInt(p_seat);
		oos.flush();

		return (User) ois.readObject();
	}

	// ����Ʊ
	public User QueryTicket(int u_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(QueryTicket);
		oos.writeInt(u_id);
		oos.flush();

		return (User) ois.readObject();
	}

	// �˻�Ʊ
	public String DelectTicket(int t_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(DelectTicket);
		oos.writeInt(t_id);
		oos.flush();
		return (String) ois.readUTF();

	}

	// ���Ʊ
	public User BuyTicket(int p_id, String t_scity, String t_ecity,
			String t_sdate, String t_edate, String f_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(BuyTicket);
		oos.writeInt(p_id);
		oos.flush();
		oos.writeUTF(t_scity);
		oos.flush();
		oos.writeUTF(t_ecity);
		oos.flush();
		oos.writeUTF(t_sdate);
		oos.flush();
		oos.writeUTF(t_edate);
		oos.flush();
		oos.writeUTF(f_id);
		oos.flush();

		return (User) ois.readObject();

	}

	// ���չ�˾
	// ��ɾ�Ĳ麽��
	public Flight InsertFlight(String f_scity, String f_sdate, String f_stime,
			String f_ecity, String f_edate, String f_etime, String f_id)
			throws IOException, ClassNotFoundException {
		oos.writeInt(InsertFlight);
		oos.flush();
		oos.writeUTF(f_scity);
		oos.flush();
		oos.writeUTF(f_sdate);
		oos.flush();
		oos.writeUTF(f_stime);
		oos.flush();
		oos.writeUTF(f_ecity);
		oos.flush();
		oos.writeUTF(f_edate);
		oos.flush();
		oos.writeUTF(f_etime);
		oos.flush();
		oos.writeUTF(f_id);
		oos.flush();
		return (Flight) ois.readObject();
	}

	public Flight DeleteFlight(String f_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(DeleteFlight);
		oos.flush();
		oos.writeUTF(f_id);
		oos.flush();
		return (Flight) ois.readObject();
	}

	public Flight UpdateFlight(String getColumn, String f_id)
			throws IOException, ClassNotFoundException {
		oos.writeInt(UpdateFlight);
		oos.flush();
		oos.writeUTF(f_id);
		oos.flush();
		oos.writeUTF(getColumn);
		oos.flush();
		return (Flight) ois.readObject();
	}

	public Flight QureyFlight(String f_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(QueryFlight);
		oos.flush();
		oos.writeUTF(f_id);
		oos.flush();
		return (Flight) ois.readObject();
	}

	// ��ɾ�Ĳ�ɻ�
	public Plane InsertPlane(String p_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(InsertPlane);
		oos.flush();
		oos.writeUTF(p_id);
		oos.flush();
		return (Plane) ois.readObject();
	}

	public Plane DeletePlane(String p_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(Deleteplane);
		oos.flush();
		oos.writeUTF(p_id);
		oos.flush();
		return (Plane) ois.readObject();
	}

	public Plane UpdatePlane(String getColumn, String p_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(UpdatePlane);
		oos.flush();
		oos.writeUTF(getColumn);
		oos.flush();
		oos.writeUTF(p_id);
		oos.flush();
		return (Plane) ois.readObject();
	}

	public Plane QueryPlane(String p_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(QueryPlane);
		oos.flush();
		oos.writeUTF(p_id);
		oos.flush();
		return (Plane) ois.readObject();
	}

	// ����Ա
	// ��ɾ�Ĳ鹫˾
	public Company InsertComp(String c_id, String c_name, String cregist)
			throws IOException, ClassNotFoundException {
		oos.writeInt(InsertComp);
		oos.flush();
		oos.writeUTF(c_id);
		oos.flush();
		oos.writeUTF(c_name);
		oos.flush();
		oos.writeUTF(cregist);
		oos.flush();
		return (Company) ois.readObject();
	}

	public Company DeleteComp(String c_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(DeleteComp);
		oos.flush();
		oos.writeUTF(c_id);
		oos.flush();
		return (Company) ois.readObject();
	}

	public Company UpdateComp(String getColumn, String c_id)
			throws IOException, ClassNotFoundException {
		oos.writeInt(UpdateComp);
		oos.flush();
		oos.writeUTF(c_id);
		oos.flush();
		oos.writeUTF(getColumn);
		oos.flush();
		return (Company) ois.readObject();
	}

	public Company QueryComp(String c_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(QueryComp);
		oos.flush();
		oos.writeUTF(c_id);
		oos.flush();
		return (Company) ois.readObject();
	}

	// ��ɾ�Ĳ��û�
	public User InsertUser(String u_fname, String u_tname, String u_iden,
			String u_pw, String u_mail, int u_phone, int u_power)
			throws IOException, ClassNotFoundException {
		oos.writeInt(InsertUser);
		oos.flush();
		oos.writeUTF(u_fname);
		oos.flush();
		oos.writeUTF(u_tname);
		oos.flush();
		oos.writeUTF(u_iden);
		oos.flush();
		oos.writeUTF(u_pw);
		oos.flush();
		oos.writeUTF(u_mail);
		oos.flush();
		oos.writeInt(u_phone);
		oos.flush();
		oos.writeInt(u_power);
		oos.flush();
		return (User) ois.readObject();

	}

	public User DeletaUser(String u_tname) throws IOException,
			ClassNotFoundException {
		oos.writeInt(DeletaUser);
		oos.flush();
		oos.writeUTF(u_tname);
		oos.flush();
		return (User) ois.readObject();
	}

	public User UpdateUser(String u_fname, String u_tname, String u_iden,
			String u_pw, String u_mail, int u_phone, int u_power)
			throws IOException, ClassNotFoundException {
		oos.writeInt(UpdateUser);
		oos.flush();
		oos.writeUTF(u_fname);
		oos.flush();
		oos.writeUTF(u_tname);
		oos.flush();
		oos.writeUTF(u_iden);
		oos.flush();
		oos.writeUTF(u_pw);
		oos.flush();
		oos.writeUTF(u_mail);
		oos.flush();
		oos.writeInt(u_phone);
		oos.flush();
		oos.writeInt(u_power);
		oos.flush();
		return (User) ois.readObject();
	}

	public User QueryUser(String u_fname, String u_tname, String u_iden,
			String u_pw, String u_mail, int u_phone, int u_power)
			throws IOException, ClassNotFoundException {
		oos.writeInt(QueryUser);
		oos.flush();
		oos.writeUTF(u_fname);
		oos.flush();
		oos.writeUTF(u_tname);
		oos.flush();
		oos.writeUTF(u_iden);
		oos.flush();
		oos.writeUTF(u_pw);
		oos.flush();
		oos.writeUTF(u_mail);
		oos.flush();
		oos.writeInt(u_phone);
		oos.flush();
		oos.writeInt(u_power);
		oos.flush();
		return (User) ois.readObject();
	}

	// ����ɾ����
	public Announcement InsertAnno(int a_id, String a_time, String adetail)
			throws IOException, ClassNotFoundException {
		oos.writeInt(InsertAnno);
		oos.flush();
		oos.writeInt(a_id);
		oos.flush();
		oos.writeUTF(a_time);
		oos.flush();
		oos.writeUTF(adetail);
		oos.flush();
		return (Announcement) ois.readObject();
	}

	public Announcement DeleteAnno(String a_id) throws IOException,
			ClassNotFoundException {
		oos.writeInt(DeleteAnno);
		oos.flush();
		oos.writeUTF(a_id);
		oos.flush();
		return (Announcement) ois.readObject();
	}

	public static void main(String[] args) {

		try {

			new Client().QueryTicket(1);
			System.out.println("�ͻ����������");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
