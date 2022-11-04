package model;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import model.UserInfo;

/**
 * Application Lifecycle Listener implementation class UserInfoBinding
 *
 */
@WebListener
public class UserInfoBinding implements HttpSessionBindingListener {
	
	private String username;
	private UserInfo ui = UserInfo.getInstance();

    /**
     * Default constructor. 
     */
    public UserInfoBinding() {
        this.username = "";
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent event)  { 
    	System.out.println("上線用戶 : " + this.username);
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	System.out.println("下線用戶 : " + this.username);
        if(this.username != ""){
            ui.removeUser(username);    //移除該上線用戶
        } 
    }
	
}
