package com.varchar.view.controller;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varchar.biz.category.CategoryService;
import com.varchar.biz.category.CategoryVO;
import com.varchar.biz.member.MemberService;
import com.varchar.biz.member.MemberVO;
import com.varchar.biz.tea.TeaService;
import com.varchar.biz.tea.TeaVO;


@Controller
public class AdminTeaController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TeaService teaService;
	@Autowired
	private MemberService memberService;

	
	// --------------------------------- 관리자 홈(메인) 페이지 이동 ---------------------------------
	@RequestMapping(value = "/admin.do")
	public String adminPage(CategoryVO categoryVO, Model model) {
		
		List<CategoryVO> categoryDatas = categoryService.selectAll(null); //이거 NULL 없애는 방향 고려
		model.addAttribute("categoryDatas", categoryDatas);
		
		List<MemberVO> memberDatas = memberService.selectAll(null); //이거 NULL 없애는 방향 고려
		model.addAttribute("memberDatas", memberDatas);
		
		
		
		return "admin.jsp";
	}
	
	// --------------------------------- 카테고리 추가 ---------------------------------
	@RequestMapping(value = "/insertCategory.do")
	public String insertCategory(CategoryVO categoryVO) {
		
		if(categoryService.insert(categoryVO)) {
			
		}
		
		return "admin.do";
	}
	
	// --------------------------------- 카테고리 삭제 ---------------------------------
	@RequestMapping(value = "/deleteCategory.do")
	public String deleteCategory(CategoryVO categoryVO, TeaVO teaVO) {
		
		// 해당되는 카테고리에 있는 상품이 있을 수 있으므로 해당없음으로 변경해줘야 함
		categoryVO = categoryService.selectOne(categoryVO); // 존재 확인
		teaVO.setCategoryNum(categoryVO.getCategoryNum());
		teaService.update(teaVO);
		
		//categoryVO.setCategoryCondition("현재 해당 쿼리 없음 추후 맞는 서치컨디션 입력");
		
		if(categoryVO != null) {
			
			categoryService.update(categoryVO);
			
			if(categoryService.delete(categoryVO)) {
				
			}
		}
		
		
		return "admin.do";
	}
	
	// --------------------------------- 카테고리 변경 ---------------------------------
	@RequestMapping(value = "/updateCategory.do")
	public String updateCategory(CategoryVO categoryVO, TeaVO teaVO) {
		
		// 해당되는 카테고리에 있는 상품이 있을 수 있으므로 해당없음으로 변경해줘야 함
		categoryVO = categoryService.selectOne(categoryVO); // 존재 확인
		teaVO.setCategoryNum(categoryVO.getCategoryNum());
		teaService.update(teaVO);
		
		//categoryVO.setCategoryCondition("현재 해당 쿼리 없음 추후 맞는 서치컨디션 입력");
		if(categoryService.update(categoryVO)) {
			
		}
		
		return "admin.do";
	}
	
	
	// --------------------------------- 상품관리 페이지 이동 ---------------------------------
	@RequestMapping(value = "/adminTea.do")
	public String adminTeaPage(TeaVO teaVO, Model model) {
		
		List<CategoryVO> categoryDatas = categoryService.selectAll(null); //이거 NULL 없애는 방향 고려
		model.addAttribute("categoryDatas", categoryDatas);
		
		return "adteaManage.jsp";
	}
	
	// --------------------------------- 상품 추가 ---------------------------------
	@RequestMapping(value = "/insertTea.do")
	public String insertTea(TeaVO teaVO) {
		
		System.out.println("insertTea.do: "+teaVO);
		
		if(teaService.insert(teaVO)) {
			
		}
		
		return "adminTea.do";
	}
	
	// --------------------------------- 상품 삭제 ---------------------------------
	@RequestMapping(value = "/deleteTea.do")
	public String deleteTea(TeaVO teaVO) {
		
		if(teaService.selectOne(teaVO) != null) { // 존재 확인
			
			teaVO.setTeaCondition("현재 해당 쿼리 없음 추후 맞는 서치컨디션 입력");
			if(teaService.delete(teaVO)) {
				// 이미지도 지워야 함
			}
		}
		
		
		return "adminTea.do";
	}
	
	// --------------------------------- 상품 변경 ---------------------------------
	@RequestMapping(value = "/updateTea.do")
	public String updateTea(TeaVO teaVO) {
		
		if(teaService.selectOne(teaVO) != null) { // 존재 확인
			
			teaVO.setTeaCondition("상품변경");
			// 재고 or 가격 or 둘다 ---> 서치컨디션으로 set할듯
			if(teaService.update(teaVO)) {
				
			}
		}
		
		
		return "adminTea.do";
	}
	
	// --------------------------------- 상품 현황 엑셀 내보내기 ---------------------------------
	@RequestMapping(value = "/ExcelTea.do")
	public void ExcelTea(HttpServletResponse res) throws Exception {
        /**
         * excel sheet 생성
         */
        Workbook workbook = new XSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Sheet1"); // 엑셀 sheet 이름
        sheet.setDefaultColumnWidth(28); // 디폴트 너비 설정

        /**
         * header font style
         */
        XSSFFont headerXSSFFont = (XSSFFont) workbook.createFont();
        headerXSSFFont.setColor(new XSSFColor(new byte[]{(byte) 255, (byte) 255, (byte) 255}));

        /**
         * header cell style
         */
        XSSFCellStyle headerXssfCellStyle = (XSSFCellStyle) workbook.createCellStyle();

        // 테두리 설정
        headerXssfCellStyle.setBorderLeft(BorderStyle.THIN);
        headerXssfCellStyle.setBorderRight(BorderStyle.THIN);
        headerXssfCellStyle.setBorderTop(BorderStyle.THIN);
        headerXssfCellStyle.setBorderBottom(BorderStyle.THIN);

        // 배경 설정
        headerXssfCellStyle.setFillForegroundColor(new XSSFColor(new byte[]{(byte) 34, (byte) 37, (byte) 41}));
        headerXssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerXssfCellStyle.setFont(headerXSSFFont);

        /**
         * body cell style
         */
        XSSFCellStyle bodyXssfCellStyle = (XSSFCellStyle) workbook.createCellStyle();

        // 테두리 설정
        bodyXssfCellStyle.setBorderLeft(BorderStyle.THIN);
        bodyXssfCellStyle.setBorderRight(BorderStyle.THIN);
        bodyXssfCellStyle.setBorderTop(BorderStyle.THIN);
        bodyXssfCellStyle.setBorderBottom(BorderStyle.THIN);

        /**
         * header data
         */
        int rowCount = 0; // 데이터가 저장될 행
        String headerNames[] = new String[]{"카테고리", "상품번호(PK)", "상품명", "가격", "재고", "판매량", "매출"};

        Row headerRow = null;
        Cell headerCell = null;

        headerRow = sheet.createRow(rowCount++);
        for(int i=0; i<headerNames.length; i++) {
            headerCell = headerRow.createCell(i);
            headerCell.setCellValue(headerNames[i]); // 데이터 추가
            headerCell.setCellStyle(headerXssfCellStyle); // 스타일 추가
        }

        /**
         * body data
         */
        String bodyDatass[][] = new String[][]{
            {"첫번째 행 첫번째 데이터", "첫번째 행 두번째 데이터", "첫번째 행 세번째 데이터"},
            {"두번째 행 첫번째 데이터", "두번째 행 두번째 데이터", "두번째 행 세번째 데이터"},
            {"세번째 행 첫번째 데이터", "세번째 행 두번째 데이터", "세번째 행 세번째 데이터"},
            {"네번째 행 첫번째 데이터", "네번째 행 두번째 데이터", "네번째 행 세번째 데이터"}
        };

        Row bodyRow = null;
        Cell bodyCell = null;

        for(String[] bodyDatas : bodyDatass) {
            bodyRow = sheet.createRow(rowCount++);

            for(int i=0; i<bodyDatas.length; i++) {
                bodyCell = bodyRow.createCell(i);
                bodyCell.setCellValue(bodyDatas[i]); // 데이터 추가
                bodyCell.setCellStyle(bodyXssfCellStyle); // 스타일 추가
            }
        }

        /**
         * download
         */
        String fileName = "spring_excel_download";

        res.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        ServletOutputStream servletOutputStream = res.getOutputStream();

        workbook.write(servletOutputStream);
        workbook.close();
        servletOutputStream.flush();
        servletOutputStream.close();
    }
	
	// --------------------------------- 상품 현황 엑셀 내보내기 ---------------------------------
//	@RequestMapping(value = "/ExcelTea.do")
//    @Override
//    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        
//        
//        String userAgent = request.getHeader("User-Agent");
//        String fileName ="엑셀다운로드.xls";
//        
//        
//        if(userAgent.indexOf("MSIE") > -1) {
//            fileName = URLEncoder.encode(fileName,"utf-8");
//        }else {
//            fileName = new String(fileName.getBytes("utf-8"),"iso-8859-1");
//        }
//        
//        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
//        response.setHeader("Content-Transfer-Encoding", "binary");
//        
//        
//        //워크북 생성
////                workbook = new HSSFWorkbook();
//                //워크시트 생성
//                HSSFSheet sheet = workbook.createSheet();
//                
//                
//                
//                workbook.setSheetName(0, "엑셀다운로드");
//                sheet.setColumnWidth(1, 256*30);
//                
//                
//                //스타일
//                HSSFPalette palette = workbook.getCustomPalette();
//                HSSFColor co = palette.findSimilarColor(153, 204, 255);
//                HSSFCellStyle style = workbook.createCellStyle(); 
//                style.setFillForegroundColor(co.getIndex());
//                style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//                
//                
//                sheet.setColumnWidth(3, 4000);
//                sheet.setColumnWidth(4, 8000);
//                sheet.setColumnWidth(5, 12000);
//                sheet.setColumnWidth(6, 8000);
//                
//                //행 생성
//                HSSFRow row = sheet.createRow(0);
//                //셀 생성
//                HSSFCell cell;
//                
//                
//                //헤더 정보 구성
//                cell = row.createCell(0);
//                cell.setCellValue("no"); //no
//                cell.setCellStyle(style);
// 
//                cell = row.createCell(1); 
//                cell.setCellValue("국가");
//                cell.setCellStyle(style);
// 
//                cell = row.createCell(2);
//                cell.setCellValue("구분");
//                cell.setCellStyle(style);
// 
//                cell = row.createCell(3);
//                cell.setCellValue("학년");
//                cell.setCellStyle(style);
// 
//                cell = row.createCell(4);
//                cell.setCellValue("주소");
//                cell.setCellStyle(style);
// 
//                cell = row.createCell(5);
//                cell.setCellValue("EMAIL");
//                cell.setCellStyle(style);
// 
//                cell = row.createCell(6);
//                cell.setCellValue("학부");
//                cell.setCellStyle(style);
// 
//                cell = row.createCell(7);
//                cell.setCellValue("재학유무");
//                cell.setCellStyle(style);
//        
//        
//        
//                
//                List<StatisticInfo> xlist = (List<StatisticInfo>)model.get("statisticList");
//                
//               StatisticInfo vo = new StatisticInfo+();
//                for(int rowIdx = 0; rowIdx < xlist.size(); rowIdx++) {
//                    vo = xlist.get(rowIdx);
//                    
//                    //행 생성
//                    row = sheet.createRow(rowIdx+1);
//                    
//                    cell = row.createCell(0);
//                    cell.setCellValue(vo.getNo());
//                    
//                    cell = row.createCell(1);
//                    cell.setCellValue(vo.getCountry()); 
//                    
//                    cell = row.createCell(2);
//                    cell.setCellValue(vo.getSection());//구분
//                    
//                    cell = row.createCell(3);
//                    cell.setCellValue(vo.getGrade()); 
//                    
//                    cell = row.createCell(4);
//                    cell.setCellValue(vo.getAddress());
//                    
//                    cell = row.createCell(5);
//                    cell.setCellValue(vo.getEmail());
//                    
//                    cell = row.createCell(6);
//                    cell.setCellValue(vo.getDepartment());
//                    
//                    cell = row.createCell(7);
//                    cell.setCellValue(vo.getUseYN());
//                }
//                
//    
//    
//    }

}
