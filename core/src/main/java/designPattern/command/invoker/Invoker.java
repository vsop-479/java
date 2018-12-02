package designPattern.command.invoker;

import designPattern.command.command.Command;

/**
 * Created by zhouhui on 2018/12/2.
 */
public class Invoker {
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }


}
