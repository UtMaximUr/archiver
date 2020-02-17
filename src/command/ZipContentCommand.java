package command;

import archiver.TextOutput;
import archiver.FileProperties;
import archiver.ZipFileManager;

import java.util.List;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ZipFileManager zipFileManager = getZipFileManager();
        List<FileProperties> files = zipFileManager.getFilesList();
        for (FileProperties file : files) {
            TextOutput.writeMessage(file.toString());
        }
    }
}
