package com.web.mall.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KSW_PurchaseService extends Manage_S_Module {
	
	@Autowired
	KSW_PurchaseDAO dao;
	@Autowired
	Manage_AccountService Manage_AccountService;
	@Autowired
	Manage_SoldHistoryService Manage_SoldHistoryService;

	@Autowired
	Manage_ItemService Manage_ItemService;

	@Transactional(rollbackFor=Exception.class)
	public void purchase(List<ShoppingListVO> list) throws Exception{
		//1. SOLD_HISTORY db에 주문내역 추가
		String AccountID = list.get(0).getAccount_id();
		Manage_AccountDTO AccountDTO = Manage_AccountService.selectOne(AccountID);
		Manage_SoldHistoryDTO SoldHistoryDTO = new Manage_SoldHistoryDTO();
		SoldHistoryDTO.setAccountID(AccountDTO.getAccountID());
		SoldHistoryDTO.setAddress(AccountDTO.getAddress());
		SoldHistoryDTO.setRecieverName(AccountDTO.getName());
		SoldHistoryDTO.setRecieverPhone(AccountDTO.getPhone());
		SoldHistoryDTO.setOrderDate(new Date());
		Manage_SoldHistoryService.insertSoldHistory(SoldHistoryDTO);
		
		for (ShoppingListVO vo :list) {
			//2. SOLD_DETAIL db에 결제내역 추가
			SoldHistoryDTO.setAmount(vo.getAmount());
			
			Manage_ItemDTO ItemDTO = Manage_ItemService.selectOne(vo.getItem_id());
			SoldHistoryDTO.setName(ItemDTO.getName());
			SoldHistoryDTO.setPrice(ItemDTO.getPrice());
			
			Manage_Item
			
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