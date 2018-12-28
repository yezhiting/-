package server;

import info.Shuttle;
import info.User;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import messages.Message;
import messages.MessageExample;
import messages.MessageLoginAck;
import messages.MessageLoginReq;
import messages.MessageShuttleQuery;
import messages.MessageShuttleQueryAck;
import messages.MessageTicketBook;
import messages.MessageTicketBookAck;
import server.database.CPYDDatabase;

public class ServerAdmin extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new ServerAdmin();
    }

    // 界面元素
    private JTextField fieldAcount = new JTextField(20);
    private JPasswordField fieldPwd = new JPasswordField(20);
    private JButton buttonEnable = new JButton("开启服务");
    private JButton buttonDisable = new JButton("关闭服务");

    // 网络服务信息
    private ServerSocket serverSocket = null;
    private int serverPort = 54321;
    // 服务开关
    private boolean enableService = false;

    public ServerAdmin() {
        this.setTitle("Server");
        this.setLocation(300, 200);
        this.setSize(300, 120);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                disableService();
                System.exit(0);
            }
        });

        // 设置页面布局
        this.setLayout(new GridLayout(3, 2, 0, 0));

        this.add(new JLabel("帐  号"));
        this.add(fieldAcount);
        this.add(new JLabel("密  码"));
        this.add(fieldPwd);

        buttonDisable.setEnabled(false);
        this.add(buttonEnable);
        this.add(buttonDisable);

        buttonEnable.addActionListener(this);
        buttonDisable.addActionListener(this);

        this.setVisible(true);

        // 启动服务器TCP端口和服务
        enableService();

        // 用户几点关闭服务按钮，系统退出，关闭serverSocket
        disableService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonEnable) {
            String account = fieldAcount.getText();
            String password = new String(fieldPwd.getPassword());
            // 判断用户名和密码是否正确
            // 登陆成功的条件：用户帐号存在，密码正确, 管理员权限
            if (handleLogin(account, password)) {

                // 禁止登录按钮，使能退出按钮
                buttonEnable.setEnabled(false);
                buttonDisable.setEnabled(true);

                // 启动ServerSocket
                enableService = true;
            } else {
                JOptionPane.showMessageDialog(this, "Invalid User");
                fieldPwd.setText("");
            }
        } else if (e.getSource() == buttonDisable) {
            // 系统退出服务，系统退出
            enableService = false;
            disableService();
            System.exit(0);
        }
    }

    private boolean handleLogin(String account, String password) {
        if (account.equals("admin")) {
            User user = CPYDDatabase.userQquery("admin");
            return user.verifyPwd(password);
        }
        return false;
    }

    public void enableService() {
        // 等待启动服务
        while (!enableService) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
        // 开放服务端口
        try {
            serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        // 使用while可以允许client端多次连接，但由于没有使用线程，同时只能有一个客户端连接服务器
        while (enableService) {
            // 监听端口请求，等待连接
            try {
                // 通过端口建立连接
                Socket socket = serverSocket.accept();
                // 收到客户端连接，处理用户请求
                System.out.println("Request received");
                handleClient(socket);

                // 客户端退出
                closeClient(socket);
                socket = null;
            } catch (SocketTimeoutException e) {
                // do nothing
            } catch (IOException e) {
                e.printStackTrace();
            } finally { // 停止服务
            }
        }
    }

    private void disableService() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            serverSocket = null;
        }
    }

    private void handleClient(Socket socket) {
        OutputStream os = null;
        ObjectOutputStream oos = null;
        InputStream is = null;
        ObjectInputStream ois = null;
        try {
            // 创建对象数据流
            os = socket.getOutputStream();
            is = socket.getInputStream();
            oos = new ObjectOutputStream(os);
            ois = new ObjectInputStream(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        // 处理来自客户端的消息对象
        while (enableService) {
            // 从对象输入数据流中读取数据对象
            Message msgReceived = null;
            try {
                msgReceived = (Message) ois.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (IOException e) { // Socket 出错，停止对次Socket的处理
                System.out.println(e.getMessage());
                return;
            }

            // 按消息类型处理
            switch (msgReceived.msgType) {
            case MSG_EXAMPLE:
                handleMsgExample((MessageExample) msgReceived, oos);
                break;
            case MSG_LOGIN_REQ:
                handleLoginRequest((MessageLoginReq) msgReceived, oos);
                break;
            case MSG_SHUTTLE_QUERY:
                handleShuttleQuery((MessageShuttleQuery) msgReceived, oos);
                break;
            case MSG_TICKET_BOOK_REQ:
                handleTicketBook((MessageTicketBook) msgReceived, oos);
                break;
            default:
                System.out.println("Uknown message received: "
                        + msgReceived.msgType);
            }
        }
    }

    private void closeClient(Socket socket) {
        if (socket != null) {
            try {
                socket.shutdownOutput();
                socket.shutdownInput();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean sendMessage(Message msg, ObjectOutputStream oos) {
        try {
            oos.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void handleMsgExample(MessageExample msgExample,
            ObjectOutputStream oos) {
        String data = msgExample.getData();
        System.out.println(data);
        msgExample.setData("Example Message Received: " + data);
        sendMessage(msgExample, oos);
    }

    private void handleLoginRequest(MessageLoginReq msgLogin,
            ObjectOutputStream oos) {
        boolean verifyPassed = false;
        User user = CPYDDatabase.userQquery(msgLogin.getAccount());

        MessageLoginAck msgLoginAck = new MessageLoginAck(msgLogin.getAccount());
        // 登陆成功的条件：用户帐号存在，并且不是管理员, 密码正确
        if (!(msgLogin.getAccount().equals("admin"))
                && user.getName().equals(msgLogin.getAccount())
                && msgLogin.verify(user.getPwd())) {
            verifyPassed = true;
            msgLoginAck.setFailReason("用户信息正确！");
        } else {
            msgLoginAck.setFailReason("用户信息不正确！");
        }
        System.out.println("Account: " + msgLogin.getAccount()
                + " Verification " + verifyPassed);

        msgLoginAck.setLoginResult(verifyPassed);
        msgLoginAck.setUser(user);

        sendMessage(msgLoginAck, oos);
    }

    private void handleShuttleQuery(MessageShuttleQuery msgShuttleQuery,
            ObjectOutputStream oos) {
        Vector<Shuttle> shuttles = CPYDDatabase.shuttleQquery(
                msgShuttleQuery.getStarting(), msgShuttleQuery.getEnding(),
                msgShuttleQuery.getYear(), msgShuttleQuery.getMonth(),
                msgShuttleQuery.getDate());

        MessageShuttleQueryAck msgAck = new MessageShuttleQueryAck();

        msgAck.setShuttles(shuttles);

        sendMessage(msgAck, oos);
    }

	private void handleTicketBook(MessageTicketBook msgTicketBook,
	        ObjectOutputStream oos) {
		MessageTicketBookAck msgAck = new MessageTicketBookAck(
		        msgTicketBook.getShuttleId(), msgTicketBook.getUserId());
		if (CPYDDatabase.ticketBook(msgTicketBook.getShuttleId(),
		        msgTicketBook.getUserId())) {
			msgAck.setSuccess(true);
		}

		sendMessage(msgAck, oos);
	}
}