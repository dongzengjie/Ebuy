package com.example.demo.dzj.ebuy.service.serviceimpl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dzj.ebuy.dao.BigTypeDao;
import com.example.demo.dzj.ebuy.entity.Bigtype;
import com.example.demo.dzj.ebuy.service.BigtypeService;

@SuppressWarnings("all")
@Service
public class BigtypeImpl implements BigtypeService {

	@Autowired
	private BigTypeDao bigtypedao;

	@Autowired
	private RedisTemplate redisTemplate;

	private final String keyList = "QUERYBIGTYPELIST";

	private final String keyAllType = "QUERYALLTYPE7";

	/**
	 * 查询付分类
	 */
	@Transactional
	public List<Bigtype> queryBigtypeList() {
		ValueOperations<String, Object> opv = redisTemplate.opsForValue();

		boolean hasKey = redisTemplate.hasKey(keyList);
		if (hasKey) {
			return (List<Bigtype>) opv.get(keyList);
		}
		List<Bigtype> bigTypeList = bigtypedao.queryBigtype();
		opv.set(keyList, bigTypeList);

		return bigTypeList;

	}

	@Transactional
	public List<Bigtype> queryAllType() {

		ValueOperations<String, Object> opv = redisTemplate.opsForValue();

		boolean hasKey = redisTemplate.hasKey(keyAllType);
		
	
		if (hasKey) {
			return (List<Bigtype>) opv.get(keyAllType);
		}
		List<Bigtype> bigTypeList = bigtypedao.queryBigtypeAndSmallType();
	
		opv.set(keyAllType, bigTypeList);
		return bigTypeList;

	}

}
