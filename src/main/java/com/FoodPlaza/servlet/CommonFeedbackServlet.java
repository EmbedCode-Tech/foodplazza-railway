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

import com.FoodPlaza.dao.Feedback_Dao_impl;
import com.FoodPlaza.pojo.Feedback;

/**
 * Servlet implementation class CommonFeedbackServlet
 */
@WebServlet("/CommonFeedbackServlet")
public class CommonFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Feedback_Dao_impl fdao = new Feedback_Dao_impl();

    public CommonFeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String action = request.getParameter("action");
		if ("viewfeedback".equalsIgnoreCase(action)) {
	            List<Feedback> fList = fdao.getAllFeedback();
	            request.setAttribute("feedbackList", fList);
	            RequestDispatcher rd = request.getRequestDispatcher("feedbackList.jsp");
	            rd.forward(request, response);
	        }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		   String action = request.getParameter("action");

	        if ("addfeedback".equalsIgnoreCase(action)) {
	            String name = request.getParameter("custname");
	            String contact = request.getParameter("custContactNo");
	            String email = request.getParameter("custemailId");
	            String feedbackText = request.getParameter("feedback");
	            String foodTaste = request.getParameter("foodTaste");
	            String serviceReview = request.getParameter("serviceReview");

	            Feedback f = new Feedback();
	            f.setCustname(name);
	            f.setCustContactNo(contact);
	            f.setCustemailId(email);
	            f.setFeedback(feedbackText);
	            f.setFoodTaste(foodTaste);
	            f.setServiceReview(serviceReview);

	            boolean result = fdao.addFeedback(f);

	            if (result) {
	                response.sendRedirect("index.jsp");
	            } else {
	                response.sendRedirect("Error.jsp");
	            }
	        } else {
	            response.sendRedirect("Error.jsp");
	        }
	    }
	}


