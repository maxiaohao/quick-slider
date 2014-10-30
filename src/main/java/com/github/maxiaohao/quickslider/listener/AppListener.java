package com.github.maxiaohao.quickslider.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.github.maxiaohao.quickslider.handler.PersistenceHandler;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
public class AppListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public AppListener() {
        // TODO Auto-generated constructor stub
    }


    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        PersistenceHandler.getInstance().loadAll();
    }


    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        PersistenceHandler.getInstance().saveAll();
    }

}
