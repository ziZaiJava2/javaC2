package springPractice;

public class ServiceImpl implements  Service{
	
	private Dao dao;

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
	 public String toString(){
		 return "Service implements dao:" + dao;}
	
	

}
