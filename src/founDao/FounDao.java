package founDao;

import java.util.List;

import Pojo.Triptab;
public interface FounDao {
	List<Triptab> nospquery(Triptab trip); //δ����������ѯ
    List<Triptab> yspquery(Triptab trip);//������������ѯ
    int updatetrip(Triptab trip);//��������������ֶ�
	
}
