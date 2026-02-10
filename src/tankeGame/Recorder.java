package tankeGame;

import java.io.*;

public class Recorder {

   private static int CutTank = 0 ;

   private static FileWriter fileWriter = null;

   private static BufferedWriter bufferedWriter = null ;

   private static String path = "/Users/crilv/Desktop/java项目/chapter10/record.txt";


   public static void keepR(){
       try {
           fileWriter = new FileWriter(path);
           bufferedWriter = new BufferedWriter(fileWriter);
           bufferedWriter.write(CutTank + "\n ");


       } catch (IOException e) {
           throw new RuntimeException(e);
       }finally {
           if (bufferedWriter != null){
               try {
                   bufferedWriter.close();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
           }
       }
   }


    public static int getCutTank() {
        return CutTank;
    }

    public static void setCutTank(int cutTank) {
        CutTank = cutTank;
    }

    public static void CutT(){
        CutTank++;
    }
}
