package com.web.mall.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KSW_PurchaseService extends Manage_S_Module {
	
	@Autowired
	KSW_PurchaseDAO dao;

	@Transactional(rollbackFor=Exception.class)
	public void purchase(List<ShoppingListVO> list) throws Exception{
		for (ShoppingListVO vo :list) {
			//1. SOLD_HISTORY db에 주문내역 추가
			
			
			//2. SOLD_DETAIL db에 결제내역 추가
			
			
			//3. SHOPPING_LIST db에서 해당 데이터 삭제
			
			
			//4. 외부 결제 api 사용하는 방법 알아보기
			
			
			vo.getShopping_list_id();
			vo.getAccount_id();
			vo.getItem_id();
			vo.getItem_option_id();
			vo.getAmount();
//			if() {
//				Manage_SoldHistoryDTO dto = new Manage_SoldHistoryDTO();
//			}
		}
	}
}
