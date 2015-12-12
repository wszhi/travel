package Service;
import java.util.List;
import Pojo.Reimburse;
public interface ReimburseService {
List<Reimburse> reimbquery1(Reimburse reimburse);//查询未审批报销表
List<Reimburse> reimbquery2(Reimburse reimburse);//查询已审批报销表
int updaterei(Reimburse reimburse);//审批报销表

}
