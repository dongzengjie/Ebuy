package com.example.demo.dzj.ebuy.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dzj.ebuy.dao.ShopDao;
import com.example.demo.dzj.ebuy.dto.ShopExecution;
import com.example.demo.dzj.ebuy.entity.Shop;
import com.example.demo.dzj.ebuy.enums.ShopEnum;
import com.example.demo.dzj.ebuy.exception.ShopException;
import com.example.demo.dzj.ebuy.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	
	/**
	 * 添加店铺
	 */
	@Transactional
	public ShopExecution addShop(Shop shop) throws ShopException {
		
		if(shop !=null && shop.getUser().getUserId() !=null ) {
			
			int effect =shopDao.insertShopInfo(shop);
			if(effect<=0) {
				return new ShopExecution(ShopEnum.INNER_ERROR);
			}
			
		}else {
			
			return new ShopExecution(ShopEnum.INNER_ERROR);
		}
		return  new ShopExecution(ShopEnum.SUCCESS,shop);
		
	}

	@Transactional
	public ShopExecution queryShopByUserId(Long userId) throws ShopException {
		
		ShopExecution shopExecution =new ShopExecution();
		if(userId != null) {
			try {
				Shop shop=shopDao.queryShopInfoByUserId(userId);
				if(shop !=null) {
					shopExecution.setShop(shop);
					shopExecution.setState(ShopEnum.SUCCESS.getState());
				}else {
					shopExecution.setState(ShopEnum.EMPTY.getState());
				}
				
			} catch (Exception e) {
				throw new ShopException("查询失败");
			}
		}else {
			return new ShopExecution(ShopEnum.QUERY_ERROR);
		}
		return shopExecution;
	}

}
