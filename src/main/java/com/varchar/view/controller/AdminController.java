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
import com.varchar.biz.hashtag.HashtagDetailVO;
import com.varchar.biz.hashtag.ReviewHashtagService;
import com.varchar.biz.hashtag.TeaHashtagService;
import com.varchar.biz.hashtag.TeaHashtagVO;
import com.varchar.biz.review.ReviewService;
import com.varchar.biz.tea.TeaService;
import com.varchar.biz.tea.TeaVO;

//@Controller
//public class AdminController {
//	
//	@Autowired
//	private TeaService teaService;
//	
//	@Autowired
//	private ReviewService reviewService;
//	
//	@Autowired
//	private TeaHashtagService teaHashtagService;
//	
//	@Autowired
//	private ReviewHashtagService reviewHashtagService;
//	
//	@Autowired
//	private HashtagDetailService hashtagDetailService;
//	
//	@Autowired
//	private CategoryService categoryService;
//	
//	// 상품 해시태그 관리 페이지 이동 @RequestMapping(value = "/adminHashtagTea.do", method=RequestMethod.GET)
//	@RequestMapping(value = "/adhashTagPage.do")
//	public String adhashTagPage(TeaVO teaVO, CategoryVO categoryVO, TeaHashtagVO teaHashtagVO, HashtagDetailVO hashtagDetailVO,Model model) {
//		
//		
//		System.out.println("CategoryName : " + categoryVO.getCategoryName());
//		
//		List<CategoryVO> categoryDatas=categoryService.selectAll(categoryVO);
//		model.addAttribute("categoryDatas", categoryDatas);
//		
//		return "adhashTag.jsp";
//	}
//	
//	// 리뷰 해시태그 관리 페이지 이동 @RequestMapping(value = "/adminHashtagReview.do", method=RequestMethod.GET)
//	@RequestMapping(value= "/adhashTagRwPage.do")
//	public String adhashTagRwPage(TeaVO teaVO, CategoryVO categoryVO, TeaHashtagVO teaHashtagVO, HashtagDetailVO hashtagDetailVO,Model model) {
//		System.out.println("CategoryNum : " + categoryVO.getCategoryNum());
//		List<CategoryVO> categoryDatas=categoryService.selectAll(categoryVO);
//		model.addAttribute("categoryDatas", categoryDatas);
//		
//		return "adhashTagRw.jsp";
//	}
//	
//	// 상품 추가/수정/삭제 페이지 이동 @RequestMapping(value = "/adminTea.do")
//	@RequestMapping(value="/adteaManagePage.do")
//	public String adteaManagePage(TeaVO teaVO, CategoryVO categoryVO, TeaHashtagVO teaHashtagVO, HashtagDetailVO hashtagDetailVO,Model model) {
//		List<CategoryVO> categoryDatas=categoryService.selectAll(categoryVO);
//		model.addAttribute("categoryDatas", categoryDatas);
//		
//		return "adteaManage.jsp";
//	}
//	
//	// 상품 해시태그 추가/삭제/수정 @RequestMapping(value = "/adminHashtagTea.do", method=RequestMethod.POST)
//	@RequestMapping(value = "/updateHashTag.do", method = RequestMethod.GET)
//	@ResponseBody
//	public String updateHashTag(TeaVO teaVO) {
//	    List<TeaVO> teaproducts = teaService.selectAll(teaVO);
//	    System.out.println(teaproducts);
//	    // List<TeaVO>를 JSON 형식의 문자열로 변환
//	    ObjectMapper objectMapper = new ObjectMapper();
//	    String jsonProducts;
//	    try {
//	        jsonProducts = objectMapper.writeValueAsString(teaproducts);
//	    } catch (JsonProcessingException e) {
//	        // 예외 처리
//	        jsonProducts = "Error converting products to JSON";
//	    }
//
//	    return jsonProducts;
//	}
//	
//	@RequestMapping(value = "/selectTea.do")
//	@ResponseBody // 뷰 리졸버를 막기 위함
//	public String teaList(@RequestParam("category") int categoryNum, TeaVO teaVO) {
//		teaVO.setCategoryNum(categoryNum);
//		teaVO.setTeaCondition("카테고리");
//	    List<TeaVO> teaproducts = teaService.selectAll(teaVO);
//	    System.out.println(teaproducts);
//	    
//	    Gson gson = new Gson();
//	    Map<String, Object> map = new HashMap();	    
//	    JSONObject obj = new JSONObject();
//
//	    for (TeaVO v : teaproducts) {
//	    	obj.put("teaNum", v.getTeaNum());
//			obj.put("teaName", v.getTeaName());
//		}
//	    return gson.toJson(teaproducts);
//	}
//	
//	@RequestMapping(value = "/selectTeaTag.do")
//	@ResponseBody // 뷰 리졸버를 막기 위함
//	public String fixHash(@RequestParam("hashtag") int teaNum, TeaHashtagVO teahashtagVO) {
//		teahashtagVO.setItemNum(teaNum);
//	    List<TeaHashtagVO> teaHashtags = teaHashtagService.selectAll(teahashtagVO);
//	    System.out.println(teaHashtags);
//	    
//	    Gson gson = new Gson();
//	    Map<String, Object> map = new HashMap();	    
//	    JSONObject obj = new JSONObject();
//
//	    return gson.toJson(teaHashtags);
//	}
//}
