package Service;
import java.util.List;
import Pojo.Triptab;
import Service.TriptabService;
import founDao.*;
public class TriptabServiceImpl implements TriptabService
{
	private FounDao founDao;
	public void setFounDao(FounDao founDao)
	{
		this.founDao = founDao;
	}
	public FounDao getFounDao()
	{
		return founDao;
	}

@Override
public List<Triptab> querytrip1(Triptab triptab) {
	return founDao.nospquery(triptab) ;
}

@Override
public List<Triptab> querytrip2(Triptab triptab) {
	return founDao.yspquery(triptab);
}
@Override
public int updatetrip(Triptab triptab) {
	return founDao.updatetrip(triptab);
}	

}

	