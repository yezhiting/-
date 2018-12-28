package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import com.usejdbc.*;

import javax.swing.*;


public class FlightControl extends JFrame {
	private final int COLUMN = 7;
	private final List<String> TITLES = Arrays.asList( "�����ص�", "��������", "����ʱ��", "�����ַ", "��������", "����ʱ��", "�����");
	private final List<String> TITLES2 = Arrays.asList("f_scity", "f_sdate", "f_stime", "f_ecity", "f_edate", "f_etime", "f_id");
	private Vector<Vector<String>> dataModel = new Vector<Vector<String>>();

	private QueryItem f_scity = new QueryItem("�����ص㣺", 10);
	private QueryItem f_sdate = new QueryItem("�������ڣ�", 10);
	private QueryItem f_stime = new QueryItem("����ʱ�䣺", 10);
	private QueryItem f_ecity = new QueryItem("�����ַ��", 10);
	private QueryItem f_edate = new QueryItem("�������ڣ�", 10);
	private QueryItem f_etime = new QueryItem("����ʱ�䣺", 10);
	private QueryItem f_id = new QueryItem("����ţ�", 10);

	private JButton queryBtn = new JButton("��ѯ");
	private JButton saveBtn = new JButton("�޸�");
	private JButton insertBtn = new JButton("���");
	private JButton deleteBtn = new JButton("ɾ��");
	private JButton backBtn = new JButton("����");
	// private JTextArea textarea = new JTextArea(5, 5);
	private MyTable table;
	private Connection conn;
	Frame f = new Frame();
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		FlightControl frame = new FlightControl();
	
	}

	// ���캯�������𴴽��û�����
	public FlightControl() {
		super();

		Vector<String> titles = new Vector<String>(TITLES);
		table = new MyTable(dataModel, titles);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(5).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setPreferredWidth(10);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		controlPanel.add(f_scity);
		controlPanel.add(f_sdate);
		controlPanel.add(f_stime);
		controlPanel.add(f_ecity);
		controlPanel.add(f_edate);
		controlPanel.add(f_etime);
		controlPanel.add(f_id);

		controlPanel.add(queryBtn);
		controlPanel.add(saveBtn);
		controlPanel.add(insertBtn);
		controlPanel.add(deleteBtn);
		controlPanel.add(backBtn);
		controlPanel.setPreferredSize(new Dimension(0, 130));

		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
		tablePanel.add(Box.createRigidArea(new Dimension(0, 20)));
		tablePanel.add(table.getTableHeader());
		tablePanel.add(new JScrollPane(table));

		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		// container.add(textarea, BorderLayout.NORTH);
		container.add(tablePanel, BorderLayout.CENTER);

		f.add(controlPanel, BorderLayout.NORTH);
		f.add(container, BorderLayout.CENTER);
		f.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.WEST);
		f.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.EAST);
		f.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.SOUTH);

		setActionListener();
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setMinimumSize(new Dimension(750, 500));
		f.setVisible(true);
		f.setResizable(false);
	}

	private void setActionListener() {
		// ����ָ���������г����ݿ������������ļ�¼
		queryBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] param = new String[1];
				ArrayList<String> conditions = new ArrayList<String>();

				int j = 0;
				if (f_id.isSelected()) {
					conditions.add("(f_id = ?)");
					param[j] = f_id.getText();
					j++;
					System.out.println("1");
					System.out.println(param[0]);
				} else {
					param = null;
					System.out.println("0");
				}

				Database db = new Database();
				StringBuilder sb = new StringBuilder();
				sb
						.append("select f_scity ,f_sdate ,f_stime ,f_ecity ,f_edate ,f_etime ,f_id from flight ");
				int length = conditions.size();
				if (length != 0)
					sb.append(" where ");
				for (int i = 0; i < length; i++) {
					sb.append(conditions.get(i));
					if (i != length - 1)
						sb.append(" AND ");
				}
				sb.append(";");
				String queryString = sb.toString();
				// textarea.setText(queryString);
				dataModel.clear();

				// Statement stmt;
				try {
					// stmt = conn.createStatement();
					ResultSet rs = db.executQuery(queryString, param);
					Vector<String> record;
					while (rs.next()) {
						record = new Vector<String>();
						for (int i = 0; i < COLUMN; i++) {
							record.add(rs.getString(i + 1));
						}
						dataModel.add(record);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				// ���±��
				table.validate();
				table.updateUI();
			}

		});

		// �����û���ǰѡ�еĵ�Ԫ���޸����ݿ��ж�Ӧ��¼�Ķ�Ӧ�ֶ�
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				if (row == -1 || column == 0)
					return;
				Database db = new Database();
				String val = dataModel.get(row).get(column);
				String sid = dataModel.get(row).get(6);
				String sql = "update flight set " + TITLES2.get(column)
						+ " = ? where f_id = ?;";

				Object[] param = { val, sid };
				db.executUpdate(sql, param);

			}
		});

		// �����ݿ��в���һ���µļ�¼
		insertBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "insert into flight values (?,?,?,?,?,?,?)";

				String fscity = f_scity.getText();
				String fsdate = f_sdate.getText();
				String fstime = f_stime.getText();
				String fecity = f_ecity.getText();
				String fedate = f_edate.getText();
				String fetime = f_etime.getText();
				String fid = f_id.getText();
				
				Object[] param = { fscity, fsdate, fstime, fecity, fedate, fetime ,fid };
				Database db = new Database();
				
				String sql1 = "INSERT INTO flight (f_scity, f_sdate, f_stime, f_ecity, f_edate, f_etime, f_id) VALUES (?,?,?,?,?,?,?)";
				
				db.executUpdate(sql1, param);
				PreparedStatement ps;

				dataModel.add(new Vector<String>(Arrays.asList( fid, fsdate , fedate , fscity , fecity, fstime, fetime )));

				// ���±��
				table.validate();
				table.updateUI();
			}
		});

		// ���û���ǰѡ�еļ�¼�����ݿ���ɾ��
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String fid = dataModel.get(row).get(6);
				Object[] param = { fid };
				String sql = "delete from flight where f_id = ?";
				Database db = new Database();
				// ���ı�����ʾ SQL ����
				// textarea.setText(sql);
				db.executUpdate(sql, param);
				dataModel.remove(row);
				// ���±��
				table.validate();
				table.updateUI();
			}
		});
		
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				CompanyView cv = new CompanyView();
				cv.setVisible(true);
			}
		});
	}

}