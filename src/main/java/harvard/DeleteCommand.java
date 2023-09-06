
package harvard;

/**
 * Represents a delete command.
 */
public class DeleteCommand extends Command {
    /**
     * The index of the task to be deleted.
     */
    private int index;

    /**
     * Constructs a DeleteCommand object.
     * @param index The index of the task to be deleted.
     */
    public DeleteCommand(int index) {
        this.index = index;
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
        Task task = tasks.get(index);
        tasks.remove(index);

        storage.save(tasks);
        return ui.showDelete(task, tasks);
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