/**
 * 
 */
package display;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * @author joelmanning
 *
 */
public class Button extends JButton
{

    /**
     * 
     */
    private static final long serialVersionUID = 2859310070625739618L;
    private Color normal;
    private Color hovering;
    public Button(int x, int y, int width, int height, String initial, Color normal, Color hovering){
        super(initial);
        setBounds(x, y, width, height);
        this.normal = normal;
        this.hovering = hovering;
        setForeground(normal);
        addMouseListener(new Highlighter());
    }
    public Button(int x, int y, int width, int height, String initial, Color hovering){
        this(x, y, width, height, initial, Color.BLACK, hovering);
    }
    public Button(int x, int y, int width, int height, String initial){
        this(x, y, width, height, initial, Color.RED);
    }
    class Highlighter implements MouseListener {

        /* (non-Javadoc)
         * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseClicked(MouseEvent e)
        {
            // TODO Auto-generated method stub
            
        }

        /* (non-Javadoc)
         * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
         */
        @Override
        public void mousePressed(MouseEvent e)
        {
            // TODO Auto-generated method stub
            
        }

        /* (non-Javadoc)
         * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseReleased(MouseEvent e)
        {
            // TODO Auto-generated method stub
            
        }

        /* (non-Javadoc)
         * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseEntered(MouseEvent e)
        {
            setForeground(hovering);
        }

        /* (non-Javadoc)
         * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseExited(MouseEvent e)
        {
            setForeground(normal);
        }
        
    }
}
