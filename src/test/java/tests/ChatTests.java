package tests;

import org.testng.annotations.Test;
import steps.ChatSteps;
import utils.FileUtils;
import utils.RandomUtils;

import java.io.File;

public class ChatTests extends BaseVkUiTest {
    public static final String TEST_IMAGE_FILENAME = "test.jpg";
    private final ChatSteps chatSteps = new ChatSteps();

    @Test
    public void createChatAndSendMessageWithAudio(){
        String randomChatName = RandomUtils.generateUniqueRandomString();
        chatSteps.openMessenger();

        chatSteps.createNewChat(randomChatName);
        chatSteps.assertChatCreated(randomChatName);

        chatSteps.attachFirstAudio();
        chatSteps.sendMessageAndAssertItWasSent();
        chatSteps.assertLastMessageContainsAudio();
    }

    @Test
    public void createChatAndSendMessageWithPhoto(){
        String randomChatName = RandomUtils.generateUniqueRandomString();
        File testImage = FileUtils.getTestDataFile(TEST_IMAGE_FILENAME);

        chatSteps.openMessenger();

        chatSteps.createNewChat(randomChatName);
        chatSteps.assertChatCreated(randomChatName);

        chatSteps.attachPhoto(testImage);
        chatSteps.sendMessageAndAssertItWasSent();
        chatSteps.assertLastMessageContainsPhoto();
    }
}
