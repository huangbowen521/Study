package huangbowen.net.DependecyInjection.SetterInjection;

import huangbowen.net.DependecyInjection.ConstructorInjection.MessageService;

public class MessageHandler {

    private MessageService messageService;

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public String handle() {
        return messageService.sendService();
    }
}
