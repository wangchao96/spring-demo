import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.MessageService;

public class SpringIocDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("context 启动成功");
        MessageService messageService = applicationContext.getBean(MessageService.class);
        System.out.println(messageService.getMessage());
    }
}
