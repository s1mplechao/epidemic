package coronavirus.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtil {
    private static DataSource ds = new ComboPooledDataSource("coronavirus");
    static ComboPooledDataSource cp = (ComboPooledDataSource) ds;

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭连接
     *
     * @param con 数据库连接对象
     * @param ps  预编译对象
     * @param rs  结果集对象
     */

    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试方法
     *
     * @param args 系统参数
     * @throws Exception 异常
     */
    public static void main(String[] args) throws Exception {
        Connection con = DbUtil.getConnection();
        if (con != null) {
            System.out.println("数据库连接成功");
        } else {
            System.out.println("数据库连接失败");
        }
        DbUtil.close(con, null, null);
    }
}
