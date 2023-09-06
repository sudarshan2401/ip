
package harvard;

/**
 * Represents a command to add a task.
 */

public class AddCommand extends Command {
    /**
     * The task to be added.
     */
    private Task task;

    /**
     * Constructs an AddCommand object.
     * @param task The task to be added.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes the command.
     * @param tasks The task list.
     * @param ui The user interface.
     * @param storage The storage.
     * @throws DukeException If there is an error executing the command.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.add(task);
        storage.save(tasks);
        return ui.showAddTask(task, tasks);
    }

    /**
     * Returns true if the command is an exit command.
     * @return True if the command is an exit command.
     */
    @Override
    public boolean isExit() {
        return false;
    }

}