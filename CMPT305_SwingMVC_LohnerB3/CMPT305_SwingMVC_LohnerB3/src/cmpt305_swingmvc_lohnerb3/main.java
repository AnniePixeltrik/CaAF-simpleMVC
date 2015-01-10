
package cmpt305_swingmvc_lohnerb3;

/**
 *
 * @author Brittany Lohner
 */
public class main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainGUI gui = new MainGUI();
                MainController controller = new MainController(gui);
                controller.showGUI();
            }
        
        });
    }
}
