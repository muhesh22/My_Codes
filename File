
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class JavaReader {

 public static void main(String[] args) throws IOException {
  
  File file = new File("message.txt");

  if(file.exists()) {
   System.out.println("That file exists! :O!");
   //System.out.println(file.getPath());
   //System.out.println(file.getAbsolutePath());
   //System.out.println(file.isFile());
   
  }
  else {
   System.out.println("That file doesn't exist :(");
  }  
  //file writing
  FileWriter writer = new FileWriter("message.txt");
  writer.write("Hi\nMy name is Muhesh!!\nHow are you?");
  writer.close();
  
  //Reading a file
  FileReader reader = new FileReader("message.txt");
  int text = reader.read();
  while(text!=-1){
    System.out.print((char)text);
    text = reader.read();
  }
  reader.close();

 }
}
