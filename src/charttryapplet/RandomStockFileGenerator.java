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
    
    static void generateFile(String input, String output)
    {
     File file = new File(input);
     File ofile = new File(output);
     
     int numberOfLines = evaluateNumberOFLines(file);
     Random generator = new Random();
     int count = generator.nextInt(numberOfLines);
     
      int cntr = 0;
        try {
            //use buffering, reading one line at a time
            //FileReader always assumes default encoding is OK!
            BufferedReader readerStream = new BufferedReader(new FileReader(file));
            BufferedWriter writerStream = new BufferedWriter(new FileWriter(ofile));
            try {
                String line = null;
                while ((line = readerStream.readLine()) != null) {
                    
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
    
}
