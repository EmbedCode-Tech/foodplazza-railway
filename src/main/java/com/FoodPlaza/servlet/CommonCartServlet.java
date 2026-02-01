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

import com.FoodPlaza.dao.Cart_Dao_impl;
import com.FoodPlaza.dao.Order_Dao_impl;
import com.FoodPlaza.pojo.Cart;
import com.FoodPlaza.pojo.Order;

/**
 * Servlet implementation class CommonCartServlet
 */
@WebServlet("/CommonCartServlet")
public class CommonCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Cart_Dao_impl cdi = new Cart_Dao_impl();
    Order_Dao_impl odi=new Order_Dao_impl();

    public CommonCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String cartIdStr = request.getParameter("CartId");
		String username = (String) session.getAttribute("CustomerUserName");


		 if (action == null || action.equalsIgnoreCase("view")) {
	            List<Order> orderList = odi.showAllOrders();
	            session.setAttribute("orderlist", orderList);
	            request.getRequestDispatcher("OrderList.jsp").forward(request, response);
	        }
		 else if ("delete".equalsIgnoreCase(action)) {
			int cid = Integer.parseInt(cartIdStr);
			boolean result = cdi.deleteItemFromCart(cid);

			if (result) {
				request.setAttribute("DeleteCart", "Cart item deleted successfully");
			} else {
				request.setAttribute("NotDeleteCart", "Failed to delete cart item");
			}
		}else if("edit".equalsIgnoreCase(action)) {
			 int cartId = Integer.parseInt(request.getParameter("CartId"));
	            int newQty = Integer.parseInt(request.getParameter("CartQun"));
	            boolean result = cdi.updateQuntity(cartId, newQty);
	            if (result) {
	                request.setAttribute("UpdateCart", "Cart quantity updated successfully");
	            } else {
	                request.setAttribute("NotUpdateCart", "Failed to update quantity");
	            }
		}else if ("placeorder".equalsIgnoreCase(action)) {
		    boolean result = odi.placeOrder(username);
		    if (result) {
		        request.setAttribute("OrderPlaced", "Order placed successfully!");
		    } else {
		        request.setAttribute("OrderFailed", "Failed to place order.");
		    }
		}

		List<Cart> cli = cdi.showCartList(username);
		request.setAttribute("CartList", cli);

		RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
		rd.forward(request, response);
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
