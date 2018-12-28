/*
 * SelectTicketView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.model.Flight;
import com.model.User;
import com.usejdbc.Database;

/**
 *
 * @author  __USER__
 */
public class SelectTicketView extends javax.swing.JFrame implements ActionListener {
	
	private JButton[] jb = new JButton[35];
	private JButton backBtn = new JButton("返回");
	/** Creates new form SelectTicketView */
	public SelectTicketView() {
		
		  this.setLayout(null);

			  for(int n=0;n<35;n++){
				  String s = String.valueOf(n+1);
				  jb[n]=new JButton(s);
				  jb[n].addActionListener(this);
			  }
			  for(int j = 0;j<10;j++){
				  jb[j].setBackground(Color.green);
			  }
			  for(int a = 10;a>=10&&a<35;a++){
				  jb[a].setBackground(Color.pink);
			  }
			  jb[0].setBounds(100, 100, 50, 20);
			  jb[1].setBounds(160, 100, 50, 20);
			  jb[2].setBounds(220, 100, 50, 20);
			  jb[3].setBounds(280, 100, 50, 20);
			  jb[4].setBounds(340, 100, 50, 20);
			  
			  jb[5].setBounds(100, 130, 50, 20);
			  jb[6].setBounds(160, 130, 50, 20);
			  jb[7].setBounds(220, 130, 50, 20);
			  jb[8].setBounds(280, 130, 50, 20);
			  jb[9].setBounds(340, 130, 50, 20);
			  
			  jb[10].setBounds(100, 160, 50, 20);
			  jb[11].setBounds(160, 160, 50, 20);
			  jb[12].setBounds(220, 160, 50, 20);
			  jb[13].setBounds(280, 160, 50, 20);
			  jb[14].setBounds(340, 160, 50, 20);
			  
			  jb[15].setBounds(100, 190, 50, 20);
			  jb[16].setBounds(160, 190, 50, 20);
			  jb[17].setBounds(220, 190, 50, 20);
			  jb[18].setBounds(280, 190, 50, 20);
			  jb[19].setBounds(340, 190, 50, 20);
			  
			  jb[20].setBounds(100, 220, 50, 20);
			  jb[21].setBounds(160, 220, 50, 20);
			  jb[22].setBounds(220, 220, 50, 20);
			  jb[23].setBounds(280, 220, 50, 20);
			  jb[24].setBounds(340, 220, 50, 20);
			  
			  jb[25].setBounds(100, 250, 50, 20);
			  jb[26].setBounds(160, 250, 50, 20);
			  jb[27].setBounds(220, 250, 50, 20);
			  jb[28].setBounds(280, 250, 50, 20);
			  jb[29].setBounds(340, 250, 50, 20);
			  
			  jb[30].setBounds(100, 280, 50, 20);
			  jb[31].setBounds(160, 280, 50, 20);
			  jb[32].setBounds(220, 280, 50, 20);
			  jb[33].setBounds(280, 280, 50, 20);
			  jb[34].setBounds(340, 280, 50, 20);
			  
			  for(int s = 0;s<35;s++){
			  this.add(jb[s]);
			  }
			  backBtn.setBounds(380, 20, 70, 30);
			  backBtn.addActionListener(this);
			  this.add(backBtn);
		  initComponents();
		  this.setSize(500,450);
	}
	
	
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(153, 255, 255));
		
		jLabel1.setText("\u822a\u73ed\uff1a"+Flight.getu());

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"201801", "Item 2", "Item 3", "Item 4" }));

		jLabel2.setText("\u98de\u673a");

		jButton1.setBackground(new java.awt.Color(204, 204, 204));
		jButton1.setText("\u5237\u65b0");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton7.setBackground(new java.awt.Color(204, 204, 204));
		jButton7.setText("\u8fd4\u56de");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1)
										.addGap(58, 58, 58)
										.addComponent(jLabel2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jComboBox1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(60, 60, 60)
										.addComponent(jButton1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												38, Short.MAX_VALUE)
										.addComponent(jButton7).addGap(35, 35,
												35)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(22, 22, 22).addGroup(
						layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jLabel2)
								.addComponent(jComboBox1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1).addComponent(jButton7))
						.addContainerGap(405, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	//初始化座位按钮
	public void Init() {
		String sql = "select * from plane where p_id=? and f_id=?";
		Database db = new Database();
		String getpid = (String) jComboBox1.getSelectedItem();
		String[] param = {getpid,Flight.getu()};
		int[] seat = new int[50];
		ResultSet rs = db.executQuery(sql, param);
		try {
			int i = 0;
			int j = 4;
			if (rs.next()) {
				System.out.println("有结果");
				for(i = 0;i<35;i++){
					seat[i] = rs.getInt(j);
					j++;
					if (seat[i] == 1) {
					jb[i].setBackground(Color.gray);
					}
				}
			
			}else{
				JOptionPane.showMessageDialog(null, "飞机不存在", "error",JOptionPane.PLAIN_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//刷新
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		Init();
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SelectTicketView().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton7;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	// End of variables declaration//GEN-END:variables

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Database db = new Database();
		String seat = null;
		String fid = Flight.getu();
		int tname = User.getI();
		String sdate = null;
		String edate = null;
		String scity = null;
		String ecity = null;
		String stime = null;
		String etime = null;
		//查询该航班的日期城市
		String sql2 = "select * from flight where f_id = ?";
		String[] param2 = {fid};
		ResultSet rs = db.executQuery(sql2, param2);
		try {
			while(rs.next()){
				sdate = rs.getString(2);
				edate = rs.getString(3);
				stime = rs.getString(6);
				etime = rs.getString(7);
				scity = rs.getString(4);
				ecity = rs.getString(5);
				
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql = "insert into ticket (f_id,t_seat,u_id,t_sdate,t_edate,t_stime,t_etime,t_scity,t_ecity,t_power) values (?,?,?,?,?,?,?,?,?,0)";
		
		
		Object source=e.getSource();
		if(source==jb[0]){
			seat = "1号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();
			JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[1]){
			seat = "2号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[2]){
			seat = "3号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[3]){
			seat = "4号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[4]){
			seat = "5号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[5]){
			seat = "6号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[6]){
			seat = "7号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[7]){
			seat = "8号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[8]){
			seat = "9号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[9]){
			seat = "10号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[10]){
			seat = "11号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[11]){
			seat = "12号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[12]){
			seat = "13号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[13]){
			seat = "14号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[14]){
			seat = "15号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[15]){
			seat = "16号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[16]){
			seat = "17号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[17]){
			seat = "18号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[18]){
			seat = "19号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[19]){
			seat = "20号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[20]){
			seat = "21号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[21]){
			seat = "22号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[22]){
			seat = "23号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[23]){
			seat = "24号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[24]){
			seat = "25号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[25]){
			seat = "26号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[26]){
			seat = "27号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[27]){
			seat = "28号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[28]){
			seat = "29号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[29]){
			seat = "30号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[30]){
			seat = "31号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[31]){
			seat = "32号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[32]){
			seat = "33号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[33]){
			seat = "34号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==jb[34]){
			seat = "35号";Object[] param = {fid,seat,tname,sdate,edate,stime,etime,scity,ecity};
			db.executUpdate(sql, param);
			this.dispose();JOptionPane.showMessageDialog(null, "预定成功,位置："+seat, "预定机票",JOptionPane.PLAIN_MESSAGE);
		}
		if(source==backBtn){
			this.dispose();
		}
	}

}