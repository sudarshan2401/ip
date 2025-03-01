package harvard;
/**
 * Represents a unmark command.
 */
public class UnmarkCommand extends Command {
    private int index;
    /**
     * Constructs a UnmarkCommand object.
     *
     * @param index The index of the task to be unmarked.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }
    /**
     * Returns true if the command is an exit command.
     *
     * @return True if the command is an exit command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (index >= tasks.size() || index < 0) {
            throw new DukeException("OOPS!!! The task number does not exist.");
        }
        Task task = tasks.get(index);
        task.markAsUndone();

        storage.save(tasks);
        return ui.showUndone(task);
    }
}
