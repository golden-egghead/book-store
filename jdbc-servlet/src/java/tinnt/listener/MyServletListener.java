/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinnt.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import tinnt.util.PropertiesFileHelper;

/**
 * Web application lifecycle listener.
 *
 * @author Tin
 */
public class MyServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        System.out.println("Application is deploying........");
//
//        ServletContext context = sce.getServletContext();
//        String siteMapsPath = context.getInitParameter("SITE_MAPS_FILE");
//
//        Properties properties = new Properties();
//        InputStream is = null;
//        try {
//            is = context.getResourceAsStream(siteMapsPath);
//            properties.load(is);
//            context.setAttribute("SITEMAPS", properties);
//        } catch (IOException ex) {
//            context.log("MyServletListener _ IO" + ex.getMessage());
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException ex) {
//                    context.log("MyServletListener _ IO" + ex.getMessage());
//                }
//            }
//        }
        ServletContext context = sce.getServletContext();
        String siteMapLocation
                = context.getInitParameter(
                        "SITE_MAPS_FILE");
        Properties siteMapProperty
                = PropertiesFileHelper.getProperties(context,
                        siteMapLocation);
        context.setAttribute("SITEMAPS", siteMapProperty);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application is destroying........");
    }
}
