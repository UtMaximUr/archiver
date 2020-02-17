package command;

import archiver.TextOutput;
import archiver.ZipFileManager;
import exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {

    ZipFileManager zipFileManager;
    @Override
    public void execute() throws Exception {
        try {
            zipFileManager = getZipFileManager();
        } catch (PathIsNotFoundException e) {
            TextOutput.writeMessage("Файл не был найден.\n");
        }
    }

    public void choice() throws Exception {
        try {
            Path sourcePath = Paths.get(TextOutput.readString());
            zipFileManager.addFile(sourcePath);
            TextOutput.writeMessage("Добавление в архив завершено.\n");
        } catch (PathIsNotFoundException e) {
            TextOutput.writeMessage("Файл не был найден.\n");
        }
    }

}
