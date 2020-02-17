package archiver;

import archGUI.Archiver;

import java.io.IOException;


public class TextOutput {

    public static void writeMessage(String message) {
        Archiver.getTextArea().append(message);
    }

    public static String readString() throws IOException {
        String text = String.valueOf(Archiver.getFileChooser().getSelectedFile());
        return text;
    }

    public static String saveString() throws IOException {
        String text = String.valueOf(Archiver.getFileChooser()
                .getSelectedFile())
                .replaceFirst("[.][a-z][a-z][a-z]", ".zip");
        return text;
    }

    public static String extractString() throws IOException {
        String text = String.valueOf(Archiver.getFileChooser()
                .getSelectedFile())
                .replaceFirst("[.][a-z][a-z][a-z]", "");
        return text;
    }
}
