/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package charttryapplet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Bobasek
 */
public class RandomStockFileGenerator {
    
    int count=0;
    
    String pathToFile = null;    
    
    public String getPathToFile()
    {
       return pathToFile;
    }
    
    void generateFile(String output)
    {
        if (pathToFile != null)
           this.generateFile(pathToFile, output);
    }
    void generateFile(String input, String output)
    {
        
     pathToFile = input;
     File file = new File(input);
     File ofile = new File(output);
     
     int numberOfLines = evaluateNumberOFLines(file);
     Random generator = new Random();
     count = generator.nextInt(numberOfLines);
     
      int cntr = 0;
        try {
            //use buffering, reading one line at a time
            //FileReader always assumes default encoding is OK!
            BufferedReader readerStream = new BufferedReader(new FileReader(file));
            BufferedWriter writerStream = new BufferedWriter(new FileWriter(ofile));
            try 
            {
                String line = null;
                while ((line = readerStream.readLine()) != null) 
                {
                    cntr++;            
                    if (cntr >= count) break;
                    writerStream.write(line+"\r\n");
                }
            }
            finally
            {
              readerStream.close();
              writerStream.close();
            }
        }
        catch(IOException e)
        {
          e.printStackTrace();   
        }

}
    
void addOneSession(String output)
{
    if (pathToFile != null)
        this.addOneSession(pathToFile, output);
}
    
void addOneSession(String input, String output)
{
     pathToFile = input;
     File file = new File(input);
     File ofile = new File(output);
     int cntr = 0;
     try {
            //use buffering, reading one line at a time
            //FileReader always assumes default encoding is OK!
            BufferedReader readerStream = new BufferedReader(new FileReader(file));
            BufferedWriter writerStream = new BufferedWriter(new FileWriter(ofile));
            try 
            {
                String line = null;
                while ((line = readerStream.readLine()) != null) 
                {
                    cntr++;            
                    if (cntr >= count+1) 
                    {
                        this.count++;
                        break;
                    }
                    writerStream.write(line+"\r\n");
                }
            }
            finally
            {
              readerStream.close();
              writerStream.close();
            }
        }
        catch(IOException e)
        {
          e.printStackTrace();   
        }
    
}
    
   static int evaluateNumberOFLines(File file)
    {
         int result = 0;
            try {
            //use buffering, reading one line at a time
            //FileReader always assumes default encoding is OK!
            BufferedReader input = new BufferedReader(new FileReader(file));
            try {
                String line = null; //not declared within while loop
        /*
                 * readLine is a bit quirky :
                 * it returns the content of a line MINUS the newline.
                 * it returns null only for the END of the stream.
                 * it returns an empty String if two newlines appear in a row.
                 */
                while ((line = input.readLine()) != null) {
                 result++;
                }
            }
            finally {
             input.close();
            }
           }
          catch (IOException ex){
           ex.printStackTrace();
         }   

        return result;
    }
   
   
  public static String getFileNameWithoutExtension(String fileName) {
  File file = new File(fileName);
  
      int index = file.getName().lastIndexOf('.');
      if (index>0&& index <= file.getName().length() - 2 ) {
       return file.getName().substring(0, index);
      }  
    return "";
    }

    
  }
