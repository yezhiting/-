package tool;

import info.Company;
import info.Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.JOptionPane;



	public class Client extends Thread{
		final int ELOGIN =1;
		final int CLOGIN =2;
		final int BUFF2IMG =3;
		final int TRANSACTION =4;
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
		
		ObjectOutputStream oos;
		ObjectInputStream ois;
		Socket s;
		public Client() throws UnknownHostException, IOException{
			s = new Socket("127.0.0.1",21213);
			 oos = new ObjectOutputStream(s.getOutputStream());
		     ois = new ObjectInputStream(s.getInputStream());
		}
		
		public  Employee Elogin(String ID,String pw) throws IOException, ClassNotFoundException{//员工登录
			oos.writeInt(ELOGIN);
			oos.flush();
			oos.writeUTF(ID);
			oos.flush();
			oos.writeUTF(pw);
			oos.flush();
			return (Employee)ois.readObject();	
		}
		public Company Clogin(String ID,String pw) throws IOException, ClassNotFoundException{//公司登陆
			oos.writeInt(CLOGIN);
			oos.flush();
			oos.writeUTF(ID);
			oos.flush();
			oos.writeUTF(pw);
			oos.flush();
			return (Company)ois.readObject();
		}
		public void buff2img(File f) throws IOException {//上传图片
            oos.writeInt(BUFF2IMG);
            oos.flush();
			FileInputStream fis = new FileInputStream(f);
		     OutputStream os = s.getOutputStream();
		     byte[] buf=new byte[1024];
				int len=0;
				while ((len=fis.read(buf))!=-1) {
					os.write(buf, 0, len);
				}
		     s.shutdownOutput();
		}
		public String Transaction(String ID,String name,String remarks) throws IOException, ClassNotFoundException{//交易
			oos.writeInt(TRANSACTION);
			oos.flush();
			oos.writeUTF(ID);
			oos.flush();
			oos.writeUTF(name);
			oos.flush();
			oos.writeUTF(remarks);
			oos.flush();
			return ois.readUTF();
			
		}
			public String MakeOperationNote(String ID, String name, String time,
				String operation) throws IOException {//记录员工操作记录
			// TODO Auto-generated method stub
			oos.writeInt(NOTE);
			oos.flush();
			oos.writeUTF(ID);
			oos.flush();
			oos.writeUTF(name);
			oos.flush();
			oos.writeUTF(operation);
			oos.flush();
			return ois.readUTF();
		}
			
			public String Operation(String ID , String name, String time, String operation) throws IOException{//查看员工操作记录
				oos.writeInt(OPERATION);
				oos.flush();
				oos.writeUTF(ID);
				oos.flush();
				oos.writeUTF(name);
				oos.flush();
				oos.writeUTF(time);
				oos.flush();
				oos.writeUTF(operation);
				oos.flush();
				return ois.readUTF();
			}
			
			public List showVip() throws IOException, ClassNotFoundException{//查看会员
				oos.writeInt(SHOWVIP);
				oos.flush();
				return (List) ois.readObject();
			}
			
			public float addMoney(String id,float addmoney) throws IOException{//会员卡充值
				oos.writeInt(ADDMON);
				oos.flush();
				oos.writeUTF(id);
				oos.flush();
				oos.writeFloat(addmoney);
				oos.flush();
				return ois.readFloat();
				
			}
			
			public String downVip(String id) throws IOException{//删除会员 
					oos.writeInt(DOWNVIP);
					oos.flush();
					oos.writeUTF(id);
					oos.flush();
					return ois.readUTF();
			}
		
			public String getTicket(String Tid, String Fname, String Hname, String Time, String Seat, float Price) throws IOException{//购票
				oos.writeInt(GETTICKET);
				oos.flush();
				oos.writeUTF(Tid);
				oos.flush();
				oos.writeUTF(Fname);
				oos.flush();
				oos.writeUTF(Hname);
				oos.flush();
				oos.writeUTF(Time);
				oos.flush();
				oos.writeUTF(Seat);
				oos.flush();
				oos.writeFloat(Price);
				oos.flush();
				return ois.readUTF();
			}
			public String chooseSeat(String HID, String SeatID, String isSelect)throws IOException{//选座
				oos.writeInt(CHOOSESEAT);
				oos.flush();
				oos.writeUTF(HID);
				oos.flush();
				oos.writeUTF(SeatID);
				oos.flush();
				oos.writeUTF(isSelect);
				oos.flush();
				return ois.readUTF();
			}
			public String getCommodity(String Cid, String Cname, String cover, String content, float Price, String inventory) throws IOException{//购买商品
				oos.writeInt(GETCOMMODITY);
				oos.flush();
				oos.writeUTF(Cid);
				oos.flush();
				oos.writeUTF(Cname);
				oos.flush();
				oos.writeUTF(cover);
				oos.flush();
				oos.writeUTF(content);
				oos.flush();
				oos.writeFloat(Price);
				oos.flush();
				oos.writeUTF(inventory);
				oos.flush();
				return ois.readUTF();
			}
			public String addCard(String ID) throws IOException{//会员卡办理
				oos.writeInt(ADDCARD);
				oos.flush();
				oos.writeUTF(ID);
				oos.flush();
				return ois.readUTF();
			}

			public String setNewFilm(String Fid, String Fname, String cover, float price) throws IOException{//电影上新
				oos.writeInt(SETNEWFILM);
				oos.flush();
				oos.writeUTF(Fid);
				oos.flush();
				oos.writeUTF(Fname);
				oos.flush();
				oos.writeUTF(cover);
				oos.flush();
				oos.writeFloat(price);
				oos.flush();
				return ois.readUTF();
			}
			
			public String manageHall(String Hid, String size)throws IOException{//管理影厅
				oos.writeInt(MANAGEHALL);
				oos.flush();
				oos.writeUTF(Hid);
				oos.flush();
				oos.writeUTF(size);
				oos.flush();
				return ois.readUTF();
			}
			public String DownFilm(String Fid, String Fname, float price) throws IOException{//下架电影
						oos.writeInt(DOWNFILM);
						oos.flush();
						oos.writeUTF(Fid);
						oos.flush();
						oos.writeUTF(Fname);
						oos.flush();
						oos.writeFloat(price);
						oos.flush();
						return ois.readUTF();
			}
			public String getVip(String ID, String name)throws IOException{//查找会员
				oos.writeInt(GETVIP);
				oos.writeUTF(name);
				oos.flush();
				return ois.readUTF();
			}
			public String ShowFilm(String Fid, String Fname, String content, String cover, float price)throws IOException{//查看电影
				oos.writeInt(SHOWFILM);
				oos.flush();
				oos.writeUTF(Fid);
				oos.flush();
				oos.writeUTF(Fname);
				oos.flush();
				oos.writeUTF(content);
				oos.flush();
				oos.writeUTF(cover);
				oos.flush();
				oos.writeFloat(price);
				oos.flush();
				return ois.readUTF();
			}
			public String ShowCommodity(String Cid,String Cname, String cover, String content, float Price, String inventory) throws IOException{//查看商品
				oos.writeInt(SHOWCOMMDITY);
				oos.flush();
				oos.writeUTF(Cid);
				oos.flush();
				oos.writeUTF(Cname);
				oos.flush();
				oos.writeUTF(cover);
				oos.flush();
				oos.writeUTF(content);
				oos.flush();
				oos.writeFloat(Price);
				oos.flush();
				oos.writeUTF(inventory);
				oos.flush();
				return ois.readUTF();
			}
			public String DeleteCommodity(String Cid, String Cname, float price) throws IOException{//删除商品
					oos.writeInt(DELETECOMMODITY);
					oos.flush();
					oos.writeUTF(Cid);
					oos.flush();
					oos.writeUTF(Cname);
					oos.flush();
					oos.writeFloat(price);
					oos.flush();
				    return ois.readUTF();
			}
				public String setNewCommodity(String Cid, String Cname, float price, String cover)throws IOException{//商品上新
					int setNewCommodity;
					oos.writeInt(SETNEWCOMMODITY);
					oos.flush();
					oos.writeUTF(cover);
					oos.flush();
					oos.writeUTF(Cid);
					oos.flush();
					oos.writeUTF(Cname);
					oos.flush();
					oos.writeFloat(price);
					oos.flush();
					return ois.readUTF();
				}
				public String Trailer(String Path,String TID, String TNAME)throws IOException{//预告片
					oos.writeInt(TRAILER);
					oos.flush();
					oos.writeUTF(Path);
					oos.flush();
					oos.writeUTF(TID);
					oos.flush();
					oos.writeUTF(TNAME);
					oos.flush();
					return ois.readUTF();
				}
				
				public static void main(String[] args) {
					try {
						//File f = new File("E:\\大二（上）\\程序设计实训\\广告.png");
						new Client().getVip("1", "1");
						System.out.println("客户端完成连接");
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} }
			}
	
