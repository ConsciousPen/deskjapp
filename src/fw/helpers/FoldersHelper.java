package fw.helpers;

import fw.ApplicationManager;
import fw.Folders;
import fw.base.HelperBase;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import java.util.ArrayList;
import java.util.List;

public class FoldersHelper extends HelperBase {

    public FoldersHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public Folders getFolders() {
        List<String> list = new ArrayList<String>();
        JTreeOperator root = new JTreeOperator(mainFrame);

        Object[] rootElements = root.getChildren(root.getRoot());

        for(Object element : rootElements){
            list.add(element.toString());
        }

        return new Folders(list);
    }

    public String createFolder(String folder) {
        manager.getMenuHelper().clickNewFolderButton(folder);
        JDialogOperator dialog = new JDialogOperator(mainFrame);
        new JTextFieldOperator(dialog).setText(folder);
        new JButtonOperator(dialog,"OK").push();
        return waitMessageDialog("Warning",3000);
    }

}
