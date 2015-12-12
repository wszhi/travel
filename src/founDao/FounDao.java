package founDao;

import java.util.List;

import Pojo.Triptab;
public interface FounDao {
	List<Triptab> nospquery(Triptab trip); //未审批申请表查询
    List<Triptab> yspquery(Triptab trip);//已审批申请表查询
    int updatetrip(Triptab trip);//审批申请表，更新字段
	
}
