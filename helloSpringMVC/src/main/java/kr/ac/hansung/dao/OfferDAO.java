package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;


@Repository
public class OfferDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//현재 레코드 개수 조회
	public int getRowCount() { 
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);

	}
	
	// query and return a multiple object
	public List<Offer> getOffers(int year, int semester) {
		String sqlStatement = "select * from class where year=? and semester=?";
		return jdbcTemplate.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();
				offer.setYear(rs.getInt("year")); 
				offer.setName(rs.getString("name"));
				offer.setCode(rs.getString("code"));
				offer.setPoint(rs.getInt("sum(point)"));
				offer.setSemester(rs.getInt("semester"));
				offer.setType(rs.getString("type"));
				
				return offer;
			}
		});
	}
	
	//학기별로 현재 여러개의 레코드 조회
	public List<Offer> getCurrentBySemester() { 
		String sqlStatement = "select year,semester,sum(grade) from class group by year, semester";
		
		/*익명클래스 쓰는경우: 클래스를 한번만 사용할 경우 (재사용x)*/
		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() { //레코드를 가져와 자바의 객체로 만들어준다. (익명클래스이용)
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setYear(rs.getInt("year")); 
				offer.setName(rs.getString("name"));
				offer.setCode(rs.getString("code"));
				offer.setPoint(rs.getInt("sum(point)"));
				offer.setSemester(rs.getInt("semester"));
				offer.setType(rs.getString("type"));
				return offer;
			} 
		});
	}
	
	
	//선택된 수강과목정보를 조회
	public List<Offer> getOfferSelected(int year) {
		String sqlStatement = "select * from class where year=?";
		return jdbcTemplate.query(sqlStatement, new Object[] { year }, new RowMapper<Offer>() {
			
			//receive record  ->  set Object  ->  return object
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();
				offer.setYear(rs.getInt("year")); 
				offer.setName(rs.getString("name"));
				offer.setCode(rs.getString("code"));
				offer.setPoint(rs.getInt("sum(point)"));
				offer.setSemester(rs.getInt("semester"));
				offer.setType(rs.getString("type"));
				return offer;
			}
		});
	}
	
	//레코드 삽입
	public boolean insert(Offer offer) {
		int point = offer.getPoint();
		int semester = offer.getSemester();
		int year = offer.getYear();
		String code = offer.getCode();
		String name = offer.getName();
		String type = offer.getType();
		
		String sqlStatement= "insert into class (point, semester, code, name, type, year) values (?, ?, ?, ?, ?, ?)";
		
		//update 성공시 1반환
		return (jdbcTemplate.update(sqlStatement, new Object[] {point, semester, code, name, type, year}) == 1);
		
	}
	
	//레코드 업데이트
//	public boolean update(Offer offer) {
//		int point = offer.getPoint();
//		int semester = offer.getSemester();
//		int year = offer.getYear();
//		String code = offer.getCode();
//		String name = offer.getName();
//		String type = offer.getType();
//		
//		String sqlStatement= "update class set point=? , semester=? , year=? , name=? , type=? where code=?";
//		
//		return (jdbcTemplate.update(sqlStatement,new Object[]{point,semester,year,name,type,code}) ==1); //update 성공시 1반환
//	}
	
	//레코드 삭제
//	public boolean delete(String code) {
//		
//		String sqlStatement= "delete from class where code=?";
//		
//		return (jdbcTemplate.update(sqlStatement,new Object[]{code}) ==1); //update 성공시 1반환
//	}
}
