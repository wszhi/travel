package Service;
import java.util.List;

import Pojo.*;
public interface TriptabService
{
	List<Triptab> querytrip1(Triptab triptab); //查询未审批申请单
    List<Triptab> querytrip2(Triptab triptab);//查询未审批申请单
    int updatetrip(Triptab triptab);//审批操作，更新字段
}
