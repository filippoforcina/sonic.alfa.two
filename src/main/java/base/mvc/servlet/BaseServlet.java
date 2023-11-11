package base.mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class Base
 */
@WebServlet("/base")
public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(BaseServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doGet - START");
		request.setAttribute("gift", "disney card");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/base.jsp?nick=Maurice");
		requestDispatcher.forward(request, response);
	}

}
