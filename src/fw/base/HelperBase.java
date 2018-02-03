package fw.base;

import fw.ApplicationManager;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;

import javax.swing.*;

public class HelperBase {
    protected final ApplicationManager manager;
    protected final JFrameOperator mainFrame;

    public HelperBase(ApplicationManager applicationManager){
        this.manager = applicationManager;
        this.mainFrame = manager.getApplication();
    }

    protected String waitMessageDialog(String title, int timeout) {
        long startTime = System.currentTimeMillis();
        long currentTime = startTime;

        while(currentTime< startTime+timeout){
            JDialog dialog = JDialogOperator.findJDialog(mainFrame.getOwner(), title, false, false);
            if(dialog != null){
                JDialogOperator dialogOperator = new JDialogOperator(dialog);
                String message = new JLabelOperator(dialogOperator).getText();
                dialogOperator.requestClose();
                return message;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
