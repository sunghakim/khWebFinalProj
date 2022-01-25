package com.web.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.web.model.Manage_AccountDTO;
import com.web.model.Manage_AccountService;
import com.web.model.Manage_CouponDTO;
import com.web.model.Manage_CouponService;
import com.web.model.Manage_ItemCategoryDTO;
import com.web.model.Manage_ItemCategoryService;
import com.web.model.Manage_ItemDTO;
import com.web.model.Manage_ItemService;
import com.web.model.Manage_NoticeDTO;
import com.web.model.Manage_NoticeService;
import com.web.model.Manage_PurchaseDTO;
import com.web.model.Manage_PurchaseService;
import com.web.model.Manage_QuestionDTO;
import com.web.model.Manage_QuestionService;
import com.web.model.Manage_RefundService;
import com.web.model.Manage_ReportDTO;
import com.web.model.Manage_ReportService;

public class View {
//-------------------------------------------------------------
	
	//목록 정보가 필요한 경우
	public void setList(ModelAndView mv, Manage_AccountService Service, int Page) {
		int TotalPageCount = Service.selectTotalPageCount();
		mv.addObject("TotalPageCount", TotalPageCount);
		List<Manage_AccountDTO> List = Service.selectList(Page);
		mv.addObject("List", List);
	}
	
	//DB작업 결과가 필요한 경우
	public void setResult(ModelAndView mv, Manage_AccountService Service, boolean ServiceMethodResult) {
		if (ServiceMethodResult) {
			mv.addObject("res", "success");
		} else {
			mv.addObject("res", "false");
		}
	}
	
//-------------------------------------------------------------
	
	//목록(-1)/단일(else)정보가 필요한 경우
	public void getCouponInfo(ModelAndView mv, Manage_CouponService Service, int Type) {
		if (Type == -1) {
			List<Manage_CouponDTO> DTO = Service.selectList();
			mv.addObject("DTO", DTO);
		} else {
			//필요한 경우 작성
		}
	}
	
	//DB작업(추가/수정/삭제) 결과가 필요한 경우
	public void setCouponResult(ModelAndView mv, Manage_CouponService Service, boolean ServiceMethodResult) {
		if (ServiceMethodResult) {
			mv.addObject("res", "success");
		} else {
			mv.addObject("res", "false");
		}
		getCouponInfo(mv, Service, -1);
	}
	
//-------------------------------------------------------------
	
	//목록(-1)/단일(else)정보가 필요한 경우
	public void getItemCategoryInfo(ModelAndView mv, Manage_ItemCategoryService Service, int Type) {
		//Type: -1인 경우 해당 객체의 리스트를 불러옴, 아닐경우 ID로 간주하여 조회후 단일 객체를 불러온다.
		if (Type == -1) {
			List<Manage_ItemCategoryDTO> List = Service.selectList();
			mv.addObject("List", List);
		} else {
			Manage_ItemCategoryDTO DTO = Service.selectOne(Type);
			mv.addObject("DTO", DTO);
		}
	}
	
	//DB작업(추가/수정/삭제) 결과가 필요한 경우
	public void setItemCategoryResult(ModelAndView mv, Manage_ItemCategoryService Service, boolean ServiceMethodResult) {
		if (ServiceMethodResult) {
			mv.addObject("res", "success");
		} else {
			mv.addObject("res", "false");
		}
		getItemCategoryInfo(mv, Service, -1);
	}
	
//-------------------------------------------------------------
	
	//목록(-1)/단일(else)정보가 필요한 경우
	public void getItemInfo(ModelAndView mv, Manage_ItemService Service, int Type) {
		if (Type == -1) {
			List<Manage_ItemDTO> List = Service.selectList();
			mv.addObject("List", List);
		} else {
			Manage_ItemDTO DTO = Service.selectOne(Type);
			mv.addObject("DTO", DTO);
		}
	}
	
	//DB작업(추가/수정/삭제) 결과가 필요한 경우
	public void setItemResult(ModelAndView mv, Manage_ItemService Service, boolean ServiceMethodResult) {
		if (ServiceMethodResult) {
			mv.addObject("res", "success");
		} else {
			mv.addObject("res", "false");
		}
		getItemInfo(mv, Service, -1);
	}
	
//-------------------------------------------------------------

	//목록(-1)/단일(else)정보가 필요한 경우
	public void getReportInfo(ModelAndView mv, Manage_ReportService Service, int Type) {
		if (Type == -1) {
			List<Manage_ReportDTO> List = Service.selectList();
			mv.addObject("List", List);
		} else {
			Manage_ReportDTO DTO = Service.selectOne(Type);
			mv.addObject("DTO", DTO);
		}
	}
	
	//DB작업(추가/수정/삭제) 결과가 필요한 경우
	public void setReportResult(ModelAndView mv, Manage_ReportService Service, boolean ServiceMethodResult) {
		if (ServiceMethodResult) {
			mv.addObject("res", "success");
		} else {
			mv.addObject("res", "false");
		}
		getReportInfo(mv, Service, -1);
	}
	
//-------------------------------------------------------------

	//목록(-1)/단일(else)정보가 필요한 경우
	public void getNoticeInfo(ModelAndView mv, Manage_NoticeService Service, int Type) {
		if (Type == -1) {
			List<Manage_NoticeDTO> List = Service.selectList();
			mv.addObject("List", List);
		} else {
			Manage_NoticeDTO DTO = Service.selectOne(Type);
			mv.addObject("DTO", DTO);
		}
	}
	
	//DB작업(추가/수정/삭제) 결과가 필요한 경우
	public void setNoticeResult(ModelAndView mv, Manage_NoticeService Service, boolean ServiceMethodResult) {
		if (ServiceMethodResult) {
			mv.addObject("res", "success");
		} else {
			mv.addObject("res", "false");
		}
		getNoticeInfo(mv, Service, -1);
	}
	
//-------------------------------------------------------------

	//목록(-1)/단일(else)정보가 필요한 경우
	public void getRefundInfo(ModelAndView mv, Manage_RefundService Service, int Type) {
		if (Type == -1) {
			List<Manage_PurchaseDTO> List = Service.selectList();
			mv.addObject("List", List);
		} else {
			Manage_PurchaseDTO DTO = Service.selectOne(Type);
			mv.addObject("DTO", DTO);
		}
	}
	
	//DB작업(추가/수정/삭제) 결과가 필요한 경우
	public void setRefundResult(ModelAndView mv, Manage_RefundService Service, boolean ServiceMethodResult) {
		if (ServiceMethodResult) {
			mv.addObject("res", "success");
		} else {
			mv.addObject("res", "false");
		}
		getRefundInfo(mv, Service, -1);
	}
	
//-------------------------------------------------------------

	//목록(-1)/단일(else)정보가 필요한 경우
	public void getPurchaseInfo(ModelAndView mv, Manage_PurchaseService Service, int Type) {
		if (Type == -1) {
			List<Manage_PurchaseDTO> List = Service.selectList();
			mv.addObject("List", List);
		} else {
			Manage_PurchaseDTO DTO = Service.selectOne(Type);
			mv.addObject("DTO", DTO);
		}
	}
	
	//DB작업(추가/수정/삭제) 결과가 필요한 경우
	public void setPurchaseResult(ModelAndView mv, Manage_PurchaseService Service, boolean ServiceMethodResult) {
		if (ServiceMethodResult) {
			mv.addObject("res", "success");
		} else {
			mv.addObject("res", "false");
		}
		getPurchaseInfo(mv, Service, -1);
	}
	
//-------------------------------------------------------------

	//목록(-1)/단일(else)정보가 필요한 경우
	public void getQuestionInfo(ModelAndView mv, Manage_QuestionService Service, int Type) {
		if (Type == -1) {
			List<Manage_QuestionDTO> List = Service.selectList();
			mv.addObject("List", List);
		} else {
			Manage_QuestionDTO DTO = Service.selectOne(Type);
			mv.addObject("DTO", DTO);
		}
	}
	
	//DB작업(추가/수정/삭제) 결과가 필요한 경우
	public void setQuestionResult(ModelAndView mv, Manage_QuestionService Service, boolean ServiceMethodResult) {
		if (ServiceMethodResult) {
			mv.addObject("res", "success");
		} else {
			mv.addObject("res", "false");
		}
		getQuestionInfo(mv, Service, -1);
	}
	
//-------------------------------------------------------------

	//통계 페이지 뷰
	public void getStatistics(ModelAndView mv, Manage_PurchaseService Service) {
		
	}
}
