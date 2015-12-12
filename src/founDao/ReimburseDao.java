package founDao;
import java.util.List;
import Pojo.Reimburse;
public interface ReimburseDao {
	List<Reimburse> nospbxquery(Reimburse reimburse);	//未审批报销表查询
	List<Reimburse> yspbxquery(Reimburse reimburse);//已审批报销表查询
	int updaterei(Reimburse reimburse);//审批报销表，更新字段
}
