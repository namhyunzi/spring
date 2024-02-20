package ioc;

public class ProductMybatisDao implements ProductDao {

	@Override
	public void insertProduct() {
		System.out.println("mybatis 기술을 이용해서 상품정보를 저장한다.");
		
	}

	@Override
	public void getProduct() {
		// TODO Auto-generated method stub
		System.out.println("mybatis 기술을 이용해서 상품정보를 조회한다.");
		
	}

	@Override
	public void updateProduct() {
		// TODO Auto-generated method stub
		System.out.println("mybatis 기술을 이용해서 상품정보를 수정한다.");
		
	}

}
