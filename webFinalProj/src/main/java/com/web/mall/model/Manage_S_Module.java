package com.web.mall.model;

public class Manage_S_Module {
	//서비스에서 중복되는 로직을 모듈화한다.
	
	//전체게시글 갯수를 페이지수로 변환하여 반환
	public int PostCountToPageCount(int result) {
		if (result < 11) {
			return 1;
		} else {
			return (result/10)+1;
		}
	}
}
