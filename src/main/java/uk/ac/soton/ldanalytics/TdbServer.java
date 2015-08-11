package uk.ac.soton.ldanalytics;

import org.eclipse.jetty.server.Server;


/**
 * The simplest possible Jetty server.
 */
public class TdbServer
{
	public static void main( String[] args ) throws Exception
    {
        Server server = new Server(8080);
        server.setHandler(new TdbQueryHandler());
 
        server.start();
        server.join();
    }
}