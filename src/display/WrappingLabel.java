/**
 * 
 */
package display;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.LineBreakMeasurer;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.swing.JLabel;

/**
 * @author joelmanning
 *
 */
public class WrappingLabel extends JLabel
{

    /**
     * 
     */
    private static final long serialVersionUID = -828207621309826206L;
    
    private LineBreakMeasurer breaker;
    
    public WrappingLabel(int x, int y, int width, int height, String label){
        super(label);
        setBounds(x, y, width, height);
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        AttributedString text = new AttributedString(getText());
        AttributedCharacterIterator iter = text.getIterator();
        breaker = new LineBreakMeasurer(iter, g2d.getFontRenderContext());
        while(breaker.getPosition() < iter.getEndIndex()){
            breaker.
        }
    }
}
