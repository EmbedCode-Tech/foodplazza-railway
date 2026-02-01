package com.FoodPlaza.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FoodPlaza.dao.Cart_Dao_impl;
import com.FoodPlaza.dao.Food_Dao_impl;
import com.FoodPlaza.pojo.Cart;
import com.FoodPlaza.pojo.Food;

@WebServlet("/CommonFoodServlet")
public class CommonFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Food_Dao_impl fdao = new Food_Dao_impl();
	Cart_Dao_impl cdao = new Cart_Dao_impl();
	Cart c= new Cart();
	Food f = new Food();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		if (action == null || action.equals("view")) {
			List<Food> fli = fdao.getAllFood();
			session.setAttribute("foodlist", fli);
			request.getRequestDispatcher("Foodlist.jsp").forward(request, response);
		}

		else if (action != null && action.equalsIgnoreCase("edit")) {
			String foodId = request.getParameter("foodId");
//			 System.out.println("Edit action triggered");
//			    System.out.println("Received foodId: " + foodId);
			if (foodId != null && !foodId.isEmpty()) {
				int fid = Integer.parseInt(foodId);
				Food food = fdao.getfoodbyid(fid);
				request.setAttribute("food", food);
//				  System.out.println("Food object fetched: " + food);
      			request.getRequestDispatcher("EditFood.jsp").forward(request, response);
      			return;

			}
		} else if ("delete".equalsIgnoreCase(action)) {
			int foodId = Integer.parseInt(request.getParameter("foodId"));
			boolean deleted = fdao.deleteFood(foodId);
			System.out.println("Deleting Food ID: " + foodId);
			if (deleted) {
				request.setAttribute("UpdateSuccess", "Food deleted successfully.");
			} else {
				request.setAttribute("UpdateunSuccess", "Failed to delete food.");
			}
			  List<Food> foodlist = fdao.getAllFood();  // Update the food list
			    request.setAttribute("foodlist", foodlist);  // Pass updated food list
			    request.getRequestDispatcher("Foodlist.jsp").forward(request, response);
			}

			else if ("addtocart".equalsIgnoreCase(action)) {
				int foodId =Integer.parseInt(request.getParameter("foodId"));
				String email = (String) session.getAttribute("CustomerUserName");
				c.setEmailId(email);
				c.setFoodId(foodId);
				c.setFoodquantity(1);

				boolean f = cdao.addToCart(c);
				if(f) {
					request.setAttribute("AddedToCart" ,"Food added to cart Successfully");
					RequestDispatcher rd= request.getRequestDispatcher("Foodlist.jsp");
					rd.forward(request,response);
				}else {
					request.setAttribute("NotAddedToCart" ,"Food Not added to cart");
					RequestDispatcher rd= request.getRequestDispatcher("Foodlist.jsp");
					rd.forward(request,response);
					return;
				}

			}else if ("viewcart".equalsIgnoreCase(action)) {
				List <Cart> cli = new ArrayList<>();
				String email = (String) session.getAttribute("CustomerUserName");
				cli=cdao.showCartList(email);
				request.setAttribute("CartList",cli);
				RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request,response);
				return;
			}else {
			List<Food> fli = fdao.getAllFood();
			session.setAttribute("foodlist", fli);
			request.getRequestDispatcher("Foodlist.jsp").forward(request, response);
			}
		}




	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		if ("search".equalsIgnoreCase(action)) {
			String fsearch = request.getParameter("foodId");

			try {
				int id = Integer.parseInt(fsearch);
				f = fdao.searchFood(id);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			if (f != null) {
				request.setAttribute("searchFood", f);
			} else {
				request.setAttribute("notFound", "No food found for: " + fsearch);
			}

			request.getRequestDispatcher("SearchResult.jsp").forward(request, response);
		}


		else if ("add".equalsIgnoreCase(action)) {
			String foodName = request.getParameter("foodName");
			String foodCategory = request.getParameter("foodCategory");
			String foodType = request.getParameter("foodType");
			double foodPrice = Double.parseDouble(request.getParameter("foodPrice"));

			Food newF = new Food();
			newF.setFoodname(foodName);
			newF.setFoodcategory(foodCategory);
			newF.setFoodtype(foodType);
			newF.setFoodprice(foodPrice);

			boolean Add = fdao.addFood(newF);
			if (Add) {
				request.setAttribute("AddSuccess", "Food added successfully.");
			} else {
				request.setAttribute("AddFail", "Failed to add food.");
			}

			List<Food> foodlist = fdao.getAllFood();
			session.setAttribute("foodlist", foodlist);
			request.getRequestDispatcher("Foodlist.jsp").forward(request, response);
		}
		else if ("update".equalsIgnoreCase(action)) {

			int foodId = Integer.parseInt(request.getParameter("foodId"));
			String foodName = request.getParameter("foodName");
			String foodCategory = request.getParameter("foodCategory");
			String foodType = request.getParameter("foodType");
			double foodPrice = Double.parseDouble(request.getParameter("foodPrice"));

			Food updFood = new Food();
			updFood.setFoodid(foodId);
			updFood.setFoodname(foodName);
			updFood.setFoodcategory(foodCategory);
			updFood.setFoodtype(foodType);
			updFood.setFoodprice(foodPrice);

			boolean upStatus = fdao.updateFood(foodId, updFood);
			if (upStatus) {
				request.setAttribute("UpdateSuccess", "Food updated successfully.");
			} else {
				request.setAttribute("UpdateunSuccess", "Failed to update food.");
			}

		}

		List<Food> foodlist = fdao.getAllFood();
		session.setAttribute("foodlist", foodlist);
		request.getRequestDispatcher("Foodlist.jsp").forward(request, response);
	}
}
