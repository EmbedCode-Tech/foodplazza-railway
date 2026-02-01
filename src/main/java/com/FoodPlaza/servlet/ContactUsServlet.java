package com.FoodPlaza.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FoodPlaza.dao.ContactusDao;
import com.FoodPlaza.dao.Contactus_Dao_impl;
import com.FoodPlaza.pojo.Contactus;

@WebServlet("/ContactUsServlet")
public class ContactUsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        ContactusDao cd = new Contactus_Dao_impl();

        if ("add".equalsIgnoreCase(action)) {
            String name = request.getParameter("custname");
            String contact = request.getParameter("contact");
            String email = request.getParameter("custemail");
            String address = request.getParameter("custaddress");
            String message = request.getParameter("message");

            Contactus c = new Contactus();
            c.setCustname(name);
            c.setContact(contact);
            c.setCustemailId(email);
            c.setCustAddress(address);
            c.setMessage(message);

            boolean added = cd.addContact(c);

            if (added) {
                request.setAttribute("msg", "Thank you! Your message has been sent.");
            } else {
                request.setAttribute("msg", "Oops! Something went wrong.");
            }


            request.getRequestDispatcher("Contactus.jsp").forward(request, response);
        }
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}