<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id = "naming" class="by.tr.web.entity.flower.Flower"
  type = "java.lang.Object" scope = "session"/>
  <c:if test="${sessionScope.naming==null}">
  	<p>Name not found<p>
  </c:if>
  <c:if test="${sessionScope.naming!=null}">
  <table border="1">
  <tr border="1">
    <td>name</td>
    <td>id</td>
    <td>origin</td>
    <td>soil</td>
    <td>visualParameters</td>
    <td>multiplying</td>
    <td>growingTips</td>
   </tr border="1">
 <!--  <c:forEach items="${sessionScope.naming}" var="item">
  </tr border="1">
    <tr>
    <td>${item.name}</td>
    <td>${sessionScope.naming[5].name}</td>
    <td>${item.id}</td>
    <td>${item.origin}</td>
    <td>${item.soil}</td>
    <td>${item.visualParameters}</td>
    <td>${item.multiplying}</td>
    <td>${item.growingTips}</td>
  </tr>
  </c:forEach>-->
  <c:if test="${param.page != null}"> 
	<c:set var = "currentPage" value="${param.page}"/>
</c:if>
<c:if test="${param.page == null}"> 
	<c:set var = "currentPage" value="${1}"/>
</c:if>
  <c:if test="${currentPage != countOfPages}"> 
  <c:set var="begin" scope="session" value="${(currentPage - 1) * recordsPerPage}"/>
  <c:set var="end" scope="session" value="${currentPage * recordsPerPage - 1}"/>
  <c:forEach begin="${begin}" end="${end}" var="i">
    <tr>
    <td>${sessionScope.naming[i].name}</td>
    <td>${sessionScope.naming[i].id}</td>
    <td>${sessionScope.naming[i].origin}</td>
    <td>${sessionScope.naming[i].soil}</td>
    <td>${sessionScope.naming[i].visualParameters}</td>
    <td>${sessionScope.naming[i].multiplying}</td>
    <td>${sessionScope.naming[i].growingTips}</td>
  </tr>
  </c:forEach>
  </c:if>
    <c:if test="${currentPage == countOfPages}"> 
      <c:set var="begin" scope="session" value="${(currentPage - 1) * recordsPerPage}"/>
  <c:forEach begin="${begin}" end="${countOfRecords}" var="i">
    <tr>
    <td>${sessionScope.naming[i].name}</td>
    <td>${sessionScope.naming[i].id}</td>
    <td>${sessionScope.naming[i].origin}</td>
    <td>${sessionScope.naming[i].soil}</td>
    <td>${sessionScope.naming[i].visualParameters}</td>
    <td>${sessionScope.naming[i].multiplying}</td>
    <td>${sessionScope.naming[i].growingTips}</td>
  </tr>
  </c:forEach>
  </c:if>
  </table>
<form method="get" action="Controller">
 <c:if test="${currentPage > 1}">
        <td><a href="information.jsp?page=${currentPage - 1}">Previous</a></td>
 </c:if>
 
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${countOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="information.jsp?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>  
        </tr>
    </table>
     
    <c:if test="${currentPage lt countOfPages}">
        <td><a href="information.jsp?page=${currentPage + 1}">Next</a></td>
    </c:if>
    </form>
</c:if>
</body>
</html>