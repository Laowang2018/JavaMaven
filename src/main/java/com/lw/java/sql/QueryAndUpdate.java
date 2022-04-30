package com.lw.java.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryAndUpdate {

    private static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&rewriteBatchStatements=true";
    private static String user = "root";
    private static String pwd = "1234";

    public static void main(String[] args) throws Exception{
        Connection conn = null;
        PreparedStatement query1 = null;
        ResultSet rt = null;

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pwd);

        String sql1 = "SELECT express_no,count(express_no) as number FROM `sell_order` where express_no is not null GROUP BY express_no HAVING number>=2";
        String sql2 = "select * from sell_order where express_no=?";
        String sql3 = "update sell_order set goods_no=?,goods_names=? where express_no=? and express_cost is not null";
        String sql4 = "delete from sell_order where express_no=? and express_cost is null";
        query1 = conn.prepareStatement(sql1);
        ResultSet resultSet = query1.executeQuery();
        int deleteCount = 0;
        while (resultSet.next()) {
            String expressNo = resultSet.getString(1);
            PreparedStatement query2 = conn.prepareStatement(sql2);
            query2.setString(1, expressNo);
            ResultSet resultSet1 = query2.executeQuery();
            String goods = "";
            String names = "";
            while(resultSet1.next()) {
                goods += resultSet1.getString(4)+";";
                names += resultSet1.getString(5)+";";
            }
            PreparedStatement update = conn.prepareStatement(sql3);
            update.setString(1, goods);
            update.setString(2, names);
            update.setString(3, expressNo);
            int i = update.executeUpdate();
            System.out.println("update sql expressNo=" + expressNo + ",and effect rows=" + i);

            PreparedStatement delete = conn.prepareStatement(sql4);
            delete.setString(1, expressNo);
            int count = delete.executeUpdate();
            deleteCount += count;
            System.out.println("delete the express_no="+expressNo+",result:"+count);
        }
        System.out.println("delete the all count:" + deleteCount);
        conn.close();


    }
}
