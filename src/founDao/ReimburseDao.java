package founDao;
import java.util.List;
import Pojo.Reimburse;
public interface ReimburseDao {
	List<Reimburse> nospbxquery(Reimburse reimburse);	//δ�����������ѯ
	List<Reimburse> yspbxquery(Reimburse reimburse);//�������������ѯ
	int updaterei(Reimburse reimburse);//���������������ֶ�
}
