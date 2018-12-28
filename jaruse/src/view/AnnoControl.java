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
public class AnnoControl extends JFrame{
    private final int COLUMN = 7;
    private final List<String> TITLES = Arrays.asList(
            "����","�����", "ʱ��", "����");
    private final List<String> TITLES2 = Arrays.asList(
    		"a_id","f_id", "a_time", "a_detail");
    private Vector<Vector<String>> dataModel = new Vector<Vector<String>>();
    private QueryItem2 fid = new QueryItem2("����ţ�", 15);
    private QueryItem2 atime = new QueryItem2("ʱ�䣺", 15);
    private QueryItem2 adetail = new QueryItem2("���飺", 17);
    private JButton insertBtn = new JButton("��ӹ���");
    private JButton deleteBtn = new JButton("ɾ������");
    private JButton backBtn = new JButton("����");
    private JButton flashBtn = new JButton("ˢ��");
    private MyTable table;
    private Connection conn;
    JFrame f = new JFrame();
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	UserControl u = new UserControl();
    }

    //���캯�������𴴽��û����� 
    public AnnoControl() {
 

        Vector<String> titles = new Vector<String>(TITLES);
        table = new MyTable(dataModel, titles);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);


        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(fid);
        controlPanel.add(atime);
        controlPanel.add(adetail);
        controlPanel.add(insertBtn);
        controlPanel.add(deleteBtn);
        controlPanel.add(backBtn);
        controlPanel.add(flashBtn);
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
                String sql = "select * from announcement";        
                dataModel.clear();
                
                try {
                    ResultSet rs = db.executQuery(sql, param);
                    Vector<String> record;
                    while (rs.next()) {
                        record = new Vector<String>();
                        for (int i = 0; i < 4; i++) {
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
            	
                String sql = "insert into announcement (f_id,a_time,a_detail) values (?,?,?)";
                String aId = null;
                String fId = fid.getText();
                String aTime = atime.getText();
                String aDetail = adetail.getText();
                


                Object[] param = {fId,aTime,aDetail};
                Database db = new Database();
                db.executUpdate(sql, param);
                PreparedStatement ps;

                dataModel.add(new Vector<String>(Arrays.asList(
                		aId,fId,aDetail,aTime)));

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
                String sql = "delete from announcement where a_id = ?";
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
class QueryItem2 extends JPanel {
    //private JCheckBox checkbox;
    private JLabel label;
    private JTextField textfield;

    public QueryItem2(String labelText, int textWidth) {
        //checkbox = new JCheckBox();
        label = new JLabel(labelText);
        textfield = new JTextField(textWidth);
        //this.add(checkbox);
        this.add(label);
        this.add(textfield);
    }

    public String getText() {
        return textfield.getText();
    }
}

