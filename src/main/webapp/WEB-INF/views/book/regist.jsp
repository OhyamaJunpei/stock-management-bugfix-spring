<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"  %>
<body>
<div class="container">
	<c:out value="${member.name}"/>さん　こんにちは！<br>
	<a href="${pageContext.request.contextPath}/book/list">書籍一覧&nbsp;</a>
	<a href="${pageContext.request.contextPath}/logout/sessionInvalidate">ログアウト</a>
	<h3>書籍登録画面</h3>
	<div class="span8">
		<div class="row">
		
		<form:form modelAttribute="registerBookForm" action="${pageContext.request.contextPath}/book/regist" method="post" enctype="multipart/form-data">
		
			<form:errors path="bookForm.*" />
			<table class="table table-striped">
			  <tr>
			    <th>
			      書籍名
			    </th>
			    <td>
			      <form:input path="name"/>
			      <form:errors path="name" cssStyle="color:red" elememt="div"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      著者
			    </th>
			    <td>
			      <form:input path="author"/>
			      <form:errors path="author" cssStyle="color:red" elememt="div"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      出版社
			    </th>
			    <td>
			      <form:input path="publisher"/>
			      <form:errors path="publisher" cssStyle="color:red" elememt="div"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      価格
			    </th>
			    <td>
			      <form:input path="price"/>円
			      <form:errors path="price" cssStyle="color:red" elememt="div"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      ISBNコード
			    </th>
			    <td>
			      <form:input path="isbncode"/>
			      <form:errors path="isbncode" cssStyle="color:red" elememt="div"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      発売日
			    </th>
			    <td>
			      <form:input path="saledate"/>
			      <form:errors path="saledate" cssStyle="color:red" elememt="div"/>			     
			    </td>
			  </tr>
			  <tr>
			    <th>
			      説明
			    </th>
			    <td>
			      <form:input path="explanation"/>
			      <form:errors path="explanation" cssStyle="color:red" elememt="div"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      画像
			    </th>
			    <td>
			      <input type="file" name="imageFile"><br>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      在庫数
			    </th>
			    <td>
			      <form:input path="stock"/>
			      <form:errors path="stock" cssStyle="color:red" elememt="div"/>
			    </td>
			  </tr>
			  <tr>
			    <td>
			      <input type="submit" value="登録">
			    </td>
			  </tr>
			</table>
		
		</form:form>
		
		</div>		
	</div>
</div>
</body>
</html>
