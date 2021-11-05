package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BuscadorService;
import service.BuscadorServiceFactory;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter();){ 
			//recogemos parametros
			String clave=request.getParameter("clave");
			//buscamos usando el metodo
			
			BuscadorService service = BuscadorServiceFactory.getBuscadorService();//implementamos el servicio a traves de la factoria
			//construimopagina con enlaces
			response.setContentType("text/html");
			out.println("<html><body>");
			//usamos la devolucion del metodo -List<Personas>- como un stream para constir el cuerpo de la pagina
			service.buscar(clave)  //.stream() no es necesario por que el list ya se trata como stream
				.forEach(e->out.println("<h2><a href='" +e.getUrl() +"'>"
											+e.getTitulo()
											+"</a></h2>"
											+"<h5>"
											+e.getDescripcion()
											+"</h5><br><br>"
											
				));
			
			out.println("<a href='Inicio.html'> Volver Atrás</a>");
			out.println("</html></body>");
			
		}
	}

}
