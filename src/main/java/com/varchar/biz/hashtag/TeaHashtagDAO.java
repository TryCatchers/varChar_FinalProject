package com.varchar.biz.hashtag;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository("teaHashtagDAO")
public class TeaHashtagDAO {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	static final private String SQL_SELECTALL = "SELECT th.TEA_HASHTAG_NUM, th.TEA_HASHTAG_CONTENT "
			+ "FROM TEA_HASHTAG th"
			+ "JOIN HASHTAG_DETAIL hd ON th.TEA_HASHTAG_NUM = hd.HASGTAG_NUM "
			+ "WHERE ITEM_NUM = ?";
	
	static final private String SQL_INSERT = "INSERT INTO TEA_HASHTAG(TEA_HASHTAG_NUM, TEA_HASHTAG_CONTENT) "
			+ "VALUES ((SELECT NVL(MAX(TEA_HASHTAG_NUM), 1000)+1 FROM TEA_HASHTAG), ?)";


	public List<TeaHashtagVO> selectAll(TeaHashtagVO teaHashtagVO) {
		Object[] args = {teaHashtagVO.getItemNum()};
		return jdbcTemplate.query(SQL_SELECTALL, args, new TeaHashtagSelectRowMapper());
	}

	public TeaHashtagVO selectOne(TeaHashtagVO teaHashtagVO) {
		return null;
	}

	public boolean insert(TeaHashtagVO teaHashtagVO) {
		int result = jdbcTemplate.update(SQL_INSERT, teaHashtagVO.getTeaHashtagContent());

		if(result <= 0) {
			return false;
		}
		return true;
	}

	public boolean update(TeaHashtagVO teaHashtagVO) {
		return false;
	}

	public boolean delete(TeaHashtagVO teaHashtagVO) {
		return false;
	}


}

// ----------------------------------------------------------------------------------------------------

//[ selectAll ]
class TeaHashtagSelectRowMapper implements RowMapper<TeaHashtagVO> {

	@Override
	public TeaHashtagVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		TeaHashtagVO data = new TeaHashtagVO();
		data.setTeaHashtagNum(rs.getInt("TEA_HASHTAG_NUM"));
		data.setTeaHashtagContent(rs.getString("TEA_HASHTAG_CONTENT"));			
		return data;
	}

}
