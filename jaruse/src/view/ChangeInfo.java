/*
 * ChangeInfo.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.model.User;
import com.usejdbc.Database;

/**
 *
 * @author  __USER__
 */
public class ChangeInfo extends javax.swing.JFrame {
	User u = new User();

	/** Creates new form ChangeInfo */
	public ChangeInfo() {
		Init();
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("\u4e2a\u4eba\u4fe1\u606f\u7ba1\u7406");

		jLabel2.setText("\u7528\u6237\u540d");

		jLabel3.setText("\u5bc6\u7801");

		jLabel4.setText("\u8eab\u4efd\u8bc1");

		jTextField1.setText(u.getU_fname());

		jTextField2.setText(u.getU_pw());

		jTextField3.setText(u.getU_iden());

		jLabel5.setText("\u90ae\u7bb1");

		jTextField4.setText(u.getU_mail());

		jLabel6.setText("\u624b\u673a\u53f7");

		jTextField5.setText(u.getU_phone());

		jButton1.setText("\u4fdd\u5b58");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u53d6\u6d88");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

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
										.addGap(23, 23, 23)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jButton1)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel6)
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel1))
																		.addGap(
																				18,
																				18,
																				18)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jTextField1,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								174,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextField2)
																						.addComponent(
																								jTextField3)
																						.addComponent(
																								jTextField4)
																						.addComponent(
																								jTextField5))))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton2)
										.addContainerGap(49, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1)
										.addGap(36, 36, 36)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(31, 31, 31)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(30, 30, 30)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(34, 34, 34)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																jTextField4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(28, 28, 28)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(
																jTextField5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												46, Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton1)
														.addComponent(jButton2))
										.addGap(29, 29, 29)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
		TourView t = new TourView();
		t.setVisible(true);
	}

	private void Init() {

		String sql = "select * from user where u_id = ?";
		String id = String.valueOf(User.getI());
		String[] param = { id };
		Database db = new Database();
		ResultSet rs = db.executQuery(sql, param);

		try {
			if (rs.next()) {
				u.setU_fname(rs.getString(2));
				u.setU_pw(rs.getString(5));
				u.setU_iden(rs.getString(4));
				u.setU_mail(rs.getString(6));
				u.setU_phone(rs.getString(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String fname = this.jTextField1.getText();
		String pw = this.jTextField2.getText();
		String iden = this.jTextField3.getText();
		String mail = this.jTextField4.getText();
		String phone = this.jTextField5.getText();
		String sql = "update user set u_fname=?,u_pw=?,u_iden=?,u_mail=?,u_phone=? where u_id =?";
		Object[] param = {fname,pw,iden,mail,phone,User.getI()};
		Database db  = new Database();
		db.executUpdate(sql, param);
		JOptionPane.showMessageDialog(null, "修改成功", "提示",
				JOptionPane.PLAIN_MESSAGE);
		
		

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ChangeInfo().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	// End of variables declaration//GEN-END:variables

}