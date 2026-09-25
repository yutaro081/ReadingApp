package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idParam = request.getParameter("id");
		int id = Integer.parseInt(idParam);

		BookDAO dao = new BookDAO();
		Book book = dao.findById(id);

		request.setAttribute("book", book);

		request.getRequestDispatcher("/book-detail.jsp")
				.forward(request, response);

		System.out.println("受け取ったid：" + id);
	}

}
