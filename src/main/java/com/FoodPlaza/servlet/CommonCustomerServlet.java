package com.FoodPlaza.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FoodPlaza.dao.Customer_Dao_Impl;
import com.FoodPlaza.dao.Feedback_Dao_impl;
import com.FoodPlaza.pojo.Customer;

/**
 * Servlet implementation class CommonCustomerServlet
 */
@WebServlet("/CommonCustomerServlet")
public class CommonCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    Customer_Dao_Impl cdi = new Customer_Dao_Impl();
    Feedback_Dao_impl fdao = new Feedback_Dao_impl();

    public CommonCustomerServlet() {
        super();

    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession();
		  String action = request.getParameter("action");

		   if ("editprofile".equalsIgnoreCase(action)) {
			String email = (String) session.getAttribute("CustomerUserName");
	        Customer customer = cdi.getCustomerByEmail(email);

	        if (customer != null) {
	            request.setAttribute("customer", customer);
	            RequestDispatcher rd = request.getRequestDispatcher("EditProfile.jsp");
	            rd.forward(request, response);
	        } else {
	            request.setAttribute("errorMsg", "Customer not found");
	            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	            rd.forward(request, response);
	        }
	        return;
	    }

	        List<Customer> cli = cdi.getAllCustomer();
	        session.setAttribute("customerList", cli);
	        response.sendRedirect("CustomerList.jsp");

	}
//		  List<Customer> cli = cdi.getAllCustomer();
//		  session.setAttribute("customerList",cli);
//		  response.sendRedirect("CustomerList.jsp");
//		response.getWriter().append("Served at: ").append(request.getContextPath());




	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Customer c = new Customer();
	    Customer_Dao_Impl cdi = new  Customer_Dao_Impl();

	    String action = request.getParameter("action");

	    if(action != null && action.equalsIgnoreCase("addCust"))
	    {
	    	String cname = request.getParameter("custname");
	    	String cemail = request.getParameter("custemail");
	    	String cpass = request.getParameter("custpass");
	    	String cadd = request.getParameter("custadd");
	    	String ccontact = request.getParameter("custcontact");
	    	String cLoc = request.getParameter("custloc");

	    	c.setCustname(cname);
	    	c.setEmailId(cemail);
	    	c.setCustPassword(cpass);
	    	c.setCustAddress(cadd);
	    	c.setCustContactNo(ccontact);
	    	c.setCustLocation(cLoc);

	    	boolean flag = cdi.addCustomer(c);

	    	 if(flag) {
	 	    	request.setAttribute("RegisterCustomermsg","Customer Registred Successfully" );
	 	    	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	 	    	rd.forward(request,response);
//	    		 response.sendRedirect("Succes.jsp");

	 	    }else {
	 	    	request.setAttribute("RegisterCustomermsg","Customer not Registred" );
	 	    	RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
	 	    	rd.forward(request,response);
//	 	    	response.sendRedirect("Error.jsp");
			}
	    }else if("updateprofile".equals(action)){

	    	String name = request.getParameter("custName");
            String email = request.getParameter("custEmail");
            String address = request.getParameter("custAddress");
            String contact = request.getParameter("custContact");
            String password = request.getParameter("custPassword");

            Customer update = new Customer();
            update.setCustname(name);
            update.setEmailId(email);
            update.setCustAddress(address);
            update.setCustContactNo(contact);
            update.setCustPassword(password);

            boolean updated = cdi.updateCustomer(email,update);
            Customer updatedCustomer = cdi.getCustomerByEmail(email);
            request.setAttribute("customer", updatedCustomer);
            if(updated) {
            	 request.setAttribute("Profileupdate", "Profile Updated Successfully!");
            }else {
            	 request.setAttribute("ProfileNotupdate", "Profile Not Updated !");
            }
            RequestDispatcher rd = request.getRequestDispatcher("EditProfile.jsp");
            rd.forward(request, response);

	    }

	}

}
