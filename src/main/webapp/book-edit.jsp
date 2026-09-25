<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本の編集</title>
</head>
<body>

	<h1>本の編集</h1>

	<form action="${pageContext.request.contextPath}/BookEditServlet"
		method="post">

		<input type="hidden" name="id" value="${book.id}">

		<p>
			<label for="title">タイトル</label> <input type="text" id="title"
				name="title" value="${book.title}" required>
		</p>

		<p>
			<label for="author">著者</label> <input type="text" id="author"
				name="author" value="${book.author}" required>
		</p>

		<p>
			<label for="status">読書状況：</label> <select id="status" name="status">
				<option value="未読">${book.status == '未読' ? 'selected ' : ''}>未読</option>
				<option value="読書中">${book.status == '読書中' ? 'selected ' : ''}>読書中</option>
				<option value="読了">${book.status == '読了' ? 'selected ' : ''}>読了</option>
			</select>
		</p>

		<button type="submit">更新する</button>

	</form>

	<p>
		<a
			href="${pageContext.request.contextPath}/BookDetailServlet?id=${book.id}">
			詳細へ戻る </a>
	</p>

</body>
</html>