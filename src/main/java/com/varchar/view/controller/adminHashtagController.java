package com.varchar.view.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.varchar.biz.category.CategoryService;
import com.varchar.biz.category.CategoryVO;
import com.varchar.biz.hashtag.HashtagDetailService;
import com.varchar.biz.hashtag.ReviewHashtagService;
import com.varchar.biz.hashtag.ReviewHashtagVO;
import com.varchar.biz.hashtag.TeaHashtagService;
import com.varchar.biz.hashtag.TeaHashtagVO;
import com.varchar.biz.review.ReviewService;
import com.varchar.biz.review.ReviewVO;
import com.varchar.biz.tea.TeaService;
import com.varchar.biz.tea.TeaVO;

@Controller
public class AdminHashtagController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private HashtagDetailService hashtagDetailService;
	@Autowired
	private TeaHashtagService teaHashtagService;
	@Autowired
	private ReviewHashtagService reviewHashtagService;
	@Autowired
	private TeaService teaService;
	@Autowired
	private ReviewService reviewService;
	
	// --------------------------------- 상품 해시태그 관리 페이지 이동 ---------------------------------
	@RequestMapping(value = "/adminHashtagTea.do", method=RequestMethod.GET)
	public String adminHashtagTeaPage(Model model) {
		
		List<CategoryVO> categoryDatas = categoryService.selectAll(null); //이거 NULL 없애는 방향 고려
		model.addAttribute("categoryDatas", categoryDatas);
		
		return "adhashTag.jsp";
	}
	// ---------------------------------!!!! 상품 해시태그 관리(추가/변경/삭제) !!!!---------------------------------
	@RequestMapping(value = "/adminHashtagTea.do", method=RequestMethod.POST)
	@ResponseBody
	public String adminHashtagTea(TeaVO teaVO) {
	    List<TeaVO> teaproducts = teaService.selectAll(teaVO);
	    System.out.println(teaproducts);
	    // List<TeaVO>를 JSON 형식의 문자열로 변환
	    ObjectMapper objectMapper = new ObjectMapper();
	    String jsonProducts;
	    try {
	        jsonProducts = objectMapper.writeValueAsString(teaproducts);
	    } catch (JsonProcessingException e) {
	        // 예외 처리
	        jsonProducts = "Error converting products to JSON";
	    }

	    return jsonProducts;
	}
	
	// --------------------------------- 리뷰 해시태그 관리 페이지 이동 ---------------------------------
	@RequestMapping(value = "/adminHashtagReview.do", method=RequestMethod.GET)
	public String adminHashtagReviewPage(Model model) {
		
		List<CategoryVO> categoryDatas = categoryService.selectAll(null); //이거 NULL 없애는 방향 고려
		model.addAttribute("categoryDatas", categoryDatas);
		
		return "adhashTagRw.jsp";
	}
	// ---------------------------------!!!! 리뷰 해시태그 관리(추가/변경/삭제) !!!!---------------------------------
	@RequestMapping(value = "/adminHashtagReview.do", method=RequestMethod.POST)
	@ResponseBody
	public String adminHashtagReview(ReviewVO reviewVO) {
	    List<ReviewVO> reviewproducts = reviewService.selectAll(reviewVO);
	    System.out.println(reviewproducts);
	    // List<TeaVO>를 JSON 형식의 문자열로 변환
	    ObjectMapper objectMapper = new ObjectMapper();
	    String jsonProducts;
	    try {
	        jsonProducts = objectMapper.writeValueAsString(reviewproducts);
	    } catch (JsonProcessingException e) {
	        // 예외 처리
	        jsonProducts = "Error converting products to JSON";
	    }

	    return jsonProducts;
	}
	
	// --------------------------------- 카테고리 선택시 해당되는 상품들 반환 ---------------------------------
	@RequestMapping(value = "/selectTea.do")
	@ResponseBody // 뷰 리졸버를 막기 위함
	public String teaList(@RequestParam("category") int categoryNum, TeaVO teaVO) {
		teaVO.setCategoryNum(categoryNum);
		teaVO.setTeaCondition("카테고리");
	    List<TeaVO> teaproducts = teaService.selectAll(teaVO);
	    System.out.println(teaproducts);
	    
	    Gson gson = new Gson();
	    Map<String, Object> map = new HashMap();	    
	    JSONObject obj = new JSONObject();

	    for (TeaVO v : teaproducts) {
	    	obj.put("teaNum", v.getTeaNum());
			obj.put("teaName", v.getTeaName());
		}
	    return gson.toJson(teaproducts);
	}
	
	// --------------------------------- 상품 선택시 해당되는 후기들 반환 ---------------------------------
	@RequestMapping(value = "/selectReview.do")
	@ResponseBody // 뷰 리졸버를 막기 위함
	public String reviewList(@RequestParam("tea") int teaNum, ReviewVO reviewVO) {
		reviewVO.setTeaNum(teaNum);
		reviewVO.setSearchName("DETAIL"); // 해당 상품의 후기들 반환
		List<ReviewVO> reviewDatas = reviewService.selectAll(reviewVO);
		System.out.println(reviewDatas);
		
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap();	    
		JSONObject obj = new JSONObject();
		
		for (ReviewVO v : reviewDatas) {
			obj.put("reviewNum", v.getReviewNum());
			obj.put("reviewName", v.getReviewContent());
			obj.put("memberId", v.getMemberId());
		}
		return gson.toJson(reviewDatas);
	}
	
	// --------------------------------- 상품 선택시 해당되는 해시태그들 반환 ---------------------------------
	@RequestMapping(value = "/selectTeaTag.do")
	@ResponseBody // 뷰 리졸버를 막기 위함
	public String selectTeaHashtag(@RequestParam("hashtag") int teaNum, TeaHashtagVO teahashtagVO) {
		teahashtagVO.setItemNum(teaNum);
	    List<TeaHashtagVO> teaHashtags = teaHashtagService.selectAll(teahashtagVO);
	    System.out.println(teaHashtags);
	    
	    Gson gson = new Gson();
	    Map<String, Object> map = new HashMap();	    
	    JSONObject obj = new JSONObject();

	    return gson.toJson(teaHashtags);
	}
	
	// --------------------------------- 후기 선택시 해당되는 해시태그들 반환 ---------------------------------
	@ResponseBody
	@RequestMapping(value = "/selectReviewTag.do")
	public String selectReviewHashtag(@RequestParam("hashtag") int reviewNum, ReviewHashtagVO reviewHashtagVO) {
		
		reviewHashtagVO.setItemNum(reviewNum);
	    List<ReviewHashtagVO> reviewHashtags = reviewHashtagService.selectAll(reviewHashtagVO);
	    System.out.println(reviewHashtags);
	    
	    Gson gson = new Gson();
	    Map<String, Object> map = new HashMap();	    
	    JSONObject obj = new JSONObject();

	    return gson.toJson(reviewHashtags);
	}

}
