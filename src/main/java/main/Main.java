package main;

import Servlet.MyServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

//Мейн класс - запустить сервер, приджойнить его, запросы слать на сервлет по обработке

public class Main {

    public static void main(String[] args) {
        MyServlet allRequestsServlet = new MyServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");

        Server server = new Server(8080);//сюда идем на локалхост. Для тестов.
        server.setHandler(context);


        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
