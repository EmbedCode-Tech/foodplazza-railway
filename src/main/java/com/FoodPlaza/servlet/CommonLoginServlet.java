package com.FoodPlaza.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FoodPlaza.dao.Admin_Dao_impl;



@WebServlet("/CommonLoginServlet")
public class CommonLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public CommonLoginServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if(action !=null && action.equalsIgnoreCase("Logout")) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		}

    }




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Admin_Dao_impl cdi = new Admin_Dao_impl();
		 boolean flag=false;
	        HttpSession session = request.getSession();
	        String action = request.getParameter("action");
	        System.out.println("Action: " + action);

	        if (action != null && action.equals("login")) {
	            String type = request.getParameter("logintype");
	            String username = request.getParameter("EmailId");
	            String password = request.getParameter("Password");


	            if ("Customer".equals(type)) {

	                flag = cdi.customerlogin(username, password);
	                System.out.println(flag);

	            if (flag) {
	                session.setAttribute("CustomerUserName", username);
	                request.setAttribute("customerloginsuccess", "Customer login successful!");
	                request.getRequestDispatcher("index.jsp").forward(request, response);
	            } else {
//	                response.sendRedirect("Error.jsp");
	            	request.setAttribute("customerloginerror","invalid username or password");
	            	request.getRequestDispatcher("Login.jsp").forward(request,response);
	            }
	           }
	            else if("Admin".equals(type)) {
	            	 flag= cdi.login(username, password);
	            if(flag) {
	            	  session.setAttribute("adminName", username);
                 	 request.setAttribute("adminloginsuccess", "Admin login successful!");
	                 request.getRequestDispatcher("index.jsp").forward(request, response);
	            	 }else {
//	                response.sendRedirect("Error.jsp?error=Invalid");
	            		 request.setAttribute("adminloginerror","invalid username or password");
	 	            	request.getRequestDispatcher("Login.jsp").forward(request,response);
					}
	            }
	        }
	        else if(action != null && action.equalsIgnoreCase("ChangePassword")) {
	        String type = request.getParameter("logintype");
            String username = request.getParameter("EmailId");
            String Newpass = request.getParameter("NewPassword");
            String confirmpass = request.getParameter("ConfirmPassword");

            if(Newpass.equals(confirmpass)) {

               if("Customer".equals(type)) {
                 	flag=cdi.changeCustomerPass(username,Newpass);
                 	if(flag) {
                 		response.sendRedirect("Login.jsp");
                 	}else {
                 		response.sendRedirect("");
					}
                 }
               else if("Admin".equals(type)){
            	   flag=cdi.changeAdminPass(username,Newpass);
                	if(flag) {
                		response.sendRedirect("Succes.jsp");
                	}else {
                		response.sendRedirect("Error.jsp?error=Invalid");
					}
               }

            }

	}
	        else {
	        	response.sendRedirect("Error.jsp?error=Invalid");
	        }
			doGet(request, response);

	}
}
