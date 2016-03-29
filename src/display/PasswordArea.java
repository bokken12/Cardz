/**
 * 
 */
package display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPasswordField;

/**
 * @author joelmanning
 *
 */
public class PasswordArea extends JPasswordField
{

    /**
     * 
     */
    private static final long serialVersionUID = 230596738850175583L;

    public PasswordArea(int x, int y, int width, int height, String initial)
    {
        super(initial);
        setEchoChar((char)0);
        this.setBounds(x, y, width, height);
        this.addMouseListener(new Clearer());
    }

    class Clearer implements MouseListener
    {
        private boolean cleared;

        private Clearer()
        {
            cleared = false;
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if (!cleared)
            {
                setText("");
                setEchoChar('●');
                cleared = true;
            }
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
         */
        @Override
        public void mousePressed(MouseEvent e)
        {
            // TODO Auto-generated method stub

        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseReleased(MouseEvent e)
        {
            // TODO Auto-generated method stub

        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseEntered(MouseEvent e)
        {
            // TODO Auto-generated method stub

        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseExited(MouseEvent e)
        {
            // TODO Auto-generated method stub

        }

    }
}
