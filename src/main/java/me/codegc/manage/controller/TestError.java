package me.codegc.manage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import me.codegc.manage.model.Admin;
import me.codegc.manage.utils.JsonUtil;

/**
 * Servlet implementation class TestError
 */
public class TestError extends HttpServlet {
	
	//private static Logger log = Logger.getLogger(TestError.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestError() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			System.out.println(0/0);
		
		//JsonUtil.outJson(response, new Admin("admin", "adb123456", (byte) 1));
	}

}
