package command;

import archiver.TextOutput;
import archiver.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command{

    public static ZipFileManager getZipFileManager() throws Exception{
        Path zipPath = Paths.get(TextOutput.saveString());
        return new ZipFileManager(zipPath);
    }
}
