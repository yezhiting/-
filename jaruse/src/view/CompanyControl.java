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
 * @description: 增删改查用户
 */
public class CompanyControl extends JFrame{
    private final int COLUMN = 7;
    private final List<String> TITLES = Arrays.asList(
            "公司id","公司名", "注册人");
    private final List<String> TITLES2 = Arrays.asList(
    		"c_id","c_name", "c_regist");
    private Vector<Vector<String>> dataModel = new Vector<Vector<String>>();
    private QueryItem2 cid = new QueryItem2("公司id：", 15);
    private QueryItem2 cname = new QueryItem2("公司名：", 15);
    private QueryItem2 cregist = new QueryItem2("注册人：", 15);
    private JButton changeBtn = new JButton("更改");
    private JButton insertBtn = new JButton("添加公司");
    private JButton deleteBtn = new JButton("删除公司");
    private JButton backBtn = new JButton("返回");
    private JButton flashBtn = new JButton("查询");
    private MyTable table;
    private Connection conn;
    JFrame f = new JFrame();
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	UserControl u = new UserControl();
    }

    //构造函数，负责创建用户界面 
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
        //根据指定条件，列出数据库中满足条件的记录
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

                //更新表格
                table.validate();
                table.updateUI();
            }

        });
        //往数据库中插入一条新的记录
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
                String aId = dataModel.get(row).get(0);
                Object[] param = {aId};
                String sql = "delete from company where c_id = ?";
                Database db = new Database();
                //在文本框显示 SQL 命令
                //textarea.setText(sql);
                db.executUpdate(sql, param);
                    dataModel.remove(row);
                    //更新表格
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


