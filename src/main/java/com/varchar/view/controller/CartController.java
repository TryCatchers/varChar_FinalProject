package com.varchar.view.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varchar.biz.buy.BuyDetailService;
import com.varchar.biz.buy.BuyDetailVO;
import com.varchar.biz.tea.TeaService;
import com.varchar.biz.tea.TeaVO;

@Controller
public class CartController {

	@Autowired
	private BuyDetailService buyDetailService;
	@Autowired
	private TeaService teaService;

	// --------------------------------- 장바구니 페이지 이동 ---------------------------------
	@RequestMapping(value = "/cartPage.do")
	public String cartPage() {
		return "redirect:cart.jsp";
	}

	// --------------------------------- 장바구니 추가 ---------------------------------
	@RequestMapping(value = "/insertCart.do")
	public String insertCart(TeaVO teaVO, HttpSession session) {

		ArrayList<TeaVO> cart = (ArrayList<TeaVO>) session.getAttribute("cart");
		
		System.out.println("로그 teaNum: [" + teaVO.getTeaNum() + "]");
		System.out.println("로그 teaCnt: [" + teaVO.getTeaCnt() + "]"); // 구매할 갯수
		
		// 처음부터 teaCheckCnt에 구매할 갯수 가져오는거 검토
		//teaVO.setTeaCheckCnt(teaVO.getTeaCnt());
		//System.out.println("InsertChckCnt TeaCheckCnt log : " + teaVO.getTeaCheckCnt());
		int cnt = teaVO.getTeaCnt();
		
		teaVO=teaService.selectOne(teaVO);
		
		// 수정필요
		if (teaVO == null) {
			return "main.do"; // 해당 상품 없을 경우 ---> 일단 임시로 메인으로 보냄
		}

		boolean flag = false;
		if (cart != null) { // 카트에 이미 담긴 상품이 있을 경우
			for (TeaVO t : cart) {
				if (t.getTeaNum() == teaVO.getTeaNum()) {
					t.setTeaCnt(t.getTeaCnt() + cnt);
					System.out.println("로그 !null cart tVO" + teaVO.getImageUrl());
					System.out.println("로그 !null cart t" + t.getImageUrl());
					flag = true;
					break;
				}
			}
		} else { // 카트가 비어있을 경우
			System.out.println("로그 null cart" + teaVO.getImageUrl());
			cart = new ArrayList<TeaVO>();
		}

		if (!flag) {
			teaVO.setTeaCnt(cnt);
			cart.add(teaVO);
		}

		session.setAttribute("cart", cart);

		return "redirect:cartPage.do";
	}

	// --------------------------------- 장바구니 삭제 ---------------------------------
	@ResponseBody
	@RequestMapping(value = "/deleteCart.do")
	public String deleteCartAction(HttpSession session, TeaVO teaVO) {

		ArrayList<TeaVO> cart = (ArrayList<TeaVO>) session.getAttribute("cart");

		int i = 0;
		for (TeaVO t : cart) {
			if (t.getTeaNum() == teaVO.getTeaNum()) {
				cart.remove(i);
				break;
			}
			i++;
		}

		session.setAttribute("cart", cart);

		return "redirect:cartPage.do";
	}

	// --------------------------------- 장바구니 재고변경 ---------------------------------
	@ResponseBody
	@RequestMapping(value = "/cartChange.do")
	public String cartChange(HttpSession session, TeaVO teaVO) {

		ArrayList<TeaVO> cart = (ArrayList<TeaVO>) session.getAttribute("cart");

		System.out.println("로그 teaNum: [" + teaVO.getTeaNum() + "]");
		System.out.println("로그 teaCnt: [" + teaVO.getTeaCnt() + "]");

		int i = 0;
		for (TeaVO t : cart) {
			if (t.getTeaNum() == teaVO.getTeaNum()) {

				cart.get(i).setTeaCnt(teaVO.getTeaCnt());
				System.out.println(i + " 재고 변경됨");
				break;
			}
			i++;
		}

		session.setAttribute("cart", cart);
		return "redirect:cartPage.do";

	}

	// --------------------------------- 장바구니 전체 비우기 ---------------------------------
	@ResponseBody
	@RequestMapping(value = "/cartDrop.do")
	public String cartDrop(HttpSession session) {

		session.removeAttribute("cart");

		System.out.println("카트 비워짐");

		return "redirect:cartPage.do";
	}

	// --------------------------------- 장바구니 다시담기 페이지 ---------------------------------
	@RequestMapping(value = "/cartRetry.do")
	public String cartRetry(HttpSession session, TeaVO teaVO, BuyDetailVO buyDetailVO) {

		ArrayList<TeaVO> cart = (ArrayList<TeaVO>) session.getAttribute("cart");
		List<BuyDetailVO> buyList = new ArrayList<BuyDetailVO>();
		
		System.out.println("현재 카트에 아무것도 없음");
		System.out.println("cart 로그 : " + cart);
		System.out.println("로그: buyNum ["+buyDetailVO.getBuyNum()+"]");

		buyDetailVO.setBuySearch("다시담기");
		buyList = (List<BuyDetailVO>) buyDetailService.selectAll(buyDetailVO); // 다시 담을 주문 내역 저장

		for (int i = 0; i < buyList.size(); i++) {
			teaVO.setTeaNum(buyList.get(i).getTeaNum()); // i번째 상품 set 후 존재 확인
			TeaVO tttVO = teaService.selectOne(teaVO);
			if (tttVO == null) {
				return "실패처리 경로";
			}
			System.out.println("tttVO: " + tttVO.getTeaNum());

			tttVO.setTeaCheckCnt(tttVO.getTeaCnt());
			tttVO.setTeaCnt(buyList.get(i).getBuyCnt());

			//
			boolean flag = false;
			if (cart != null) {

				for (TeaVO t : cart) {
					System.out.println("t: " + t.getTeaNum());
					if (t.getTeaNum() == tttVO.getTeaNum()) {
						t.setTeaCnt(t.getTeaCnt() + tttVO.getTeaCnt());
						System.out.println("로그 !null cart tttVO" + tttVO.getImageUrl());
						System.out.println("로그 !null cart t" + t.getImageUrl());
						flag = true;
						break;
					}
				}
			}
			else {
				System.out.println("로그 null cart" + tttVO.getImageUrl());
				cart = new ArrayList<TeaVO>();
			}

			if (!flag) {
				System.out.println("추가추가");
				cart.add(tttVO);
			}
			//

		}

		session.setAttribute("cart", cart);

		return "redirect:cartPage.do";

	}

}
