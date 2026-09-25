package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

@WebServlet("/BookEditServlet")
public class BookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookEditServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idParam = request.getParameter("id");
		int id = Integer.parseInt(idParam);

		BookDAO dao = new BookDAO();
		Book book = dao.findById(id);

		request.setAttribute("book", book);

		request.getRequestDispatcher("/book-edit.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String status = request.getParameter("status");

		Book book = new Book(id, title, author, status);

		BookDAO dao = new BookDAO();
		boolean success = dao.update(book);

		if (success) {
			response.sendRedirect(
					request.getContextPath() + "/BookDetailServlet?id=" + id);
		} else {
			response.sendError(
					HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					"本の更新に失敗しました");
		}
	}
}