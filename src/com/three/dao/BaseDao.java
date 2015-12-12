package com.three.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.three.db.DBManger;

import java.sql.Connection;

/**
 * ArrayHandler锛氭妸缁撴灉闆嗕腑鐨勭涓�鏁版嵁杞垚瀵硅薄鏁扮粍銆�
 * ArrayListHandler锛氭妸缁撴灉闆嗕腑鐨勬瘡涓�鏁版嵁閮借浆鎴愪竴涓暟缁勶紝鍐嶅瓨鏀惧埌List涓�
 * BeanHandler锛氬皢缁撴灉闆嗕腑鐨勭涓�鏁版嵁灏佽鍒颁竴涓搴旂殑JavaBean瀹炰緥涓�
 * BeanListHandler锛氬皢缁撴灉闆嗕腑鐨勬瘡涓�鏁版嵁閮藉皝瑁呭埌涓�釜瀵瑰簲鐨凧avaBean瀹炰緥涓紝瀛樻斁鍒癓ist閲屻�
 * ColumnListHandler锛氬皢缁撴灉闆嗕腑鏌愪竴鍒楃殑鏁版嵁瀛樻斁鍒癓ist涓�
 * KeyedHandler(name)锛氬皢缁撴灉闆嗕腑鐨勬瘡涓�鏁版嵁閮藉皝瑁呭埌涓�釜Map閲岋紝鍐嶆妸杩欎簺map鍐嶅瓨鍒颁竴涓猰ap閲岋紝鍏秌ey涓烘寚瀹氱殑key銆�
 * MapHandler锛氬皢缁撴灉闆嗕腑鐨勭涓�鏁版嵁灏佽鍒颁竴涓狹ap閲岋紝key鏄垪鍚嶏紝value灏辨槸瀵瑰簲鐨勫�銆�
 * MapListHandler锛氬皢缁撴灉闆嗕腑鐨勬瘡涓�鏁版嵁閮藉皝瑁呭埌涓�釜Map閲岋紝鐒跺悗鍐嶅瓨鏀惧埌List
 * 
 * @author admin
 *
 */
public class BaseDao {

	/**
	 * 鏌ヨ鎿嶄綔,澶氭潯璁板綍,杩斿洖List鏁扮粍
	 * 
	 * @param sql
	 * @param clazz
	 * @return
	 * @throws SQLException
	 */
	public List getList(String sql, Class clazz, Object params[])
			throws SQLException {
		Connection conn = DBManger.Connect();
		QueryRunner runner = new QueryRunner();
		List list = (List) runner.query(conn, sql, new BeanListHandler<Object>(clazz),
				params);
		DbUtils.close(conn);
		return list;
	}

	/**
	 * 鏌ヨ鎿嶄綔锛屽崟鏉¤褰曪紝杩斿洖Bean瀵硅薄
	 * 
	 * @param sql
	 * @param clazz
	 * @return
	 * @throws SQLException
	 */
	public Object getSingle(String sql, Class clazz, Object params[])
			throws SQLException {
		Connection conn = DBManger.Connect();
		QueryRunner runner = new QueryRunner();
		Object objet = runner.query(conn, sql, new BeanHandler<Object>(clazz), params);
		DbUtils.close(conn);
		return objet;
	}

	/**
	 * 鍒犻櫎锛屼慨鏀规搷浣�
	 * 
	 * @param sql
	 * @param clazz
	 * @return
	 * @throws SQLException
	 */
	public int update(String sql, Object params[]) throws SQLException {
		Connection conn = DBManger.Connect();
		QueryRunner runner = new QueryRunner();
		int count = runner.update(conn, sql, params);
		DbUtils.close(conn);
		return count;
	}
}
