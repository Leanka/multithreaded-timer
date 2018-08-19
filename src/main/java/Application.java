import container.TimerContainer;
import controller.MyTimerController;
import service.MyTimerOption;
import service.MyTimerService;
import service.TimerService;
import view.MyInput;
import view.MyView;

public class Application {
    public static void main(String[] args) {
        TimerService timerService = new MyTimerService(
                new MyTimerOption(
                        new MyTimerController(),
                        new TimerContainer(),
                        new MyView()),
                new MyInput(),
                new MyView());
        timerService.runTimerService();
    }
}
