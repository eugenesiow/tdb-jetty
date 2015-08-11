package uk.ac.soton.ldanalytics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;

public class TdbQueryHandler implements Handler {

	public void addLifeCycleListener(Listener arg0) {
		// TODO Auto-generated method stub

	}

	public boolean isFailed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStarting() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStopped() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStopping() {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeLifeCycleListener(Listener arg0) {
		// TODO Auto-generated method stub

	}

	public void start() throws Exception {
		// TODO Auto-generated method stub

	}

	public void stop() throws Exception {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public Server getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	public void handle( String target,
            Request baseRequest,
            HttpServletRequest request,
            HttpServletResponse response ) throws IOException,
                                          ServletException {
		response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        String query = request.getParameter("query");
 
//        PrintWriter out = response.getWriter();
        
        System.out.println("query"+query);
        System.out.println("target"+target);
 
//        out.println("<h1>" + query + "</h1>");
         
        baseRequest.setHandled(true);

	}

	public void setServer(Server arg0) {
		// TODO Auto-generated method stub

	}

}
