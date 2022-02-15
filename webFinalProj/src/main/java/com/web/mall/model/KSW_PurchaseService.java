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
	Manage_AccountService AccountService;
	@Autowired
	Manage_SoldHistoryService SoldHistoryService;
	@Autowired
	Manage_ItemService ItemService;
	@Autowired
	ShoppingListService ShoppingListService;

	@Transactional(rollbackFor=Exception.class)
	public void purchase(List<ShoppingListVO> list) throws Exception {
		String AccountID = list.get(0).getAccount_id();
		Manage_AccountDTO AccountDTO = AccountService.selectOne(AccountID);
		Manage_SoldHistoryDTO SoldHistoryDTO = new Manage_SoldHistoryDTO();
		SoldHistoryDTO.setAccountID(AccountDTO.getAccountID());
		SoldHistoryDTO.setAddress(AccountDTO.getAddress());
		SoldHistoryDTO.setRecieverName(AccountDTO.getName());
		SoldHistoryDTO.setRecieverPhone(AccountDTO.getPhone());
		SoldHistoryDTO.setOrderDate(new Date());
		SoldHistoryService.insertSoldHistory(SoldHistoryDTO);
		
		for (ShoppingListVO vo :list) {
			//2. SOLD_DETAIL db에 결제내역 추가
			SoldHistoryDTO.setAmount(vo.getAmount());
			
			Manage_ItemDTO ItemDTO = ItemService.selectItemID(vo.getItem_id());
			SoldHistoryDTO.setName(ItemDTO.getName());
			SoldHistoryDTO.setPrice(ItemDTO.getPrice());
			
			ItemDTO = ItemService.selectItemOptionID(vo.getItem_option_id());
			SoldHistoryDTO.setItemSize(ItemDTO.getItemSize());
			SoldHistoryDTO.setColor(ItemDTO.getColor());
			
			SoldHistoryService.insertSoldDetail(SoldHistoryDTO);
			
			//3. SHOPPING_LIST db에서 해당 데이터 삭제
			ShoppingListService.deleteOne(vo);
			
			//4. 외부 결제 api 사용하는 방법 알아보기
		}
	}
}