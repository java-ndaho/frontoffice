package com.honore.catalogue.controller;

import org.example.models.Artist;
import org.example.models.Catalogue;
import org.example.models.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (Catalogue.listsOfWorks.isEmpty()) {
            Artist tomCruise = new Artist("Tom");
            Artist honore = new Artist("Honore");
            Artist louis = new Artist("Louis");

            Work mirror = new Work("Mirror");
            Work bad = new Work("Bad");
            Work laLegende = new Work("laLegende");

            mirror.setMainArtist(tomCruise);
            mirror.setSummary("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy");
            mirror.setGenre("Science fiction");
            mirror.setAnnee("2019");

            bad.setMainArtist(honore);
            bad.setSummary("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters");
            bad.setGenre("pop");
            bad.setAnnee("2018");

            laLegende.setMainArtist(louis);
            laLegende.setSummary("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old");
            laLegende.setGenre("Comedie");
            laLegende.setAnnee("2020");
            Catalogue.listsOfWorks.addAll(Arrays.asList(mirror, bad, laLegende));

        }

        out.println("<html><body> <h1>Oeuvres au catalogue</h1><br>");
        for (Work cat : Catalogue.listsOfWorks) {
            String direction = "work-details?id=" + cat.getId();
            out.println("<p><a href=" + direction + ">" + cat.getTitle() + "</html></body> <br>");
        }

    }
}
