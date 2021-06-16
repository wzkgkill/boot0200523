package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDAO.EmoMapper;
import entity.Employee;
import entity.Supplier;
import util.BaseDao;
import util.RowMapper;

public class SupplierDAO extends BaseDao {
    /**
     * 增加供货商
     *
     * @param supplier
     * @return
     */
    public int doCreate(Supplier supplier) {
        String sql = "insert into supplier values (null,?,?,?,?,?,?)";
        return super.insert(sql, supplier.getSupname(),
                supplier.getSuppeople(),
                supplier.getSuptel(),
                supplier.getSupadress(),
                supplier.getSupbz(),
                supplier.getSupstatu());
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<Supplier> selectAll() {
        String sql = "SELECT * FROM supplier ORDER BY supid DESC;";
        return super.query(sql, new SupplierMapper());
    }

    /**
     * 修改供货商
     *
     * @param supplier
     * @return
     */
    public boolean doUpdate(Supplier supplier) {
        String sql = "update supplier set supname=?,suppeople=?,suptel=?,supadress=?,supbz=?,supstatu=? where supid=?";
        int i = super.update(sql, supplier.getSupname(),
                supplier.getSuppeople(),
                supplier.getSuptel(),
                supplier.getSupadress(),
                supplier.getSupbz(),
                supplier.getSupstatu(),
                supplier.getSupid());

        return i > 0 ? true : false;
    }

    /**
     * 根据供货商名称找到对应的编号
     *
     * @param supname
     * @return
     */
    public List<Supplier> selectID(String supname) {
        String sql = "select * from supplier where supname=?";
        return super.query(sql, new SupplierMapper(), supname);
    }

    /**
     * 删除供货商--修改供货商状态--禁用
     *
     * @param supplier
     * @return
     */
    public boolean doUpdateZt(Supplier supplier) {
        String sql = "update supplier set Supstatu=? where supname=?";
        int i = super.update(sql, supplier.getSupstatu(),
                supplier.getSupname());
        return i > 0 ? true : false;
    }

    /**
     * 删除供货商
     *
     * @param supname
     * @return
     */
    public boolean doDelete(String supname) {
        String sql = "delete from supplier where supname=?";
        int i = super.update(sql, supname);
        return i > 0 ? true : false;
    }

    public List<Supplier> selectByWord(String name, String people, String phone, String province) {
        StringBuilder sb = new StringBuilder();
        List<Object> list = new ArrayList<>();
        String sql = "select * from Supplier where 1=1";
        if (name != null) {
            sb.append(" and supname like ?");
            list.add("%" + name + "%");
        }
        if (people != null) {
            sb.append(" and suppeople like ?");
            list.add("%" + people + "%");
        }
        if (phone != null) {
            sb.append(" and suptel like ?");
            list.add("%" + phone + "%");
        }
        if (province != null) {
            sb.append(" and supadress like ?");
            list.add("%" + province + "%");
        }
        //list有序集合存储的是该SQL语句需要的参数信息
        Object[] arr = list.toArray();
        List<Supplier> myresult = super.query(sql + sb.toString(), new SupplierMapper(), arr);
        return myresult;
    }

    class SupplierMapper implements RowMapper<Supplier> {
        @Override
        public Supplier rowmap(ResultSet rs) throws SQLException {
            return new Supplier(rs.getInt("supid"),
                    rs.getString("supname"),
                    rs.getString("suppeople"),
                    rs.getString("suptel"),
                    rs.getString("supadress"),
                    rs.getString("supbz"),
                    rs.getBoolean("supstatu"));
        }

    }
}
