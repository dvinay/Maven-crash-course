package com.fuppino.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fuppino.product.bo.ProductBO;
import com.fuppino.product.dto.Product;

public class DisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		ProductBO productBO = (ProductBO) context.getBean("productbo");
		Product product = productBO.findProduct(Integer.parseInt(request.getParameter("id")));
		
		PrintWriter out = response.getWriter();
		out.println("product details");
		out.println("product ID: "+product.getId());
		out.println("product Name: "+product.getName());
		out.println("product Description: "+product.getDescription());
		out.println("product price: "+product.getPrice());
	}

}
