<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本の詳細</title>
</head>
<body>

	<h1>本の詳細</h1>

	<p>タイトル：${book.title}</p>
	<p>著者：${book.author}</p>
	<p>読書状況：${book.status}</p>

	<p>
		<a
			href="${pageContext.request.contextPath}/BookEditServlet?id=${book.id}">
			編集する </a>
	</p>

	<form action="${pageContext.request.contextPath}/BookDeleteServlet"
		method="post" onsubmit="return confirm('本当に削除しますか？');">

		<input type="hidden" name="id" value="${book.id}">

		<button type="submit">削除する</button>
	</form>


	<p>
		<a href="${pageContext.request.contextPath}/BookListServlet">
			一覧へ戻る </a>
	</p>

</body>
</html>