package uk.ac.soton.ldanalytics;

import org.eclipse.jetty.server.Server;


/**
 * The simplest possible Jetty server.
 */
public class TdbServer
{
	public static void main( String[] args ) throws Exception
    {
		
		
		String tdbDir = "/Users/eugene/LSD_TDB_databases";
				
		if(args.length>0) {
			tdbDir = args[0];
		}
		
        Server server = new Server(8080);
        server.setHandler(new TdbQueryHandler(tdbDir));
 
        server.start();
        server.join();

    }
}