package com.jpaToyProject.api.common;

import com.jpaToyProject.api.common.data.BaseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination{

	private int totalRecordCount; 		// 전체 데이터 수
	private int currentPage; 			// 현재 페이지
	private int totalPageCount; 		// 전체 페이지 수
	private int startPage; 				// 첫 페이지 번호
	private int endPage; 				// 끝 페이지 번호
	private int limitStart; 			// LIMIT 시작 위치
	private boolean existPrevPage; 		// 이전 페이지 존재 여부
	private boolean existNextPage; 		// 다음 페이지 존재 여부
	private String presentationHtml; 	// 화면에 표시할 페이지 목록 HTML

	private int recordSize;			// 페이지당 레코드 수
	private int pageSize;			// 화면당 페이지 수


	/**
	 * baseDto를 상속한 객체를 사용한 생성자 ( 현재 적용중 )
	 * @param totalRecordCount 조회 전체 건수
	 * @param baseDto 검색조건 객체
	 */
	public Pagination(int totalRecordCount, BaseDto baseDto ){
		this.currentPage = baseDto.getPage() > 0 ? baseDto.getPage(): 1 ;				// 현재 페이지
		this.recordSize = baseDto.getRecordSize() > 0 ? baseDto.getRecordSize() : 10 ;	// 페이지장 레코드 수
		this.pageSize = baseDto.getPageSize() > 0 ? baseDto.getPageSize() : 10 ;		// 화면당 레코드 수
		setTotalRecordCount(totalRecordCount);
	}

	private void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
		// if (totalRecordCount <1 ) return;

		totalPageCount = ((totalRecordCount - 1) / recordSize) + 1;					// 전체 페이지 수 계산
		if(totalPageCount==0)	totalPageCount=1;
		if (currentPage > totalPageCount) currentPage = totalPageCount;						// 현재 페이지 보정

		startPage = ((currentPage - 1) / pageSize ) * pageSize + 1;	// 페이지목록의 첫번째 페이지 번호
		endPage = startPage + pageSize - 1;										// 페이지목록의 마지막 페이지 번호

		if (endPage > totalPageCount) endPage = totalPageCount;								// 끝 페이지 보정

		limitStart = (currentPage - 1) * recordSize;								// LIMIT 시작 위치 계산

		existPrevPage = startPage != 1;														// 이전 페이지 존재 여부 확인
		existNextPage = (endPage * recordSize ) < totalRecordCount;					// 다음 페이지 존재 여부 확인

		presentationHtml = makePresentationHTML();											// 화면표시 페이지 목록 생성
	}

	private String makePresentationHTML() {
		String presentationHTML = "";
		presentationHTML =
		"<div class=\"pagination gap-2 flex-wrap justify-content-center align-items-center\">";		// pagination : 숫자 사각형, gap-2 : 페이지도형 간격 flex-wrap : 페이지동형 줄바꿈, 수직정렬

		// FirstPage
		presentationHTML += startPage == 1
			? String.format(
				"<li class=\"page-item pagination-item disabled\">"
			+        "<a class=\"page-link\" href=\"javascript:void(0);\" onclick=\"movePage(1)\" aria-label=\"First\">"
			+            "<span aria-hidden=\"true\">&laquo;&laquo;</span>"
			+        "</a>"
			+    "</li>")
			: String.format(
				"<li class=\"page-item pagination-item\">"
			+        "<a class=\"page-link\" href=\"javascript:void(0);\" onclick=\"movePage(1)\" aria-label=\"First\">"
			+            "<span aria-hidden=\"true\">&laquo;&laquo;</span>"
			+        "</a>"
			+    "</li>")
			;

		// Previous Page,  시작 페이지(startPage)가 1이 아닌 경우 첫 페이지 버튼과 이전 페이지 버튼을 HTML에 추가
		//if (existPrevPage) {
			presentationHTML += existPrevPage
				? String.format(
					"<li class=\"page-item pagination-item\">"
				+		"<a class=\"page-link\" href=\"javascript:void(0);\" onclick=\"movePage(%d)\" aria-label=\"Previous\">"
				+			"<span aria-hidden=\"true\">&laquo;</span>"
				+    	"</a>"
				+   "</li>"
					,startPage> 10?startPage - 10: 1 )
				: String.format(
						"<li class=\"page-item pagination-item disabled\">"
					+	"<a class=\"page-link\" href=\"#\" aria-label=\"Previous\">"
					+	"<span aria-hidden=\"true\">&laquo;</span>"
					+    "</a>"
					+   "</li>"
					)
			;
		//}

		/*
		 * 시작 페이지(startPage)와 끝 페이지(endPage) 사이의 페이지 번호(i)를 넘버링 하는 로직 페이지 번호(i)와 현재
		 * 페이지 번호(params.page)가 동일한 경우, 페이지 번호(i)를 활성화(on) 처리
		 */
//		presentationHTML += "<p>";
//		for (int i = startPage; i <= endPage; i++) {
//			presentationHTML += (i != currentPage)
//					? String.format("<a href=\"javascript:void(0);\" onclick=\"movePage(%d);\">%d</a>", i, i)
//					: String.format("<span class=\"on\">%d</span>", i);
//		}
//		presentationHTML += "</p>";

		//페이지 목록
		for (int i = startPage; i <= endPage; i++) {
			presentationHTML += (i != currentPage)
					? String.format("<li class=\"page-item pagination-item \"><a class=\"page-link\" href=\"javascript:void(0);\" onclick=\"movePage(%d);\">%d</a></li>",i,i)
					: String.format("<li class=\"page-item pagination-item active\" aria-current=\"page\">"
									+ 	"<span class=\"page-link\">%d</span>"
									+"</li>", i);
		}

		// 다음 페이지 설정
		presentationHTML += existNextPage
			? String.format(
				"<li class=\"page-item pagination-item\">"
			+		"<a class=\"page-link\" href=\"javascript:void(0);\" onclick=\"movePage(%d);\" aria-label=\"Next\">"
			+			"<span aria-hidden=\"true\">&raquo;</span>"
			+		"</a>"
			+	"</li>"
			,endPage + 1)
			: String.format(
					"<li class=\"page-item pagination-item disabled\">"
				+		"<a class=\"page-link\" href=\"#\" aria-label=\"Next\">"
				+			"<span aria-hidden=\"true\">&raquo;</span>"
				+		"</a>"
				+	"</li>"
				);

		// 마지막 페이지 버튼 설정
		presentationHTML += currentPage == totalPageCount
			? String.format(
					"<li class=\"page-item pagination-item disabled\">"
				+		"<a class=\"page-link\" href=\"#\" aria-label=\"Last\">"
				+			"<span aria-hidden=\"true\">&raquo;&raquo;</span>"
				+		"</a>"
				+	"</li>"
				)
			: String.format(
					"<li class=\"page-item pagination-item\">"
				+		"<a class=\"page-link\" href=\"javascript:void(0);\" onclick=\"movePage(%d);\" aria-label=\"Last\">"
				+			"<span aria-hidden=\"true\">&raquo;&raquo;</span>"
				+		"</a>"
				+	"</li>"
				,totalPageCount);

		presentationHTML += "</div>";
		return presentationHTML;
	}
}
