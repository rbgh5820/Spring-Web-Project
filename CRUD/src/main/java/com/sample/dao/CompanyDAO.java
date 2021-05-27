package com.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.sample.vo.CompanyVO;

public class CompanyDAO {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(CompanyVO co) {
		String sql = "insert into company values("+co.getId()+",'" + co.getDepartment() + "','"
				+ co.getName() + "','" + co.getPosition() + "','" + co.getIp() + "','" + co.getPhone() + "','" + co.getEmail()
				+ "')";
		return template.update(sql);
	}

	public int update(CompanyVO co) {
		String sql = "update company set department='"+co.getDepartment()+"',name='" + co.getName() + "',position='" + co.getPosition() + "',ip='"
				+ co.getIp() + "',phone='" + co.getPhone() + "',email='" + co.getEmail() + "' where id="+co.getId()+"";
		System.out.println("sql : " + sql);
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from company where id=" + id + "";
		return template.update(sql);
	}

	public CompanyVO getCompanyVOById(int id) {
		String sql = "select * from company where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
	}

	public List<CompanyVO> getEmployees() {
		return template.query("select * from company", new RowMapper<CompanyVO>() {
			public CompanyVO mapRow(ResultSet rs, int row) throws SQLException {
				CompanyVO co = new CompanyVO();
				co.setId(rs.getInt(1));
				co.setDepartment(rs.getString(2));
				co.setName(rs.getString(3));
				co.setPosition(rs.getString(4));
				co.setIp(rs.getString(5));
				co.setPhone(rs.getString(6));
				co.setEmail(rs.getString(7));
				return co;
			}
		});
	}
}
