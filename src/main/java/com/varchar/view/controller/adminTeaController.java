package com.varchar.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varchar.biz.category.CategoryService;
import com.varchar.biz.category.CategoryVO;
import com.varchar.biz.tea.TeaService;
import com.varchar.biz.tea.TeaVO;

//
//@Controller
//public class AdminTeaController {
//	
//	@Autowired
//	private CategoryService categoryService;
//	@Autowired
//	private TeaService teaService;
//
//	
//	// --------------------------------- 관리자 홈(메인) 페이지 이동 ---------------------------------
//	@RequestMapping(value = "/admin.do")
//	public String adminPage(CategoryVO categoryVO, Model model) {
//		
//		List<CategoryVO> categoryDatas = categoryService.selectAll(null); //이거 NULL 없애는 방향 고려
//		model.addAttribute("categoryDatas", categoryDatas);
//		return "admin.jsp";
//	}
//	
//	// --------------------------------- 카테고리 추가 ---------------------------------
//	@RequestMapping(value = "/insertCategory.do")
//	public String insertCategory(CategoryVO categoryVO) {
//		
//		if(categoryService.insert(categoryVO)) {
//			
//		}
//		
//		return "admin.do";
//	}
//	
//	// --------------------------------- 카테고리 삭제 ---------------------------------
//	@RequestMapping(value = "/deleteCategory.do")
//	public String deleteCategory(CategoryVO categoryVO, TeaVO teaVO) {
//		
//		// 해당되는 카테고리에 있는 상품이 있을 수 있으므로 해당없음으로 변경해줘야 함
//		categoryVO = categoryService.selectOne(categoryVO); // 존재 확인
//		teaVO.setCategoryNum(categoryVO.getCategoryNum());
//		teaService.update(teaVO);
//		
//		//categoryVO.setCategoryCondition("현재 해당 쿼리 없음 추후 맞는 서치컨디션 입력");
//		
//		if(categoryVO != null) {
//			
//			categoryService.update(categoryVO);
//			
//			if(categoryService.delete(categoryVO)) {
//				
//			}
//		}
//		
//		
//		return "admin.do";
//	}
//	
//	// --------------------------------- 카테고리 변경 ---------------------------------
//	@RequestMapping(value = "/updateCategory.do")
//	public String updateCategory(CategoryVO categoryVO, TeaVO teaVO) {
//		
//		// 해당되는 카테고리에 있는 상품이 있을 수 있으므로 해당없음으로 변경해줘야 함
//		categoryVO = categoryService.selectOne(categoryVO); // 존재 확인
//		teaVO.setCategoryNum(categoryVO.getCategoryNum());
//		teaService.update(teaVO);
//		
//		//categoryVO.setCategoryCondition("현재 해당 쿼리 없음 추후 맞는 서치컨디션 입력");
//		if(categoryService.update(categoryVO)) {
//			
//		}
//		
//		return "admin.do";
//	}
//	
//	
//	// --------------------------------- 상품관리 페이지 이동 ---------------------------------
//	@RequestMapping(value = "/adminTea.do")
//	public String adminTeaPage(TeaVO teaVO, Model model) {
//		
//		teaVO.setTeaCondition("ALL");
//		List<TeaVO> teaDatas = teaService.selectAll(teaVO);
//		model.addAttribute("teaDatas", teaDatas);
//		
//		return "adteaManage.jsp";
//	}
//	
//	// --------------------------------- 상품 추가 ---------------------------------
//	@RequestMapping(value = "/insertTea.do")
//	public String insertTea(TeaVO teaVO) {
//		
//		if(teaService.insert(teaVO)) {
//			
//		}
//		
//		return "adminTea.do";
//	}
//	
//	// --------------------------------- 상품 삭제 ---------------------------------
//	@RequestMapping(value = "/deleteTea.do")
//	public String deleteTea(TeaVO teaVO) {
//		
//		if(teaService.selectOne(teaVO) != null) { // 존재 확인
//			
//			teaVO.setTeaCondition("현재 해당 쿼리 없음 추후 맞는 서치컨디션 입력");
//			if(teaService.delete(teaVO)) {
//				
//			}
//		}
//		
//		
//		return "adminTea.do";
//	}
//	
//	// --------------------------------- 상품 변경 ---------------------------------
//	@RequestMapping(value = "/updateTea.do")
//	public String updateTea(TeaVO teaVO) {
//		
//		if(teaService.selectOne(teaVO) != null) { // 존재 확인
//			
//			teaVO.setTeaCondition("현재 해당 쿼리 없음 추후 맞는 서치컨디션 입력");
//			// 재고 or 가격 or 둘다 ---> 서치컨디션으로 set할듯
//			if(teaService.update(teaVO)) {
//				
//			}
//		}
//		
//		
//		return "adminTea.do";
//	}
//	
//	// --------------------------------- 카테고리 선택시 해당되는 상품들 반환 ---------------------------------
//	@ResponseBody
//	@RequestMapping(value = "/selectCategory.do")
//	public Model selectCategory(CategoryVO categoryVO, TeaVO teaVO, Model model) {
//		
//		// 현재 카테고리 이름으로 조회하는 쿼리라 Category PK로 조회하는 것 고려
//		teaVO.setTeaCondition("ALL"); 
//		List<TeaVO> teaDatas = teaService.selectAll(teaVO);
//		model.addAttribute("teaDatas", teaDatas);
//		
//		return model; // 고민
//	}
//
//}