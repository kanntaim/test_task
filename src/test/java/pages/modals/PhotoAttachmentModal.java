package pages.modals;

import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class PhotoAttachmentModal extends BasePage {
    public static final String MODAL_LOCATOR = "#photos_choose_upload_area_wrap";
    private final SelenideElement addFileInput = $(MODAL_LOCATOR + " input.file");

    public PhotoAttachmentModal() {
        super($(MODAL_LOCATOR));
    }

    public void uploadFile(File file){
        waitForPageToLoad();
        addFileInput.uploadFile(file);
    }
}
