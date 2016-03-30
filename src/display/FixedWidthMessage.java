/**
 * 
 */
package display;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * @author joelmanning
 *
 */

public class FixedWidthMessage {

    private static final String html1 = "<html><body style='width: ";
    private static final String html2 = "px'>";
    public static void main(String[] srgs) {
        final String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eu nulla urna. Donec sit amet risus nisl, a porta enim. Quisque luctus, ligula eu scelerisque gravida, tellus quam vestibulum urna, ut aliquet sapien purus sed erat. Pellentesque consequat vehicula magna, eu aliquam magna interdum porttitor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed sollicitudin sapien non leo tempus lobortis. Morbi semper auctor ipsum, a semper quam elementum a. Aliquam eget sem metus.";
        final String html1 = "<html><body style='width: ";
        final String html2 = "px'>";

        Runnable r = new Runnable() {

            @Override
            public void run() {
                JOptionPane.showMessageDialog(
                        null, new JLabel(html1 + "200" + html2 + s));
                JOptionPane.showMessageDialog(
                        null, new JLabel(html1 + "300" + html2 + s));
            }
        };
        SwingUtilities.invokeLater(r);
    }
    
    public static void showMessage(String s, int width){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(
                        null, new JLabel(html1 + width + html2 + s));
            }
        };
        SwingUtilities.invokeLater(r);
    }
    public static void showMessage(String s, String title, int messageType, int width){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(
                        null, new JLabel(html1 + width + html2 + s), title, messageType);
            }
        };
        SwingUtilities.invokeLater(r);
    }
    public static void showMessage(String s, String title, int messageType, Icon icon, int width){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(
                        null, new JLabel(html1 + width + html2 + s), title, messageType, icon);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}
