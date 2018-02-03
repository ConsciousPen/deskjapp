package tests;

import fw.Folders;
import fw.base.TestBase;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestFolderCreation extends TestBase {

    @Test
    public void testFolderCreation() {
        String folder = "NewFolder";

        Folders existingFolders = app.getFolderHelper().getFolders();
        assertThat(app.getFolderHelper().createFolder(folder), is(notNullValue()));
        Folders newFolders = app.getFolderHelper().getFolders();
        assertThat(newFolders, equalTo(existingFolders.withAdded(folder)));
    }

    @Test
    public void testXFoldersCreation() {
        String folder1 = "NewFolder1";
        String folder2 = "NewFolder2";

        Folders existingFolders = app.getFolderHelper().getFolders();

        assertThat(app.getFolderHelper().createFolder(folder1), is(notNullValue()));

        Folders existingFolders1 = app.getFolderHelper().getFolders();
        assertThat(existingFolders1, equalTo(existingFolders.withAdded(folder1)));

        Folders existingFolders2 = app.getFolderHelper().getFolders();
        assertThat(app.getFolderHelper().createFolder(folder2), is(notNullValue()));

        assertThat(existingFolders2, equalTo(existingFolders2.withAdded(folder2)));

    }

    @Test
    public void testFolderCreationSameName() {
        String folder = "NewFolder3";

        Folders oldFolders = app.getFolderHelper().getFolders();

        assertThat(app.getFolderHelper().createFolder(folder), is(notNullValue()));

        Folders existingFolders1 = app.getFolderHelper().getFolders();
        assertThat(existingFolders1, equalTo(oldFolders.withAdded(folder)));

        Folders existingFolders2 = app.getFolderHelper().getFolders();

        assertThat(app.getFolderHelper().createFolder(folder), containsString("Duplicated folder name"));
        assertThat(existingFolders2, equalTo(existingFolders1));

    }
}
