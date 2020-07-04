package com.honore.catalogue.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.models.Catalogue;
import org.example.models.ShoppingCart;
import org.example.models.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "AddToCartServlet ",urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	
//    	recevoir l'identifiant de l’œuvre souhaitée
    	final Long id = Long.valueOf(request.getParameter("identifiant"));
    	
//    	rechercher dans le catalogue l’œuvre
        Optional<Work> optionalWork=Catalogue.listsOfWorks.stream().filter(work->work.getId()==id).findAny();
    	
    	HttpSession session=request.getSession();
    	session.setAttribute("identifiant","honore");
    	
    	ShoppingCart shoppingCart=(ShoppingCart)session.getAttribute("cart");
    
    	if(shoppingCart==null) {
//    		create cart
    		shoppingCart=new ShoppingCart();
    		session.setAttribute("cart",shoppingCart);	
    	}
        
        if(optionalWork.isPresent()){
    		shoppingCart.add(optionalWork.get());
        }
  
                   out.println("<html><body><p>Oeuvre ajoutée au caddie ("+shoppingCart.getItems().size()+")</p>");

                   out.println("<p> <a href=\"catalogue\">Retour catalogue</a></p>");
                    out.println("</body></html>");  
    		
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
    	
    }
}
