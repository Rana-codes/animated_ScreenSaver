package animated_ScreenSaver;

//File: ShapeViewer
//Name: Harsh Rana

import java.awt.Color;

import javax.swing.JFrame;
public class Run_Viewer_ME
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 1000;
      final int FRAME_HEIGHT = 700;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      
      frame.setTitle("Shape");
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      ShapeComponent component = new ShapeComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}

