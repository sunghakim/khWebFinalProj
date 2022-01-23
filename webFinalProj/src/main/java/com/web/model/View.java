package com.web.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public class View {
	//관리자인지, 로그인 했는지 확인, 접근할 페이지 대상 설정
	public int isManager(ModelAndView mv, HttpSession session, String NextPage) {
		Manage_AccountDTO AccountDTO;
		if (session.getAttribute("Logined_Account") != null) {
			//로그인된 경우
			AccountDTO = (Manage_AccountDTO)session.getAttribute("Logined_Account");
			if(AccountDTO.getUser_Type() == 0) {
				//로그인된 계정의 권한이 관리자인 경우
				mv.setViewName(NextPage);//접근할 페이지 설정
				return 0;
			} else {
				//권한 부족, 접근 거부
				mv.addObject("res", "AccessDenied");
				mv.setViewName("redirect:/");
				return 1;
			}
		} else {
			//로그인 되지 않은 경우
			mv.addObject("NextPage", NextPage);//로그인 후 해당페이지로 안내
			mv.setViewName("redirect:/Account/Login?NextURL=" + NextPage);
			return 2;
		}
	}
	
//-------------------------------------------------------------
	
	//목록(-1)/단일(else)정보가 필요한 경우
	public void getAccountInfo(ModelAndView mv, Manage_AccountService Service, int Type) {
		if (Type == -1) {
			List<Manage_AccountDTO> DTO = Service.selectList();
			mv.addObject("DTO", DTO);
		} else {
			//필요한 경우 작성
		}
	}
	
	//DB작업(추가/수정/삭제) 결과가 필요한 경우
	public void setAccountResult(ModelAndView mv, Manage_AccountService Service, boolean ServiceMethodResult) {
		if (ServiceMethodResult) {
			mv.addObject("res", "success");
		} else {
			mv.addObject("res", "false");
		}
		getAccountInfo(mv, Service, -1);
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
			List<Manage_RefundDTO> List = Service.selectList();
			mv.addObject("List", List);
		} else {
			Manage_RefundDTO DTO = Service.selectOne(Type);
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
	public void getStatistics(ModelAndView mv, Manage_PurchaseService Service, int Type) {
		if (Type == -1) {
			List<Manage_QuestionDTO> List = Service.selectList();
			mv.addObject("List", List);
		} else {
			Manage_QuestionDTO DTO = Service.selectOne(Type);
			mv.addObject("DTO", DTO);
		}
	}
}
