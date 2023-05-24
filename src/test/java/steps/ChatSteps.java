package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MessangerPage;
import pages.forms.LeftMenuForm;
import pages.forms.chat.ChatCreationForm;
import pages.forms.chat.ConversationForm;
import pages.modals.AudioAttachmentModal;
import pages.modals.PhotoAttachmentModal;

import java.io.File;

public class ChatSteps {
    private final ChatCreationForm chatCreationForm = new ChatCreationForm();
    private final ConversationForm conversationForm = new ConversationForm();
    private final LeftMenuForm leftMenuForm = new LeftMenuForm();
    private final AudioAttachmentModal audioAttachmentModal = new AudioAttachmentModal();
    private final PhotoAttachmentModal photoAttachmentModal = new PhotoAttachmentModal();
    private final MessangerPage messangerPage = new MessangerPage();

    @Step("Открыть Мессенджер")
    public void openMessenger(){
        leftMenuForm.clickMenuItem(LeftMenuForm.Item.MESSENGER);
        messangerPage.waitForPageToLoad();
    }

    @Step("Создать новый чат")
    public void createNewChat(String chatName){
        messangerPage.clickCreateNewConversation();
        chatCreationForm.fillChatName(chatName);
        chatCreationForm.clickCreateNewConversation();
    }

    @Step("Прикрепить фото")
    public void attachPhoto(File photo){
        conversationForm.selectMediaSelector(ConversationForm.MediaSelectorItem.PHOTO);
        photoAttachmentModal.uploadFile(photo);
        conversationForm.waitForPhotoToLoad();
    }

    @Step("Прикрепить первую аудиозапись из сохранённых")
    public void attachFirstAudio(){
        conversationForm.selectMediaSelector(ConversationForm.MediaSelectorItem.AUDIO);
        audioAttachmentModal.attachFirstAudio();
    }

    @Step("Отправить сообщение")
    public void sendMessage(){
        conversationForm.clickSendButton();
    }

    @Step("Проверить, что чат создан")
    public void assertChatCreated(String chatName){
        Assert.assertEquals(conversationForm.getChatName(), chatName,
                "Incorrect chat name, probably new chat wasn't created");
    }

    @Step("Проверить, что в последнем сообщении есть фото")
    public void assertLastMessageContainsPhoto(){
        Assert.assertTrue(conversationForm.isPhotoPresentInLastMessage(), "There is no photo in last message");
    }

    @Step("Проверить, что в последнем сообщении есть аудио")
    public void assertLastMessageContainsAudio(){
        Assert.assertTrue(conversationForm.isAudioPresentInLastMessage(), "There is no audio in last message");
    }

    @Step("Отправить сообщение и проверить, что появилось новое сообщение в истории")
    public void sendMessageAndAssertItWasSent(){
        Long lastMessageId = getLastMessageId();
        sendMessage();
        assertNewMessageAdded(lastMessageId);
    }

    @Step("Получить id последнего сообщения")
    private Long getLastMessageId(){
        return conversationForm.getLastMessageDataTsOrZero();
    }

    @Step("Проверить, что id последнего сообщения изменился")
    private void assertNewMessageAdded(Long lastMessageId){
        Assert.assertNotEquals(conversationForm.getLastMessageDataTsOrZero(), lastMessageId,
                "MessageId in last message is the same but should be different");}


}
