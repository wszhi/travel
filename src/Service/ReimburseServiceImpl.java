package Service;
import java.util.List;
import founDao.ReimburseDao;
import Pojo.Reimburse;
public class ReimburseServiceImpl implements ReimburseService {
	private ReimburseDao reimburseDao;
	public ReimburseDao getReimburseDao() {
		return reimburseDao;
	}
	public void setReimburseDao(ReimburseDao reimburseDao) {
		this.reimburseDao = reimburseDao;
	}

	@Override
	public List<Reimburse> reimbquery1(Reimburse reimburse) {
		System.out.println("进入queryrei1函数了");
	    return reimburseDao.nospbxquery(reimburse) ;
	}

	@Override
	public List<Reimburse> reimbquery2(Reimburse reimburse) {
		return reimburseDao.yspbxquery(reimburse);
	}

	@Override
	public int updaterei(Reimburse reimburse) {
		return reimburseDao.updaterei(reimburse);
	}

	

	

}
