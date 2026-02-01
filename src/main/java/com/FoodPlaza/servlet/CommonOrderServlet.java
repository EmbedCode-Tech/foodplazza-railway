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

import com.FoodPlaza.dao.Order_Dao_impl;
import com.FoodPlaza.pojo.Order;
/**
 * Servlet implementation class CommonOrderServlet
 */
@WebServlet("/CommonOrderServlet")
public class CommonOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Order_Dao_impl odi = new Order_Dao_impl();
    public CommonOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String action = request.getParameter("action");
	        HttpSession session = request.getSession();
	        String username = (String) session.getAttribute("CustomerUserName");

	        System.out.println("Action: " + action);
			System.out.println("Logged in User: " + username);

	        if ("vieworder".equalsIgnoreCase(action)) {
	            odi.updateOrdersToDeliveredAfterOneHour();
	            List<Order>  orderList = odi.showOrderByEmailId(username);


	            System.out.println("Username: " + username);
	            System.out.println("Order list size: " + orderList.size());

	            session.setAttribute("orderlist", orderList);
	            RequestDispatcher rd = request.getRequestDispatcher("ShowOrders.jsp");
	            rd.forward(request, response);
	        }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
