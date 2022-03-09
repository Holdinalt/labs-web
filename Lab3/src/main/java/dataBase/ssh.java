package dataBase;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.*;

public class ssh {

    //ssh -p 2222 s284201@se.ifmo.ru -Y -L1521:helios:1521

    private static Connection connection = null;
    private static Session session= null;
    private final int lport = 1521;

    public ssh(){
    }

    public void makeSSH(){
        try{

            final String rhost="localhost";
            final int rport=1521;
            final String sshHost="se.ifmo.ru";
            final String user="s284201";
            final String password="pass"; //put it in Ur mouth

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            session=jsch.getSession(user, sshHost, 2222);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");
            int assinged_port = session.setPortForwardingL(lport, rhost, rport);
            System.out.println("localhost:"+assinged_port+" -> "+rhost+":"+rport);
            System.out.println("Port Forwarded");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void closeSSHConnection(){

        if (connection == null){
            System.out.println("Что-то не так с сессией в ссш");
            return;
        }
        session.disconnect();
        System.out.println("Тунель с базой данных разорван сервером.");
    }

}
