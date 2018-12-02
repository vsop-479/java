package designPattern.command.command;

/**
 * Created by zhouhui on 2018/12/2.
 */
public class ConcreteCommand implements Command{
    @Override
    public void execute() {
        System.out.println("execute");
    }
}
