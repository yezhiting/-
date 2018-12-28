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
import com.model.User;
import com.usejdbc.*;

import javax.swing.*;


/**
 * @author: FLLFFL
 * @description: 增删改查用户
 */
public class AnnoSee extends JFrame{
    private final int COLUMN = 7;
    private final List<String> TITLES = Arrays.asList(
            "公告","航班号", "时间", "详情");
    private final List<String> TITLES2 = Arrays.asList(
    		"a_id","f_id", "a_time", "a_detail");
    private Vector<Vector<String>> dataModel = new Vector<Vector<String>>();
    private JButton backBtn = new JButton("返回");
    private JButton flashBtn = new JButton("查看");
    private MyTable table;
    private Connection conn;
    JFrame f = new JFrame();
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	AnnoSee u = new AnnoSee();
    }

    //构造函数，负责创建用户界面 
    public AnnoSee() {
 

        Vector<String> titles = new Vector<String>(TITLES);
        table = new MyTable(dataModel, titles);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);


        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        controlPanel.add(flashBtn);
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

                //更新表格
                table.validate();
                table.updateUI();
            }

        });



        
        backBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispose();
                TourView mv = new TourView();
                mv.setVisible(true);
                f.dispose();
            }
        });
    }

}

