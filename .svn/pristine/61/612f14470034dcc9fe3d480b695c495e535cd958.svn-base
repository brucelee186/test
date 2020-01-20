package chess;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
class ChessPad extends Panel implements MouseListener,ActionListener
{  int x=-1,y=-1, 棋子颜色=1;
   Button button=new Button("重新开局"); 
   TextField text_1=new TextField("请黑棋下子"),
             text_2=new TextField();
   ChessPad()
   {  setSize(440,440);
      setLayout(null);setBackground(Color.orange);
      addMouseListener(this);add(button);button.setBounds(10,5,60,26);
      button.addActionListener(this);
      add(text_1);text_1.setBounds(90,5,90,24);
      add(text_2);text_2.setBounds(290,5,90,24);
      text_1.setEditable(false);text_2.setEditable(false);
   }
   public void paint(Graphics g)              
   {  for(int i=40;i<=380;i=i+20)
       {  g.drawLine(40,i,400,i);
       }
      g.drawLine(40,400,400,400);
      for(int j=40;j<=380;j=j+20)
       { g.drawLine(j,40,j,400);
       }
       g.drawLine(400,40,400,400); 
       g.fillOval(97,97,6,6); g.fillOval(337,97,6,6);
       g.fillOval(97,337,6,6);g.fillOval(337,337,6,6);
       g.fillOval(217,217,6,6);
   }
   public void mousePressed(MouseEvent e)   
   {  if(e.getModifiers()==InputEvent.BUTTON1_MASK)
        {  x=(int)e.getX();y=(int)e.getY();   
           ChessPoint_black chesspoint_black=new ChessPoint_black(this);
           ChessPoint_white chesspoint_white=new ChessPoint_white(this);
           int a=(x+10)/20,b=(y+10)/20;
           if(x/20<2||y/20<2||x/20>19||y/20>19)   
            {}
           else
            { 
              if(棋子颜色==1)                     
               {  this.add(chesspoint_black);
                  chesspoint_black.setBounds(a*20-10,b*20-10,20,20);
                  棋子颜色=棋子颜色*(-1);             
                  text_2.setText("请白棋下子");
                  text_1.setText("");
               }
              else if(棋子颜色==-1)  
               {  this.add(chesspoint_white);
                  chesspoint_white.setBounds(a*20-10,b*20-10,20,20);
                   棋子颜色=棋子颜色*(-1);
                  text_1.setText("请黑棋下子");
                  text_2.setText("");
               }
            }
       }
   }
   public void mouseReleased(MouseEvent e){}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   public void mouseClicked(MouseEvent e){}
   public void actionPerformed(ActionEvent e)
   {  this.removeAll();棋子颜色=1;
      add(button);button.setBounds(10,5,60,26);
      add(text_1);text_1.setBounds(90,5,90,24);  
      text_2.setText("");text_1.setText("请黑棋下子");
      add(text_2);text_2.setBounds(290,5,90,24);
   }
}
class ChessPoint_black extends Canvas implements MouseListener
{  ChessPad chesspad=null; 
   ChessPoint_black(ChessPad p)
   {  setSize(20,20);chesspad=p; addMouseListener(this);
   }
   public void paint(Graphics g) 
   {  g.setColor(Color.black);g.fillOval(0,0,20,20);
   } 
   public void mousePressed(MouseEvent e) 
   {  if(e.getModifiers()==InputEvent.BUTTON3_MASK)
       {  chesspad.remove(this); 
          chesspad.棋子颜色=1;
          chesspad.text_2.setText("");chesspad.text_1.setText("请黑棋下子");
        }
   }
   public void mouseReleased(MouseEvent e){}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   public void mouseClicked(MouseEvent e)
   {  if(e.getClickCount()>=2)
         chesspad.remove(this); 
   }
}
class ChessPoint_white extends Canvas implements MouseListener
{  ChessPad chesspad=null;
   ChessPoint_white(ChessPad p)
   {  setSize(20,20);addMouseListener(this);
      chesspad=p; 
   }
   public void paint(Graphics g)
   {  g.setColor(Color.white);g.fillOval(0,0,20,20); 
   } 
   public void mousePressed(MouseEvent e)
   {  if(e.getModifiers()==InputEvent.BUTTON3_MASK)
        {  chesspad.remove(this);chesspad.棋子颜色=-1;
           chesspad.text_2.setText("请白棋下子"); chesspad.text_1.setText("");
        }
   }
   public void mouseReleased(MouseEvent e){}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   public void mouseClicked(MouseEvent e)
   {  if(e.getClickCount()>=2)
         chesspad.remove(this);
   }
}
public class Chess extends Frame 
{  ChessPad chesspad=new ChessPad();
   Chess()
   {  setVisible(true);
      setLayout(null);
      Label label=
    new Label("单击左键下棋子，双击吃棋子，用右键单击棋子悔棋",Label.CENTER);
      add(label);label.setBounds(70,55,440,26);
      label.setBackground(Color.orange); 
      add(chesspad);chesspad.setBounds(70,90,440,440);
      addWindowListener(new WindowAdapter()
                 {public void windowClosing(WindowEvent e)
                         {System.exit(0);
                         }
             });
     pack();setSize(600,550);
   }
public static void main(String args[])
   {  TestChess chess=new TestChess();
   }
}
