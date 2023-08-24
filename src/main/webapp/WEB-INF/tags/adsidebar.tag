<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="main.jsp">
              <i class="mdi mdi-home menu-icon"></i>
              <span class="menu-title">Var茶 홈페이지</span>
            </a>
          </li>
          <li class="nav-item nav-category">Hashtag</li>
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <i class="menu-icon mdi mdi-tag-text-outline"></i>
              <span class="menu-title">해시태그 관리</span>
              <i class="menu-arrow"></i> 
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="Ad/pages/ui-features/buttons.html">해시태그 추가</a></li>
                <li class="nav-item"> <a class="nav-link" href="Ad/pages/ui-features/dropdowns.html">해시태그 삭제</a></li>
                <li class="nav-item"> <a class="nav-link" href="adhashTag.jsp#fixtag">해시태그 수정</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item nav-category">Tea Product Management</li>
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#form-elements" aria-expanded="false" aria-controls="form-elements">
              <i class="menu-icon mdi mdi-stove"></i>
              <span class="menu-title">티 상품관리</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="form-elements">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"><a class="nav-link" href="Ad/pages/forms/basic_elements.html">상품 추가</a></li>
                <li class="nav-item"><a class="nav-link" href="Ad/pages/forms/basic_elements.html">상품 삭제</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#charts" aria-expanded="false" aria-controls="charts">
              <i class="menu-icon mdi mdi-square-inc-cash"></i>
              <span class="menu-title">티 가격관리</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="charts">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="Ad/pages/charts/chartjs.html">가격 변경</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#tables" aria-expanded="false" aria-controls="tables">
              <i class="menu-icon mdi mdi-table-large"></i>
              <span class="menu-title">티 재고관리</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="tables">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="Ad/pages/tables/basic-table.html">재고 변경</a></li>
              </ul>
            </div>
          </li>
        </ul>
      </nav>