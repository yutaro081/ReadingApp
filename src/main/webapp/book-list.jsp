<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>読書アプリ</title>
</head>

<body>

	<h1>読書アプリ</h1>

	<p>
		<a href="${pageContext.request.contextPath}/book-form.jsp"> 本を登録する
		</a>
	</p>

	<table border="1">
		<tr>
			<th>タイトル</th>
			<th>著者</th>
			<th>読書状況</th>
			<th>操作</th>
		</tr>

		<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.status}</td>
				<td><a
					href="${pageContext.request.contextPath}/BookDetailServlet?id=${book.id}">
						詳細を見る </a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>