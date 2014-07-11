package main;
import java.text.ParseException;

import system.controller.Controller;
import system.domain.model.Library;

import system.view.LibraryGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main
{
   
   /**
    * The main method.
    *
    * @param args the arguments
    * @throws ParseException the parse exception
    */
   public static void main(String args[]) throws ParseException
   {
      Library library = new Library();
      LibraryGUI gui = new LibraryGUI();
      Controller controller = new Controller(library, gui);
      gui.startGui(controller);
   }
}