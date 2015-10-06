package com.springapp.mvc;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class AppTests {
    public static void main(String[] args) throws Exception {

        System.setProperty("spring.profiles.active", "dev");

        ConfigPrepare.initProperties("application.properties");
        Server server = new Server(8002);

        WebAppContext context = new WebAppContext();
        //金融云
        //context.setDescriptor("/WEB-INF/web.xml");
        //主站
        context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        context.setResourceBase("src/main/webapp");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
