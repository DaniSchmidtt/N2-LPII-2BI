package ec.ftt.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ec.ftt.dao.PasswordDao;
import ec.ftt.model.Password;

/**
 * Servlet implementation class PasswordApi
 */
@WebServlet("/PasswordApi")
public class PasswordApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordApi() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setStatus(418); //200 - OK - Padrão (Default)

		response.setContentType("application/json");
		
		String passwordId = request.getParameter("password-id");
		
		PasswordDao passwordDao = new PasswordDao();
		
	    if(passwordId != null) {
	    	long id = Long.valueOf(passwordId);    	
	    	
	        Password password = passwordDao.getPasswordById(id);
	     	Gson gson = new Gson();
	    	response.getWriter().append(gson.toJson(password));
	    	
	    } else {
	    		    	
	    	List<Password> passwords = passwordDao.getAllPassword();
	        
	    	Gson gson = new Gson();

	    	response.getWriter().append(gson.toJson(passwords));

	    } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Password p = new Password(
				//request.getParameter("password-id"),
				request.getParameter("password-name"),
				request.getParameter("password-email"),
				request.getParameter("password-password"),
				request.getParameter("password-site")
				);
		
		PasswordDao passwordDao = new PasswordDao();
		
		passwordDao.addPassword(p);
		
		System.out.println(p);
		Gson gson = new Gson();

        response.getWriter().append(gson.toJson(p));
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 //mimeType - https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
		Password p = new Password(
				request.getParameter("password-id"),
				request.getParameter("password-name"),
				request.getParameter("password-email"),
				request.getParameter("password-password"),
				request.getParameter("password-site")
				);
		PasswordDao passwordDao = new PasswordDao();
		
		passwordDao.updatePassword(p);
		
		System.out.println(p);
		
		response.getWriter().append(p.toString());
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setStatus(418); //200 - OK - Padrão (Default)
		
		if (request.getParameter("password-id") == null)
			 response.sendError(407, "Informe o ID do password a ser retornado!!!" );
		else {
		Long passwordId = Long.valueOf(request.getParameter("password-id"));
		
		
		PasswordDao pd = new PasswordDao();
		
		pd.deletePassord(passwordId);
		
		response.getWriter().append(request.getParameter("password-id") + " Password removido");
		}
	}
}

