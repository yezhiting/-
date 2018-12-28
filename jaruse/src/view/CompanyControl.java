package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import com.model.Announcement;
import com.usejdbc.*;

import javax.swing.*;


/**
 * @author: FLLFFL
 * @description: ��ɾ�Ĳ��û�
 */
public class CompanyControl extends JFrame{
    private final int COLUMN = 7;
    private final List<String> TITLES = Arrays.asList(
            "��˾id","��˾��", "ע����");
    private final List<String> TITLES2 = Arrays.asList(
    		"c_id","c_name", "c_regist");
    private Vector<Vector<String>> dataModel = new Vector<Vector<String>>();
    private QueryItem2 cid = new QueryItem2("��˾id��", 15);
    private QueryItem2 cname = new QueryItem2("��˾����", 15);
    private QueryItem2 cregist = new QueryItem2("ע���ˣ�", 15);
    private JButton changeBtn = new JButton("����");
    private JButton insertBtn = new JButton("��ӹ�˾");
    private JButton deleteBtn = new JButton("ɾ����˾");
    private JButton backBtn = new JButton("����");
    private JButton flashBtn = new JButton("��ѯ");
    private MyTable table;
    private Connection conn;
    JFrame f = new JFrame();
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	UserControl u = new UserControl();
    }

    //���캯�������𴴽��û����� 
    public CompanyControl() {
 

        Vector<String> titles = new Vector<String>(TITLES);
        table = new MyTable(dataModel, titles);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);


        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(cid);
        controlPanel.add(cname);
        controlPanel.add(cregist);
        controlPanel.add(insertBtn);
        controlPanel.add(deleteBtn);
        controlPanel.add(backBtn);
        controlPanel.add(flashBtn);
        controlPanel.add(changeBtn);
        controlPanel.setPreferredSize(new Dimension(0, 130));

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
        tablePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        tablePanel.add(table.getTableHeader());
        tablePanel.add(new JScrollPane(table));

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        //container.add(textarea, BorderLayout.NORTH);
        container.add(tablePanel, BorderLayout.CENTER);

        f.add(controlPanel, BorderLayout.NORTH);
        f.add(container, BorderLayout.CENTER);
        f.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.WEST);
        f.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.EAST);
        f.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.SOUTH);

        setActionListener();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(750, 500));
        f.setVisible(true);
        f.setResizable(false);
    }



    private void setActionListener() {
        //����ָ���������г����ݿ������������ļ�¼
        flashBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	String[] param = null;
                ArrayList<String> conditions = new ArrayList<String>();    
                Database db = new Database();
                //Announcement ac = new Announcement(fId, aDetail, aTime);
                String sql = "select * from company";        
                dataModel.clear();
                
                try {
                    ResultSet rs = db.executQuery(sql, param);
                    Vector<String> record;
                    while (rs.next()) {
                        record = new Vector<String>();
                        for (int i = 0; i < 3; i++) {
                            record.add(rs.getString(i + 1));
                        }
                        dataModel.add(record);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                //���±��
                table.validate();
                table.updateUI();
            }

        });
        //�����ݿ��в���һ���µļ�¼
        insertBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                String sql = "insert into company (c_id,c_name,c_regist) values (?,?,?)";
                //String aId = null;
                String cId = cid.getText();
                String cName = cname.getText();
                String cRegist = cregist.getText();
                


                Object[] param = {cId,cName,cRegist};
                Database db = new Database();
                db.executUpdate(sql, param);
                PreparedStatement ps;

                dataModel.add(new Vector<String>(Arrays.asList(
                		cId,cName,cRegist)));

                //���±��
                table.validate();
                table.updateUI();

            }

        });

        //���û���ǰѡ�еļ�¼�����ݿ���ɾ��
        deleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                String aId = dataModel.get(row).get(0);
                Object[] param = {aId};
                String sql = "delete from company where c_id = ?";
                Database db = new Database();
                //���ı�����ʾ SQL ����
                //textarea.setText(sql);
                db.executUpdate(sql, param);
                    dataModel.remove(row);
                    //���±��
                    table.validate();
                    table.updateUI();
            }
        });
        changeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                if (row == -1 || column == 0) return;
                Database db = new Database();
                String val = dataModel.get(row).get(column);
                String sid = dataModel.get(row).get(0);
                String sql = "update company set " + TITLES2.get(column) + " = ? where c_id = ?;";

                Object[] param = {val,sid};
                db.executUpdate(sql, param);
                PreparedStatement ps;
            }
        });
        
        backBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispose();
                MasterView mv = new MasterView();
                mv.setVisible(true);
                f.dispose();
            }
        });
    }

}


