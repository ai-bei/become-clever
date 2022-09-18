package com.bytespaces;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import java.util.Collections;

/**
 * SpringBoot
 *
 * @author Annicko
 * 
 */
@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com.bytespaces"})
public class App extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.setBannerMode(Mode.CONSOLE);
        app.run(args);
    }

    /**
     * 部署Tomcat
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        // This will set to use COOKIE only
        servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));
        // This will prevent any JS on the page from accessing the
        // cookie - it will only be used/accessed by the HTTP transport
        // mechanism in use
        SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
        sessionCookieConfig.setHttpOnly(true);
    }

}
