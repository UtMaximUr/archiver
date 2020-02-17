package command;

import archiver.TextOutput;
import archiver.ZipFileManager;
import exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ZipFileManager zipFileManager = getZipFileManager();
            Path sourcePath = Paths.get(TextOutput.readString());
            zipFileManager.createZip(sourcePath);
            TextOutput.writeMessage("Архив создан.\n");

        } catch (PathIsNotFoundException e) {
            TextOutput.writeMessage("Вы неверно указали имя файла или директории.\n");
        }
    }
}