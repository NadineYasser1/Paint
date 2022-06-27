/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Classes.Circle;
import Classes.Square;
import Classes.Line;
import Classes.Rectangle;
import Classes.Shape;
import Classes.Square;
import Classes.Triangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Board extends JPanel implements MouseListener,MouseMotionListener {
    int mode = -1;//0 for line - 1forcirclele - 2 forrectangle 
    int x1,y1;
    int x2,y2;
    int x3,y3;
   
    boolean first=false;
    Color color=Color.black;
    int col=0;//0 for black color
    
    ArrayList<Shape> shapes=new ArrayList<>();;
    public Board (){
        
        addMouseListener( this );
        addMouseMotionListener( this );
          
    }
    
    
    @Override
   protected void paintComponent(Graphics g){
       super.paintComponent(g);
       for(int i=0;i<shapes.size();i++){
           if(shapes.get(i)instanceof Line){
               
               Line l=(Line)shapes.get(i);
               g.setColor(l.getColor());
               g.drawLine(l.getX1(),l.getY1(),l.getX2(), l.getY2() );
           }
           
             else if (shapes.get(i)instanceof Circle){
                 
               Circle c=(Circle)shapes.get(i);
               g.setColor(c.getColor());
               g.drawOval(c.getX1() ,c.getY1() ,c.getX2(), c.getY2());
           
             }
             
           else if (shapes.get(i)instanceof Rectangle){
                 
               Rectangle r=(Rectangle)shapes.get(i);
               g.setColor(r.getColor());
               g.drawRect(r.getX1() ,r.getY1() ,r.getX2() ,r.getY2());
           }
           else if (shapes.get(i)instanceof Square){
                 
               Square s=(Square)shapes.get(i);
               g.setColor(s.getColor());
               g.drawRect(s.getX1() ,s.getY1() ,s.getX2() ,s.getY2());
           }
           else if(shapes.get(i)instanceof Triangle){
               Triangle t = (Triangle)shapes.get(i);
               g.setColor(t.getColor());
               g.drawPolygon(t.getX(), t.getY(), 3);
               
           }
           
       }
   }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
         x1=e.getX();
         y1=e.getY();
         int [] x={x1,x1,x1};
         int [] y={y1,y1,y1};
               if(mode==0){ 
               Line l=new Line(x1,y1,x1,y1,color);
                shapes.add(l);}
               else if(mode==1){
                 Circle c = new Circle (x1,y1,x1,y1,color);
                 shapes.add(c);
               }
               else if(mode==2){
                 Rectangle r=new Rectangle (x1 ,y1,x1,y1,color);
                 shapes.add(r);
               }
               else if(mode==3){
                 Square s = new Square (x1 ,y1,x1,y1,color);
                 shapes.add(s );
               }
               else if(mode==4){
                   Triangle t = new Triangle(x,y,color);
                   shapes.add(t);
               }
               
        
            
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
      
        x2=e.getX();
        y2=e.getY();
        if(mode!=4){
        Shape s = shapes.get(shapes.size() - 1);
        if(s instanceof Line ){
          Line l = (Line) s;
          l.setX2(x2);
          l.setY2(y2);
        }
        else if (s instanceof Rectangle)
        {
         
          Rectangle r = (Rectangle) s;
          r.setX2(x2);
          r.setY2(y2);
        }
        else if (s instanceof Circle)
        {
         
          Circle c = (Circle) s;
          c.setX2(x2);
          c.setY2(y2);
        }
        else if (s instanceof Square)
        {
         
          Square sq = (Square) s;
          sq.setX2(x2);
          sq.setY2(x2);
        }
        repaint();
        first=false;
        }else if(mode==4){
            Graphics g=getGraphics();
            g.setColor(color);
            g.fillOval(e.getX(),e.getY(),7,7);
            
            
        }
        
        
        
    
     }
    

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    }

   

             
    
   
    
    
       
