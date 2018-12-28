package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import com.model.Flight;
import com.usejdbc.*;
import javax.swing.*;

/**
 * @author: FLLFFL
 * @description: 查寻航班
 */
public class FlightChoiseView extends JFrame {
    private final int COLUMN = 7;
    private final List<String> TITLES = Arrays.asList(
            "航班号", "出发日期", "到达日期", "出发城市", "到达城市", "出发时间", "到达时间");
    private final List<String> TITLES2 = Arrays.asList(
            "f_id", "f_sdate", "f_edate", "f_scity", "f_ecity", "f_stime", "f_etime");
    private Vector<Vector<String>> dataModel = new Vector<Vector<String>>();
    //private QueryItem id = new QueryItem("航班号：", 5);
    private QueryItem2 sdate = new QueryItem2("出发日期：", 13);
    //private QueryItem tname = new QueryItem("到达日期：", 10);
    private QueryItem2 scity = new QueryItem2("出发城市：", 13);
    private QueryItem2 ecity = new QueryItem2("到达城市：", 13);
    private JButton queryBtn = new JButton("查询");
    private JButton cancelBtn = new JButton("取消");
    private JButton reserveBtn = new JButton("预定");
    //private JTextArea textarea = new JTextArea(5, 5);
    private MyTable table;
    private Connection conn;
    Frame f = new Frame("查询航班");
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	FlightChoiseView f = new FlightChoiseView();
    	
    	
    }

    //构造函数，负责创建用户界面
    public FlightChoiseView() {
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
        controlPanel.add(sdate);
        controlPanel.add(scity);
        controlPanel.add(ecity);
        
        controlPanel.add(queryBtn);
        controlPanel.add(reserveBtn);
        controlPanel.add(cancelBtn);
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
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(750, 500));
        f.setResizable(false);
        f.setVisible(true);
    }



    private void setActionListener() {
        //根据指定条件，列出数据库中满足条件的记录
        queryBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	String fsdate = sdate.getText();
            	String fscity = scity.getText();
            	String fecity = ecity.getText();
            	
            	String[] param = {fsdate,fscity,fecity};//输入出发日期，城市，和终点
            	
                ArrayList<String> conditions = new ArrayList<String>();
                Database db = new Database();
                String queryString = "select * from flight where f_sdate=? and f_scity=? and f_ecity=?";
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


        //取消
        cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//this.dispose();
				TourView tv = new TourView();
				tv.setVisible(true);
				f.dispose();
			}
        });

        //预定机票
        reserveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                String fid = dataModel.get(row).get(0);
                String[] param = {fid};
                //String sql = "select * from plane where f_id=?";
                //System.out.println();
                //Database db = new Database();
                //ResultSet rs = db.executQuery(sql, param);
                Flight.setu(fid);
                SelectTicketView stv = new SelectTicketView();
                stv.setVisible(true);
                    dataModel.remove(row);
                    //更新表格
                    table.validate();
                    table.updateUI();
            }
        });


}

/* 查询项目
 * 将复选框、标签、文本框组合成一个组件
 * 对外提供获取文本和选中状态的两个方法
 */
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

}