package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.RepertoryDAO.RepertoryMapper;
import entity.Employee;
import entity.Repertory;
import util.BaseDao;
import util.RowMapper;

public class EmployeeDAO extends BaseDao {
    /**
     * 增加员工
     *
     * @param employee
     * @return
     */
    public int doCreate(Employee employee) {
        String sql = "insert into employee values (null,?,?,?,?,?,?)";
        return super.insert(sql, employee.getPname(),
                employee.getPlphone(),
                employee.getPpwd(),
                employee.getPplace(),
                employee.getPstatu(),
                employee.getPbz());
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<Employee> selectAll() {
        String sql = "SELECT * FROM  employee ORDER BY Psid DESC;";
        return super.query(sql, new EmoMapper());
    }

    /**
     * 根据账号查询用户信息
     *
     * @param pname
     * @return
     */
    public Employee selectByEmoName(String pname) {
        String sql = "select * from Employee where pname=?";
        List<Employee> list = super.query(sql, new EmoMapper(), pname);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 修改员工（除了员工id不能修改）
     *
     * @param employee
     * @return
     */
    public boolean doUpdate(Employee employee) {
        String sql = "update employee set pname=?,plphone=?,pplace=?,pstatu=?,pbz=? where psid=?";
        int i = super.update(sql, employee.getPname(),
                employee.getPlphone(),
                employee.getPplace(),
                employee.getPstatu(),
                employee.getPbz(),
                employee.getPsid());
        return i > 0 ? true : false;
    }

    /**
     * 删除员工--只修改员工状态--离职
     *
     * @param pname
     * @return
     */
    public boolean doUpdateZt(Employee employee) {
        String sql = "update employee set pstatu=? where pname=?";
        int i = super.update(sql, employee.getPstatu(),
                employee.getPname());
        return i > 0 ? true : false;
    }

    //根据员工名称找到员工编号
    public List<Employee> selectID(String pname) {
        String sql = "select * from employee where pname=?";
        return super.query(sql, new EmoMapper(), pname);
    }

    /**
     * 删除员工--从数据库删除（不建议采用）
     *
     * @param psid
     * @return
     */
    public boolean doDelete(String pname) {
        String sql = "delete from employee where pname=?";
        int r = super.update(sql, pname);
        return r > 0 ? true : false;
    }

    /**
     * 模糊查询
     *
     * @param name
     * @param post
     * @param tel
     * @return
     */
    public List<Employee> selectByWord(String name, String post, String tel) {
        StringBuilder sb = new StringBuilder();
        List<Object> list = new ArrayList<>();
        String sql = "select * from employee where 1=1";
        if (name != null) {
            sb.append(" and pname like ?");
            list.add("%" + name + "%");
        }
        if (tel != null) {
            sb.append(" and plphone like ?");
            list.add("%" + tel + "%");
        }
        if (post != null) {
            sb.append(" and pplace like ?");
            list.add("%" + post + "%");
        }
        //list有序集合存储的是该SQL语句需要的参数信息
        Object[] arr = list.toArray();
        List<Employee> myresult = super.query(sql + sb.toString(), new EmoMapper(), arr);
        return myresult;
    }

    /**
     * 内部类，实现接口RowMapper
     *
     * @author SMILE
     */
    class EmoMapper implements RowMapper<Employee> {

        @Override
        public Employee rowmap(ResultSet rs) throws SQLException {
            return new Employee(
                    rs.getInt("psid"),
                    rs.getString("pname"),
                    rs.getString("plphone"),
                    rs.getString("ppwd"),
                    rs.getString("pplace"),
                    rs.getBoolean("pstatu"),
                    rs.getString("pbz"));
        }

    }
}
