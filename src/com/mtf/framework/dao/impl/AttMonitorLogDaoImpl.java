package com.mtf.framework.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mtf.framework.dao.AttMonitorLogDao;
import com.mtf.framework.model.AttMonitorLog;
import com.mtf.framework.model.impl.AttMonitorLogImpl;

public class AttMonitorLogDaoImpl implements AttMonitorLogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Map<String, Object>> search(AttMonitorLogImpl attMonitorLog) {
		String sql = "SELECT " +
				"b.`name` AS userName, " +
				"b.badgenumber, " +
				"a.pin, " +
				"a.time, " +
				"c.`name` AS festivelName, " +
				"c.loopYear, " +
				"c.typeDate, " +
				"a.time, " +
				"a.time, " +
				"a.time, " +
				"DAY(a.time) AS day, " +
				"MIN(a.time) AS timeStart, " +
				"MAX(a.time) AS timeEnd, " +
				"MONTH(a.time) AS dateMonth, " +
				"DATE(a.time) AS date, " +
//				"date_format(a.time,’yyyy/MM/dd’) AS date, " +
				"DATE(NOW()) AS addDate, " +
				"dayofweek(a.time) AS dateWeek, " +
				"time(MIN(a.time)) AS dayStart, " +
				"time(MAX(a.time)) AS dayEnd, " +
				"TIMEDIFF(MAX(a.time), MIN(a.time)) AS timeWork, " +
				"CASE WHEN " +
					"time(MIN(a.time)) > time('09:11:00')" +
				"THEN " +
					"'la'" +
				"ELSE " +
					"'no' " +
				"END AS late, " +
				"CASE WHEN " +
					"time(MAX(a.time)) < time('17:49:00')" +
				"THEN " +
					"'le'" +
				"ELSE " +
					"'no'" +
				"END AS leaveEarly," +
				"CASE WHEN " +
						"time(MIN(a.time)) > time('09:11:00') AND time(MAX(a.time)) < time('17:49:00')" +
				"THEN " +
					"'lale'" +
				"WHEN " +
					"time(MIN(a.time)) > time('09:11:00')" +
				"THEN " +
					"'la'" +
				"WHEN " +
					"time(MAX(a.time)) < time('17:49:00')" +
				"THEN " +
					"'le'" +
				"ELSE " +
					"'no' " +
				"END AS statusAttendance " +
				"FROM " +
					"userinfo AS b " +
				"LEFT JOIN acc_monitor_log AS a ON b.badgenumber = a.pin " +
				"LEFT JOIN office.attenFestival AS c ON (c.day = DATE_FORMAT(a.time, '%m-%d') AND c.tag = 'd')" +
				"WHERE " +
//					"b.name IS NOT NULL " +
//					"AND " +
					"DATE(a.time) = DATE('" +
					attMonitorLog.getCollectDate() +
					"') " +
//					"AND dayofweek(a.time) != 7 " +
//					"AND dayofweek(a.time) != 1 " +
					"GROUP BY b.name; ";
		List<Map<String, Object>>  list = jdbcTemplate.queryForList(sql);
		System.err.println(sql);
		return list;
	}

}
