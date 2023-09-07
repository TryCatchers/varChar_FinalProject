package com.varchar.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varchar.biz.category.CategoryService;
import com.varchar.biz.category.CategoryVO;
import com.varchar.biz.hashtag.HashtagDetailService;
import com.varchar.biz.hashtag.HashtagDetailVO;
import com.varchar.biz.review.ReviewVO;
import com.varchar.biz.tea.TeaVO;

@Controller
public class adminHashtagController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private HashtagDetailService hashtagDetailService;
	
	// --------------------------------- 상품 해시태그 관리 페이지 이동 ---------------------------------
	@RequestMapping(value = "/adminHashtagTea.do", method=RequestMethod.GET)
	public String adminHashtagTeaPage(Model model) {
		
		List<CategoryVO> categoryDatas = categoryService.selectAll(null); //이거 NULL 없애는 방향 고려
		model.addAttribute("categoryDatas", categoryDatas);
		
		return "adhashTag.jsp";
	}
	// --------------------------------- 상품 해시태그 관리(추가/변경/삭제) ---------------------------------
	@RequestMapping(value = "/adminHashtagTea.do", method=RequestMethod.POST)
	public String adminHashtagTea() {
		
		//hashtagDetailVO.setCondition("현재 해당 쿼리 없음 추후 맞는 서치컨디션 입력"); 
		
		
		return "adhashTag.jsp";
	}
	
	// --------------------------------- 리뷰 해시태그 관리 페이지 이동 ---------------------------------
	@RequestMapping(value = "/adminHashtagReview.do", method=RequestMethod.GET)
	public String adminHashtagReviewPage() {
		return "adhashTagRw.jsp";
	}
	// --------------------------------- 리뷰 해시태그 관리(추가/변경/삭제) ---------------------------------
	@RequestMapping(value = "/adminHashtagReview.do", method=RequestMethod.POST)
	public String adminHashtagReview() {
		
		return "adhashTagRw.jsp";
	}
	
	
	
	// --------------------------------- 상품 선택시 해당되는 해시태그들 반환 ---------------------------------
	@ResponseBody
	@RequestMapping(value = "/selectTeaHashtag.do")
	public Model selectTeaHashtag(TeaVO teaVO, HashtagDetailVO hashtagDetailVO, Model model) {
		
		// 해당 PK로 상품에 등록되어 있는 해시태그 selectAll
		// 리뷰에 달린 해시태그와 상품에 달린 해시태그 조회 쿼리 동일시 통합 고려
		
		//hashtagDetailVO.setCondition("현재 해당 쿼리 없음 추후 맞는 서치컨디션 입력"); 
		hashtagDetailVO.setItemNum(teaVO.getTeaNum()); // HashtagDetailVO에 임시변수 추가해서 자동 set 고려
		List<HashtagDetailVO> hashtagTeaDatas = hashtagDetailService.selectAll(hashtagDetailVO);
		model.addAttribute("hashtagDatas", hashtagTeaDatas);
		
		return model; // 고민 이거 뭘로 받아야 비동기 쉬울지
	}
	
	// --------------------------------- 후기 선택시 해당되는 해시태그들 반환 ---------------------------------
	@ResponseBody
	@RequestMapping(value = "/selectReviewHashtag.do")
	public Model selectReviewHashtag(ReviewVO reviewVO, HashtagDetailVO hashtagDetailVO ,Model model) {
		
		// 해당 PK로 상품에 등록되어 있는 해시태그 selectAll
		// 리뷰에 달린 해시태그와 상품에 달린 해시태그 조회 쿼리 동일시 통합 고려
		
		//hashtagDetailVO.setCondition("현재 해당 쿼리 없음 추후 맞는 서치컨디션 입력"); 
		hashtagDetailVO.setItemNum(reviewVO.getReviewNum()); // HashtagDetailVO에 임시변수 추가해서 자동 set 고려
		List<HashtagDetailVO> hashtagReviewDatas = hashtagDetailService.selectAll(hashtagDetailVO);
		model.addAttribute("hashtagReviewDatas", hashtagReviewDatas);
		
		return model; // 고민 이거 뭘로 받아야 비동기 쉬울지
	}

}
