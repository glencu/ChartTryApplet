/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charttryapplet;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Bobasek
 */
public class FnChartsAppletStub implements AppletStub {

    private Applet _applet;
    private String symbol = null;
    public FnChartsAppletStub(Applet applet)
    {
       this._applet = applet;
    }
    public void setSymbol(String symbol)
    {
       this.symbol = new String(symbol);
    }
    
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
            return new String(symbol);
        else if ("AutoRefreshTime".equalsIgnoreCase(name))
            return new String("1");
        else
            return null;
    }

    @Override
    public AppletContext getAppletContext() {
        return null;
    }

    @Override
    public void appletResize(int width, int height) {
         this._applet.resize(width,height);
    }
    
}
