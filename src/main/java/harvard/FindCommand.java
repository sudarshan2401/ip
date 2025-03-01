package harvard;

/**
 * Represents a find command.
 */
public class FindCommand extends Command {
    /**
     * The keyword to be searched.
     */
    private String keyword;

    /**
     * Constructs a FindCommand object.
     * @param keyword The keyword to be searched.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        TaskList matchingTasks = tasks.find(keyword);
        return ui.showFind(matchingTasks);
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
