package com.honore.catalogue.controller;

import org.example.models.Catalogue;
import org.example.models.Work;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WorkDetailsServlet", urlPatterns = {"/work-details"})
public class WorkDetailsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final long id = Long.parseLong(request.getParameter("identifiant"));
        Work work = Catalogue.listsOfWorks.stream()
                .filter(w -> w.getId() == (id))
                .findFirst().get();

        request.setAttribute("work",work);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/work-details.jsp");
        requestDispatcher.forward(request, response);

    }
}
