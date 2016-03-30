/**
 * 
 */
package display;

import javax.swing.JLabel;

/**
 * @author joelmanning
 *
 */
public class Label extends JLabel
{

    /**
     * 
     */
    private static final long serialVersionUID = 5408160433262682432L;
    
    public Label(int x, int y, int width, int height, String message){
        super(message);
        this.setBounds(x, y, width, height);
    }
}
