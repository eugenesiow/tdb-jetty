package uk.ac.soton.ldanalytics;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.sparql.resultset.ResultsFormat;
import org.apache.jena.tdb.TDBFactory;
import org.eclipse.jetty.io.WriterOutputStream;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;

public class TdbQueryHandler implements Handler {
	
	private String tdbDir = null;
	
	public TdbQueryHandler(String tdbDir) {
		this.tdbDir = tdbDir;
	}

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
            HttpServletResponse response ) throws IOException {

		if(target.equals("/favicon.ico")) {
			baseRequest.setHandled(true);
			return;
		}
		
//		System.out.println(target);
		
		// open TDB dataset
		Dataset dataset = TDBFactory.createDataset(tdbDir+target);
		
//		System.out.println(target+"open");

		Model model = dataset.getDefaultModel();
		
		response.setContentType("application/sparql-results+json");
        response.setStatus(HttpServletResponse.SC_OK);
//        response.setHeader("Vary", "Accept,Accept-Encoding,Accept-Charset");
        
        PrintWriter pw = response.getWriter();
        OutputStream os = new WriterOutputStream(pw);
        
        String queryStr = request.getParameter("query");

        Query query = QueryFactory.create(queryStr) ;
        QueryExecution qexec = QueryExecutionFactory.create(query, dataset) ;
        ResultSet results = qexec.execSelect() ;
        
        if(results==null)
        	System.out.println("null");
        ResultSetFormatter.output(os,results,ResultsFormat.FMT_RS_JSON) ;
//        ResultSetFormatter.output(System.out,results,ResultsFormat.FMT_RS_JSON) ;
 
        model.close();
		dataset.close();
         
		baseRequest.setHandled(true);
	}

	public void setServer(Server arg0) {
		// TODO Auto-generated method stub

	}
	
//	private String getAccept(HttpServletRequest httpRequest)
//    {
//        // There can be multiple accept headers -- note many tools don't allow these to be this way (e.g. wget, curl)
//        @SuppressWarnings("unchecked")
//        Enumeration<String> en = httpRequest.getHeaders("Accept") ;
//        if ( ! en.hasMoreElements() )
//            return null ;
//        StringBuilder sb = new StringBuilder() ;
//        String sep = "" ;
//        for ( ; en.hasMoreElements() ; )
//        {
//            String x = en.nextElement() ;
//            sb.append(sep) ;
//            sep = ", " ;
//            sb.append(x) ;
//        }
//        return sb.toString() ;
//    }

}
