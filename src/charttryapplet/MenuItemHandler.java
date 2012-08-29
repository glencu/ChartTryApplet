/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charttryapplet;

/**
 *
 * @author akg023
 */
public class MenuItemHandler {
    private ChartTryApplet _jframe;
    public MenuItemHandler(ChartTryApplet jframe)
    {
       this._jframe = jframe;
    }
    
    public void handleNew()
    {
      System.exit(0);
    }
    
    public void handleOpen()
    {
      System.exit(0);
    }
    
    public void handleExit()
    {
      System.exit(0);
    }
    
}
