package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dzj.ebuy.dao.BigTypeDao;
import com.example.demo.dzj.ebuy.dao.SmallTypeDao;
import com.example.demo.dzj.ebuy.entity.Bigtype;
import com.example.demo.dzj.ebuy.entity.Smalltype;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDaoTest {

	@Autowired
	private SmallTypeDao smallTypeDao;
	
	@Autowired
	private BigTypeDao bigtypeDao;
	
	@Test
	public void testBigDao() {
		/*List<Bigtype> list= bigtypeDao.queryBigtypeAndSmallType();
		for (Bigtype bigtype : list) {
			List<Smalltype> smalllist=bigtype.getSmalltypelist();
			for (Smalltype smalltype : smalllist) {
				System.out.println(smalltype.getSmallName());
			}
		}*/
	}

	@Test
	public void testSmalltype() {
		/*List<Smalltype> list = smallTypeDao.querySmallTypeBybigIdandShopId(1L, 2L);
		 for (Smalltype smalltype : list) { System.out.println(smalltype.getSmallName()); }
		

		List<Smalltype> list1 = smallTypeDao.querySmallTypeByBigId(1L);*/
		
		/*for (Smalltype smalltype : list1) {
			System.out.println(smalltype.getName());
		}
*/
	
		
		
	}
	/*@Test
	public void insertsmall() {
		Smalltype smalltype =new Smalltype();
		smalltype.setBigtypeId(2l);
		smalltype.setSmallName("手机");
		smalltype.setRemarks("asasas");
		smalltype.setShopId(1L);
		int i=smallTypeDao.insertSmallType(smalltype);
		System.out.println(i+"=asxasdasdasdasdas");
		
	}*/
/*	@Test
	public void delete() {
		Smalltype smalltype =smallTypeDao.querySmallTypeBySmallidandShopId(6L, 2L);
		System.out.println(smalltype.getSmallName());
	}*/
	
	/*@Test
	public void update() {
		smallTypeDao.updateSmallTypeBySmallIdandShopId(6L, 2L, "连衣裙测试");
	}*/
}
