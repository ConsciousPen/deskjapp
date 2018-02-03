package fw.helpers;

import fw.ApplicationManager;
import fw.Folders;
import fw.base.HelperBase;
import org.netbeans.jemmy.operators.JMenuBarOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import java.util.ArrayList;
import java.util.List;

public class MenuHelper extends HelperBase {

    public MenuHelper(ApplicationManager applicationManager) {
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

    public void clickNewFolderButton(String folder) {
        JMenuBarOperator jMenuBarOperator = new JMenuBarOperator(mainFrame);
        jMenuBarOperator.pushMenuNoBlock("File|New Folder...");
    }
}
