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

public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer productId = Integer.parseInt(request.getParameter("id"));
		String productName = request.getParameter("name");
		String productDescription =request.getParameter("description");
		Integer productPrice = Integer.parseInt(request.getParameter("price"));
		
		Product product = new Product(productId, productName, productDescription, productPrice);
		
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		ProductBO productBO = (ProductBO) context.getBean("productbo");
		productBO.create(product);
		
		PrintWriter out = response.getWriter();
		out.print("product created!!");
	}

}
