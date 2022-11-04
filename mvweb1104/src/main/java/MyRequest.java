

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyRequest
 *
 */
@WebListener
public class MyRequest implements ServletRequestListener, ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public MyRequest() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	logout("MyRequest init");
        ServletRequest sr = sre.getServletRequest();

        if (sr.getRemoteAddr().startsWith("0") && sr.getRemoteAddr().endsWith("1") 
        		|| sr.getRemoteAddr().startsWith("127")) {
            sr.setAttribute("isLogin", (Boolean)true);
        } else {
            sr.setAttribute("isLogin", (Boolean)false);
        }

    }
    
	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         logout("Over.");
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	logout("attributeAdded('" + srae.getName() + "', '"  + srae.getValue() + "')");
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }
	
    private void logout(String msg) {
        System.out.println(msg);
    }

}
