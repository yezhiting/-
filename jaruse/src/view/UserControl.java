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
import com.usejdbc.*;

import javax.swing.*;

/**
 * @author: FLLFFL
 * @description: 增删改查用户
 */
public class UserControl extends JFrame{
    private final int COLUMN = 7;
    private final List<String> TITLES = Arrays.asList(
            "ID", "用户名", "真实姓名", "身份证", "邮箱", "手机", "权限");
    private final List<String> TITLES2 = Arrays.asList(
            "u_id", "u_fname", "u_tname", "u_iden", "u_mail", "u_phone", "u_power");
    private Vector<Vector<String>> dataModel = new Vector<Vector<String>>();
    private QueryItem id = new QueryItem("ID：", 5);
    private QueryItem fname = new QueryItem("用户名：", 5);
    private QueryItem tname = new QueryItem("真实姓名：", 5);
    private QueryItem iden = new QueryItem("身份证：", 15);
    private QueryItem mail = new QueryItem("邮箱：", 15);
    private QueryItem phone = new QueryItem("手机：", 15);
    private QueryItem power = new QueryItem("权限：", 12);
    private JButton queryBtn = new JButton("查询");
    private JButton saveBtn = new JButton("修改");
    private JButton insertBtn = new JButton("添加");
    private JButton deleteBtn = new JButton("删除");
    private JButton backBtn = new JButton("返回");
    //private JTextArea textarea = new JTextArea(5, 5);
    private MyTable table;
    private Connection conn;
    //static UserControl frame;
    JFrame f = new JFrame();
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//    	UserControl u = new UserControl();
//    	
//    }

    //构造函数，负责创建用户界面 
    public UserControl() {
 

        Vector<String> titles = new Vector<String>(TITLES);
        table = new MyTable(dataModel, titles);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(90);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(20);
        table.getColumnModel().getColumn(6).setPreferredWidth(10);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(id);
        controlPanel.add(fname);
        controlPanel.add(tname);
        controlPanel.add(iden);
        controlPanel.add(mail);
        controlPanel.add(phone);
        controlPanel.add(power);
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
        //根据指定条件，列出数据库中满足条件的记录
        queryBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	String[] param = new String[1];
            	
                ArrayList<String> conditions = new ArrayList<String>();
                
                int j=0;
                
                if (id.isSelected()) {
                	conditions.add("(u_id = ?)"); 
                	param[j] = id.getText();
                	j++;
                	System.out.println("1");
                	System.out.println(param[0]);
                }else{
                	param = null;
                	System.out.println("0");
                }
            
                Database db = new Database();
                StringBuilder sb = new StringBuilder();
                sb.append("select u_id,u_fname,u_tname,u_iden,u_mail,u_phone,u_power from user");
                int length = conditions.size();
                if (length != 0) sb.append(" where ");
                for (int i = 0; i < length; i++) {
                    sb.append(conditions.get(i));
                    if (i != length - 1) sb.append(" AND ");
                }
                sb.append(";");
                String queryString = sb.toString();           
                dataModel.clear();
                
                try {
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

                //更新表格
                table.validate();
                table.updateUI();
            }

        });

        //根据用户当前选中的单元格，修改数据库中对应记录的对应字段
        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                if (row == -1 || column == 0) return;
                Database db = new Database();
                String val = dataModel.get(row).get(column);
                String sid = dataModel.get(row).get(0);
                String sql = "update user set " + TITLES2.get(column) + " = ? where u_id = ?;";

                Object[] param = {val,sid};
                db.executUpdate(sql, param);
                JOptionPane.showMessageDialog(null, "更改成功", "提示",
						JOptionPane.PLAIN_MESSAGE);
            

            }
        });

        //往数据库中插入一条新的记录
        insertBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "insert into user (u_fname,u_tname,u_iden,u_pw,u_mail,u_phone,u_power) values (?,?,?,1,?,?,?)";
                String uid = id.getText();
                String ufname = tname.getText();
                String utname = fname.getText();
                String uiden = iden.getText();
                String umail = mail.getText();
                String uphone = phone.getText();
                String upower = power.getText();

                Object[] param = {ufname,utname,uiden,umail,uphone,upower};
                Database db = new Database();
                db.executUpdate(sql, param);
                PreparedStatement ps;

                dataModel.add(new Vector<String>(Arrays.asList(
                    		uid, ufname, utname, uiden, umail, uphone, upower)));
                JOptionPane.showMessageDialog(null, "插入成功", "提示",
						JOptionPane.PLAIN_MESSAGE);
                //更新表格
                table.validate();
                table.updateUI();

            }

        });

        //将用户当前选中的记录从数据库中删除
        deleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                String sid = dataModel.get(row).get(0);
                Object[] param = {sid};
                String sql = "delete from user where u_id = ?";
                Database db = new Database();
                db.executUpdate(sql, param);
                JOptionPane.showMessageDialog(null, "删除成功", "提示",
						JOptionPane.PLAIN_MESSAGE);
                    dataModel.remove(row);
                    //更新表格
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

/* 查询项目
 * 将复选框、标签、文本框组合成一个组件
 * 对外提供获取文本和选中状态的两个方法
 */
class QueryItem extends JPanel {
    private JCheckBox checkbox;
    private JLabel label;
    private JTextField textfield;

    public QueryItem(String labelText, int textWidth) {
        checkbox = new JCheckBox();
        label = new JLabel(labelText);
        textfield = new JTextField(textWidth);
        this.add(checkbox);
        this.add(label);
        this.add(textfield);
    }

    public boolean isSelected() {
        return checkbox.isSelected();
    }

    public String getText() {
        return textfield.getText();
    }
}



/* 表格组件
 * 重载了 JTable 的 isCellEditable 方法
 * 目的是防止编辑 Sid 字段，禁止修改主键
 */
class MyTable extends JTable {
    public MyTable(Vector data, Vector title) {
        super(data, title);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 0) return false;
        else return true;
    }
}
