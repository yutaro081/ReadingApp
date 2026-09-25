<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本の登録</title>
</head>
<body>

	<h1>新しい本を登録</h1>

	<form action="${pageContext.request.contextPath}/BookCreateServlet"
		method="post">

		<p>
			<label for="title">タイトル：</label> <input type="text" id="title"
				name="title" required>
		</p>

		<p>
			<label for="author">著者：</label> <input type="text" id="title"
				name="author" required>
		</p>

		<p>
			<label for="status">読書状況：</label> <select id="status" name="status">
				<option value="未読">未読</option>
				<option value="読書中">読書中</option>
				<option value="読了">読了</option>
			</select>
		</p>

		<button type="submit">登録する</button>

	</form>

	<p>
		<a href="${pageContext.request.contextPath}/BookListServlet">
			本の一覧へ戻る </a>
	</p>

</body>
</html>