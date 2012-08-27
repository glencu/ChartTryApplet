/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charttryapplet;

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Bobasek
 */
public class FnChartsAppletStub implements AppletStub {

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public URL getDocumentBase() {
        return getCodeBase();
    }

    @Override
    public URL getCodeBase() {
        URL u = null;
	     try {
	      u = new URL("file://");
	     } catch (MalformedURLException e) {
	       }
	     return u;
    }

    @Override
    public String getParameter(String name) {
        
        if( "Encoding".equalsIgnoreCase(name) )
            return new String("ISO8859_1");
        else if ( "DataSource".equalsIgnoreCase(name) )
            return new String("data/{symbol}.txt");
        else if ("Symbol".equalsIgnoreCase(name))
            return new String("KGHM");
        else
            return null;
    }

    @Override
    public AppletContext getAppletContext() {
        return null;
    }

    @Override
    public void appletResize(int width, int height) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
