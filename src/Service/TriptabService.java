package Service;
import java.util.List;

import Pojo.*;
public interface TriptabService
{
	List<Triptab> querytrip1(Triptab triptab); //��ѯδ�������뵥
    List<Triptab> querytrip2(Triptab triptab);//��ѯδ�������뵥
    int updatetrip(Triptab triptab);//���������������ֶ�
}
