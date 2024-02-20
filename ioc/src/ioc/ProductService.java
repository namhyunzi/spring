package ioc;

/**
 * ProductService는 상품정보를 등록, 조회, 수정한다.
 * ProductService는 상품정보를 등록, 조회, 수정하기 위해서 
 * ProductDao 인터페이스를 구현한 객체가 필요하다.
 * @author jhta
 *
 */
public class ProductService {
	
	
	private ProductDao dao;
	
	public void setDao(ProductDao dao) {
		this.dao = dao;
	}
	
	public void 신규상품등록() {
		dao.insertProduct();
	}
	
	public void 상품상세조회() {
		dao.getProduct();
	}
	
	public void 상품정보수정() {
		dao.updateProduct();
	}
}
