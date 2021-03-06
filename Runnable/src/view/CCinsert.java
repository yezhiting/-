/*
 * CCinsert.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.usejdbc.Database;

/**
 *
 * @author  __USER__
 */
public class CCinsert extends javax.swing.JFrame {

	/** Creates new form CCinsert */
	public CCinsert() {
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
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("\u6dfb\u52a0\u516c\u53f8");

		jLabel2.setText("\u516c\u53f8\u7f16\u53f7");

		jLabel3.setText("\u516c\u53f8\u540d");

		jLabel4.setText("\u6ce8\u518c\u4eba");

		jButton1.setText("\u6dfb\u52a0");
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
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				169,
																				169,
																				169)
																		.addComponent(
																				jLabel1))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				77,
																				77,
																				77)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel2)
																														.addComponent(
																																jLabel3)
																														.addComponent(
																																jLabel4))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												19,
																												Short.MAX_VALUE)
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																false)
																														.addComponent(
																																jTextField2,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																196,
																																Short.MAX_VALUE)
																														.addComponent(
																																jTextField1,
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																196,
																																Short.MAX_VALUE)
																														.addComponent(
																																jTextField3,
																																javax.swing.GroupLayout.Alignment.TRAILING)))
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jButton1)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												149,
																												Short.MAX_VALUE)
																										.addComponent(
																												jButton2)))))
										.addContainerGap(48, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(28, 28, 28)
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
										.addGap(44, 44, 44)
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
										.addGap(47, 47, 47)
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
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												29, Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton1)
														.addComponent(jButton2))
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String sql = "insert into company (c_id,c_name,c_regist) values (?,?,?)";

		String c_id = this.jTextField1.getText();
		String c_name = this.jTextField2.getText();
		String c_regist = this.jTextField3.getText();

		Object[] param = { c_id, c_name, c_regist };
		Database db = new Database();
		try {
			db.executUpdate(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps;

		JOptionPane.showMessageDialog(null, "插入成功", "提示",
				JOptionPane.PLAIN_MESSAGE);
		this.dispose();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		CControl cc = new CControl();
		cc.setVisible(true);
		this.dispose();
	}

	/**哪个界面开始登陆？登陆还没弄。。。。先弄登陆才可以啊
	 * 刚刚我修改了异常处理的部分，这部分应该全部都是抛出，最后界面处理，不然界面都是认为是对！！！
	 * 其次，你现在代码太耦合了，不知道你的删除删除在哪？还提示可以？？？？？
	 * 删除后应该刷新啊
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CCinsert().setVisible(true);
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
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	// End of variables declaration//GEN-END:variables

}