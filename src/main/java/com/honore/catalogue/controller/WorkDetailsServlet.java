package com.honore.catalogue.controller;

import org.example.models.Catalogue;
import org.example.models.Work;

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
        final long id = Long.parseLong(request.getParameter("id"));
        Work work = Catalogue.listsOfWorks.stream()
                .filter(w->w.getId()==(id))
                .findFirst().get();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body><h1>Descriptif de l'oeuvre</h1> <br>");
        out.println("<p>Titre: "+work.getTitle()+"</p> <br>");
        out.println("<p>Annee: "+work.getAnnee()+"</p><br>");
        out.println("<p>Genre: "+work.getGenre()+"</p><br>");
        out.println("<p>Artiste: "+work.getMainArtist().getName()+"</p><br>");
        out.println("<p>Résumé: "+work.getSummary() +"</p></html></body> <br>");

    }
}
