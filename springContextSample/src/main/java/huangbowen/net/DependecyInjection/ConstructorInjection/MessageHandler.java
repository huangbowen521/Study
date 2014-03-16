package huangbowen.net.DependecyInjection.ConstructorInjection;

public class MessageHandler {

    private MessageService messageService;

    public MessageHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    public String handle() {
        return messageService.sendService();
    }
}
