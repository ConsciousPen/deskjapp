package fw;

import fw.helpers.FoldersHelper;
import fw.helpers.MenuHelper;
import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;

import java.util.Properties;


public class ApplicationManager {

    private Properties properties;
    private static ApplicationManager singleton;
    private FoldersHelper folderHelper;
    private JFrameOperator mainframe;
    private MenuHelper menuHelper;

    public static ApplicationManager getInstance() {
		if(singleton == null){
		    singleton = new ApplicationManager();
        }
        return singleton;
    }

    public void stop(){
        getApplication().requestClose();
    }

    public void setProperties(Properties props){
        this.properties = props;
    }

    public String getProperties(String key){
        return properties.getProperty(key);
    }

    public FoldersHelper getFolderHelper() {
        if(folderHelper == null){
            folderHelper = new FoldersHelper(this);
        }
        return folderHelper;

    }

    public JFrameOperator getApplication() {
        if(mainframe == null){
            try {
                // Specify Main frame
                new ClassReference("addressbook.AddressBookFrame").startApplication();
                mainframe = new JFrameOperator("jAddressBook");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Start java app
        return mainframe;
    }

    public MenuHelper getMenuHelper() {
        if(menuHelper == null){
            menuHelper = new MenuHelper(this);
        }
        return menuHelper;
    }
}
