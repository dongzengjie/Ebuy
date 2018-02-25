package com.example.demo.dzj.ebuy.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dzj.ebuy.dao.SmallTypeDao;
import com.example.demo.dzj.ebuy.entity.Smalltype;
import com.example.demo.dzj.ebuy.service.SmallTypeService;

@Service
public class SmallTypeServiceImpl implements SmallTypeService {

	@Autowired
	private SmallTypeDao smalltypeDao;
	
	@Transactional
	public int addSmallType(Smalltype smalltype) {
	
		return smalltypeDao.insertSmallType(smalltype);
	}

	
	public List<Smalltype> querySmallTypeByBigIdandShopId(Long bigtypeId, Long shopId) {
		
		return smalltypeDao.querySmallTypeBybigIdandShopId(bigtypeId, shopId);
	}


	@Transactional
	public Smalltype qureySmallTypeBySmallidandShopId(Long smalltypeId, Long shopId) {
		
		return smalltypeDao.querySmallTypeBySmallidandShopId(smalltypeId, shopId);
	}


	@Override
	public int updateSmallTypeBySmallIdandShopId(Long smalltypeId, Long shopId, String name) {
	
		return smalltypeDao.updateSmallTypeBySmallIdandShopId(smalltypeId, shopId, name);
	}

}
