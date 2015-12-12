package PgBaseDao;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.mysql.jdbc.Connection;

/**
 * ArrayHandler閿涙碍濡哥紒鎾寸亯闂嗗棔鑵戦惃鍕儑娑擄拷鐞涘本鏆熼幑顔挎祮閹存劕顕挒鈩冩殶缂佸嫨锟斤拷
 * ArrayListHandler閿涙碍濡哥紒鎾寸亯闂嗗棔鑵戦惃鍕槨娑擄拷鐞涘本鏆熼幑锟�鍏樻潪顒佸灇娑擄拷娑擃亝鏆熺紒鍕剁礉閸愬秴鐡ㄩ弨鎯у煂List娑擃厹锟斤拷
 * BeanHandler閿涙艾鐨㈢紒鎾寸亯闂嗗棔鑵戦惃鍕儑娑擄拷鐞涘本鏆熼幑顔肩殱鐟佸懎鍩屾稉锟芥稉顏勵嚠鎼存梻娈慗avaBean鐎圭偘绶ユ稉顓滐拷锟�
 * BeanListHandler閿涙艾鐨㈢紒鎾寸亯闂嗗棔鑵戦惃鍕槨娑擄拷鐞涘本鏆熼幑锟�鍏樼亸浣筋棅閸掗绔存稉顏勵嚠鎼存梻娈慗avaBean鐎圭偘绶ユ稉顓ㄧ礉鐎涙ɑ鏂侀崚鐧搃st闁插被锟斤拷
 * ColumnListHandler閿涙艾鐨㈢紒鎾寸亯闂嗗棔鑵戦弻鎰閸掓娈戦弫鐗堝祦鐎涙ɑ鏂侀崚鐧搃st娑擃厹锟斤拷
 * KeyedHandler(name)閿涙艾鐨㈢紒鎾寸亯闂嗗棔鑵戦惃鍕槨娑擄拷鐞涘本鏆熼幑锟�鍏樼亸浣筋棅閸掗绔存稉鐙筧p闁插矉绱濋崘宥嗗Ω鏉╂瑤绨簃ap閸愬秴鐡ㄩ崚棰佺娑撶尠ap闁插矉绱濋崗绉宔y娑撶儤瀵氾拷?锟芥氨娈慿ey閵嗭拷
 * MapHandler閿涙艾鐨㈢紒鎾寸亯闂嗗棔鑵戦惃鍕儑娑擄拷鐞涘本鏆熼幑顔肩殱鐟佸懎鍩屾稉锟芥稉鐙筧p闁插矉绱漦ey閺勵垰鍨崥宥忕礉value鐏忚鲸妲革拷?锟界懓绨查惃鍕拷绗猴拷锟�
 * MapListHandler閿涙艾鐨㈢紒鎾寸亯闂嗗棔鑵戦惃鍕槨娑擄拷鐞涘本鏆熼幑锟�鍏樼亸浣筋棅閸掗绔存稉鐙筧p闁插矉绱濋悞璺烘倵閸愬秴鐡ㄩ弨鎯у煂List
 * 
 * @author admin
 *
 */
public class BaseDao{

	/**
	 * 閺屻儴顕楅幙宥勭稊,婢舵碍娼拋鏉跨秿,鏉╂柨娲朙ist閺佹壆锟�
	 * 
	 * @param sql
	 * @param clazz
	 * @return
	 * @throws SQLException
	 */
	public List getList(String sql, Class clazz, Object params[])
			throws Exception {
		java.sql.Connection conn = DBManager.getConn();
		QueryRunner runner = new QueryRunner();
		List list = (List) runner.query(conn, sql, new BeanListHandler<Object>(clazz),
				params);
		DbUtils.close(conn);
		return list;
	}

	/**
	 * 閺屻儴顕楅幙宥勭稊閿涘苯宕熼弶陇顔囪ぐ鏇礉鏉╂柨娲朆ean鐎电锟�
	 * 
	 * @param sql
	 * @param clazz
	 * @return
	 * @throws SQLException
	 */
	public Object getSingle(String sql, Class clazz, Object params[])
			throws Exception {
		java.sql.Connection conn = DBManager.getConn();
		QueryRunner runner = new QueryRunner();
		Object objet = runner.query(conn, sql, new BeanHandler<Object>(clazz), params);
		DbUtils.close(conn);
		return objet;
	}

	/**
	 * 閸掔娀娅庨敍灞兼叏锟�瑙勬惙娴ｏ拷
	 * 
	 * @param sql
	 * @param clazz
	 * @return
	 * @throws Exception 
	 */
	public int update(String sql, Object params[]) throws Exception {
		java.sql.Connection conn = DBManager.getConn();
		QueryRunner runner = new QueryRunner();
		int count = runner.update(conn, sql, params);
		DbUtils.close(conn);
		return count;
	}
}
