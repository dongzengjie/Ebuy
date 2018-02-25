package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dzj.ebuy.entity.Bigtype;
import com.example.demo.dzj.ebuy.service.BigtypeService;
import com.example.demo.dzj.ebuy.util.OrderIdUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BigtypeTest {

	@Autowired
	private BigtypeService bigtypeService;
	
	@Test
	public void testquery() {
		/*List<Bigtype> bigtypeslist =bigtypeService.queryBigtypeList();
		for (Bigtype bigtype : bigtypeslist) {
			System.out.println(bigtype.getBigName());
		}*/
		/*SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd"); 
		System.out.println(time.format(new Date()));*/
	/*	
		String aa=OrderIdUtil.getOrderIdByUUId();
		System.out.println(aa);*/
	}
	
}
