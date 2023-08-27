package com.varchar.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.varchar.biz.buy.BuyDetailVO;
import com.varchar.biz.buy.BuyVO;
import com.varchar.biz.favor.FavorVO;
import com.varchar.biz.member.MemberVO;
import com.varchar.biz.payment.PaymentVO;
import com.varchar.biz.review.ReviewVO;
import com.varchar.biz.tea.TeaVO;

@Service
@Aspect
public class LogAdvice {
	
	// 로그 색상 변경
	public static final String RESET = "\u001B[0m";
	public static final String FONT_BLACK = "\u001B[30m";
	public static final String FONT_RED = "\u001B[31m";
	public static final String FONT_GREEN = "\u001B[32m";
	public static final String FONT_YELLOW = "\u001B[33m";
	public static final String FONT_BLUE = "\u001B[34m";
	public static final String FONT_PURPLE = "\u001B[35m";
	public static final String FONT_CYAN = "\u001B[36m";
	public static final String FONT_WHITE = "\u001B[37m";
	public static final String BACKGROUND_BLACK = "\u001B[40m";
	public static final String BACKGROUND_RED = "\u001B[41m";
	public static final String BACKGROUND_GREEN = "\u001B[42m";
	public static final String BACKGROUND_YELLOW = "\u001B[43m";
	public static final String BACKGROUND_BLUE = "\u001B[44m";
	public static final String BACKGROUND_PURPLE = "\u001B[45m";
	public static final String BACKGROUND_CYAN = "\u001B[46m";
	public static final String BACKGROUND_WHITE = "\u001B[47m";
	
//	System.out.println(FONT_BLUE);
//	System.out.println(RESET);
	
	
	@Before("PointCutCommon.aPointcut()") // 모든 메서드에 실행
	public void beforeLog(JoinPoint joinPoint) {
		
		System.out.println();
		System.out.print(FONT_YELLOW);
		System.out.println("횡단관심 Before: 비즈니스 메서드 실행 이전의 로그");
		
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        
        Object[] args = joinPoint.getArgs();
        StringBuilder argsString = new StringBuilder();
        
        for (Object arg : args) {
            argsString.append(arg).append(", ");
        }
        
        if (argsString.length() > 0) {
            argsString.delete(argsString.length() - 2, argsString.length()); // Remove trailing comma and space
        }
        
        System.out.println(methodName +" INPUT: \n\t"+argsString);
        //System.out.println("Before method execution: " + className + "." + methodName + "(" + argsString + ")");
		
		
		System.out.print(RESET);
		
		//String methodName=jp.getSignature().getName();
		//System.out.println("횡단관심 Before: "+methodName+" 실행 이전의 로그");
		
//		if(returnObj instanceof MemberVO) {
//			MemberVO memberVO=(MemberVO)returnObj;
//			System.out.println(methodName +"실행 완료 memberVO: "+memberVO);
//			
//			if(memberVO.getMemberSearch() != null) {
//				if(memberVO.getMemberSearch().equals("로그인")) {
//					System.out.println("\t로그인");
//				}
//				else {
//					System.out.println("\t해당 회원 존재 확인");
//				}
//			}
//			
//		}
//		else if(returnObj instanceof TeaVO){
//			TeaVO teaVO=(TeaVO)returnObj;
//			System.out.println(methodName +" INPUT: \n\tteaVO: "+teaVO);
//			// 판매 가능 여부?
//		}
//		else if(returnObj instanceof BuyVO){
//			BuyVO buyVO=(BuyVO)returnObj;
//			System.out.println(methodName +" INPUT: \n\tbuyVO: "+buyVO);	
//		}
//		else if(returnObj instanceof BuyDetailVO){
//			BuyDetailVO buyDetailVO=(BuyDetailVO)returnObj;
//			System.out.println(methodName +" INPUT: \n\tbuyDetailVO: "+buyDetailVO);	
//			
//			if(buyDetailVO.getBuySearch() != null) {
//				if(buyDetailVO.getBuySearch().equals("주문번호")) {
//					System.out.println("\t해당 회원의 가장 최근 주문내역 조회");
//				}
//				else {
//					System.out.println("\t주문내역상세(단건) 조회");
//				}
//			}
//			
//		}
//		else if(returnObj instanceof PaymentVO){
//			PaymentVO paymentVO=(PaymentVO)returnObj;
//			System.out.println(methodName +" INPUT: \n\tpaymentVO: "+paymentVO);	
//		}
//		else if(returnObj instanceof FavorVO){
//			FavorVO favorVO=(FavorVO)returnObj;
//			System.out.println(methodName +" INPUT: \n\tfavorVO: "+favorVO);	
//			System.out.println("\t해당 회원의 찜 여부 조회");
//		}
//		else if(returnObj instanceof ReviewVO){
//			ReviewVO reviewVO=(ReviewVO)returnObj;
//			System.out.println(methodName +" INPUT: \n\treviewVO: "+reviewVO);
//			
//			if(reviewVO.getReviewSearch() != null) {
//				if(reviewVO.getReviewSearch().equals("리뷰상세")) { 
//					System.out.println("\t후기 상세 조회");
//				}
//				else {
//					System.out.println("\t후기 확인 조회");
//				}
//			}
//			
//		}
////		else if(((List<?>)returnObj).get(0) instanceof TeaVO) {
////			System.out.println();
////		}
//		else{
//			System.out.println(methodName +" INPUT: "+returnObj);
//		}
		System.out.print(RESET);
		
	}
	
	@After("PointCutCommon.aPointcut()") // 모든 메서드에 실행
	public void afterLog() {
		System.out.println();
		System.out.print(FONT_BLUE);
		System.out.println("횡단관심 After: 비즈니스 메서드 실행 이후의 로그");
		System.out.print(RESET);
	}
	
	@AfterReturning(pointcut="PointCutCommon.bPointcut()", returning="returnObj") // select 메서드에 실행
	public void afterReturningLog(JoinPoint jp, Object returnObj) {
		System.out.println();
		System.out.print(FONT_BLUE);
		
		String methodName=jp.getSignature().getName();
		System.out.println("횡단관심 AfterReturning: "+methodName+"의 반환 이후의 로그");
		
		System.out.print(RESET);
		System.out.print(FONT_GREEN);
		
		if(returnObj instanceof MemberVO) {
			MemberVO memberVO=(MemberVO)returnObj;
			System.out.println(methodName +"실행 완료 memberVO: "+memberVO);
			
			if(memberVO.getMemberSearch() != null) {
				if(memberVO.getMemberSearch().equals("로그인")) {
					System.out.println("\t로그인");
//					if (memberVO.getMemberGrade().equals("ADMIN")) {
//						System.out.println("\t[관리자 입장]: "+ memberVO.getMemberName +"님");
//					} else {
//						System.out.println("\t[사용자 입장]: "+ memberVO.getMemberName +"님");
//					}
				}
				else {
					System.out.println("\t해당 회원 존재 확인");
				}
			}
			
		}
		else if(returnObj instanceof TeaVO){
			TeaVO teaVO=(TeaVO)returnObj;
			System.out.println(methodName +"실행 완료 \n\tteaVO: "+teaVO);
			// 판매 가능 여부?
		}
		else if(returnObj instanceof BuyVO){
			BuyVO buyVO=(BuyVO)returnObj;
			System.out.println(methodName +"실행 완료 \n\tbuyVO: "+buyVO);	
		}
		else if(returnObj instanceof BuyDetailVO){
			BuyDetailVO buyDetailVO=(BuyDetailVO)returnObj;
			System.out.println(methodName +"실행 완료 \n\tbuyDetailVO: "+buyDetailVO);	
			
			if(buyDetailVO.getBuySearch() != null) {
				if(buyDetailVO.getBuySearch().equals("주문번호")) {
					System.out.println("\t해당 회원의 가장 최근 주문내역 조회");
				}
				else {
					System.out.println("\t주문내역상세(단건) 조회");
				}
			}
			
		}
		else if(returnObj instanceof PaymentVO){
			PaymentVO paymentVO=(PaymentVO)returnObj;
			System.out.println(methodName +"실행 완료 \n\tpaymentVO: "+paymentVO);	
		}
		else if(returnObj instanceof FavorVO){
			FavorVO favorVO=(FavorVO)returnObj;
			System.out.println(methodName +"실행 완료 \n\tfavorVO: "+favorVO);	
			System.out.println("\t해당 회원의 찜 여부 조회");
		}
		else if(returnObj instanceof ReviewVO){
			ReviewVO reviewVO=(ReviewVO)returnObj;
			System.out.println(methodName +"실행 완료 \n\treviewVO: "+reviewVO);
			
			if(reviewVO.getReviewSearch() != null) {
				if(reviewVO.getReviewSearch().equals("리뷰상세")) { 
					System.out.println("\t후기 상세 조회");
				}
				else {
					System.out.println("\t후기 확인 조회");
				}
			}
			
		}
//		else if(((List<?>)returnObj).get(0) instanceof TeaVO) {
//			System.out.println();
//		}
		else{
			System.out.println("[데이터 열람] \n\t"+returnObj);
		}
		System.out.print(RESET);
	}
	
    // 예외발생시 trycatch 되어있으면 어드바이스 호출되지 않음
	@AfterThrowing(pointcut="PointCutCommon.aPointcut()", throwing="exceptObj")
	public void afterThrowingPrintLog(JoinPoint jp, Exception exceptObj) {
		System.out.println();
		System.out.print(FONT_RED);
		
		String methodName = jp.getSignature().getName();
		System.out.println("횡단 관심 : "+methodName+"에서 예외 발생");
		System.out.println("예외 메세지 : "+exceptObj.getMessage());
		
		System.out.print(RESET);
	}
	
	@Around("PointCutCommon.cPointcut()") // selectAll 메서드에 실행
	public Object aroundPrintLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println();
		System.out.print(FONT_CYAN);
		String methodName=pjp.getSignature().getName();
		StopWatch sw=new StopWatch();
		System.out.println("\tLog: controller => "+ methodName +" [START]");
		
		sw.start();
		Object obj=pjp.proceed();
		sw.stop();
		
		System.out.println("\tLog: controller => "+ methodName +" [END]");
		System.out.println(methodName+" 메서드를 수행 소요시간: "+sw.getTotalTimeSeconds()+"초");
		System.out.println(methodName+" 메서드를 수행: "+pjp);
		
		System.out.print(RESET);

		return obj;
	}
}