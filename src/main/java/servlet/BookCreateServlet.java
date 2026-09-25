package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

@WebServlet("/BookCreateServlet")
public class BookCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookCreateServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String status = request.getParameter("status");

		Book book = new Book(title, author, status);

		BookDAO dao = new BookDAO();
		boolean success = dao.insert(book);

		if (success) {
			response.sendRedirect(
					request.getContextPath() + "/BookListServlet");
		} else {
			response.sendError(
					HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					"本の登録に失敗しました");
		}

	}
}