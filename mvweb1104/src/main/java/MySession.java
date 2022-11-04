

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySession
 *
 */
@WebListener
public class MySession implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    ServletContext context;
    int users;
	
    /**
     * Default constructor. 
     */
    public MySession() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	this.context = sce.getServletContext();
        logout("contextInitialized()-->ServletContext初始化了");
    }
    
    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
        this.context = null;
    	logout("contextDestroyed()-->ServletContext被銷毀");
    }
    
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	users++;
        logout("sessionCreated('" + se.getSession().getId() + "'),目前有"+users+"個用戶");
        context.setAttribute("users",Integer.valueOf(users));
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	users--;
        logout("sessionDestroyed('" + se.getSession().getId() + "'),目前有"+users+"個用戶");
        context.setAttribute("users",Integer.valueOf(users));
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	logout("attributeAdded('" + se.getSession().getId() + "', '" +  se.getName() + "', '" + se.getValue() + "')");
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

	public void logout(String msg) {
		System.out.println(msg);
	}
	
}
