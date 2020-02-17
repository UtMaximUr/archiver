package command;

import archiver.TextOutput;
import archiver.ZipFileManager;
import exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ZipFileManager zipFileManager = getZipFileManager();
            Path destinationPath = Paths.get(TextOutput.extractString());
            zipFileManager.extractAll(destinationPath);
            TextOutput.writeMessage("Архив был распакован.\n");

        } catch (PathIsNotFoundException e) {
            TextOutput.writeMessage("Неверный путь для распаковки.\n");
        }
    }
}