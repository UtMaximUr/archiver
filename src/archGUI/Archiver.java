package archGUI;


import command.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Archiver extends JFrame {

    private static ZipCreateCommand zipCreateCommand = new ZipCreateCommand();
    private static ZipAddCommand zipAddCommand = new ZipAddCommand();
    private static ZipExtractCommand zipExtractCommand = new ZipExtractCommand();
    private static ZipContentCommand zipContentCommand = new ZipContentCommand();

    private static FileNameExtensionFilter filter = new FileNameExtensionFilter("zip", "zip");
    private static Archiver fileChooserView = new Archiver();
    private static JFileChooser fileChooser = new JFileChooser();
    private static JTextArea textArea;

    public static JFileChooser getFileChooser() {
        return fileChooser;
    }

    public static JTextArea getTextArea() {
        return textArea;
    }

    public static void run() {
        final JFrame window = new JFrame("Archiver");

        ImageIcon img = new ImageIcon("images.png");
        window.setIconImage(img.getImage());

        JPanel panelButton = new JPanel(new GridLayout(0, 1, 0, 5));
        JPanel panelText = new JPanel();

        textArea = new JTextArea();
        textArea.setBackground(Color.WHITE);
        textArea.setColumns(14);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black));
        textArea.setPreferredSize(new Dimension(230, 120));

        JButton packFilesToArchive = new JButton("упаковать файлы в архив");
        JButton addFileToArchive = new JButton("добавить файл в архив");
        JButton unzipTheArchive = new JButton("распаковать архив");
        JButton viewArchiveContents = new JButton("просмотреть содержимое архива");

        //panelButton.add(Box.createVerticalStrut(10));
        panelButton.add(packFilesToArchive);
        panelButton.add(addFileToArchive);
        panelButton.add(unzipTheArchive);
        panelButton.add(viewArchiveContents);
        panelText.add(textArea);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(panelButton);
        panel.add(panelText);

        window.getContentPane().add(panel, BorderLayout.CENTER);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**Событие для кнопки "упаковать файл в архив"/*/
        packFilesToArchive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    fileChooser.setDialogTitle("Выбор файла");
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int result = fileChooser.showOpenDialog(fileChooserView);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        fileChooser.getSelectedFile();
                        zipCreateCommand.execute();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        /**Событие для кнопки "добавить файл в архив"/*/
        addFileToArchive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    fileChooser.setDialogTitle("Выбор директории архива");
                    fileChooser.setFileFilter(filter);
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int result = fileChooser.showOpenDialog(fileChooserView);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        fileChooser.getSelectedFile();
                        zipAddCommand.execute();
                    }
                    fileChooser.setDialogTitle("Выбор директории файла");
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    result = fileChooser.showOpenDialog(fileChooserView);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        fileChooser.getSelectedFile();
                        zipAddCommand.choice();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        /**Событие для кнопки "распаковать архив"/*/
        unzipTheArchive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    fileChooser.setDialogTitle("Выбор файла");
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int result = fileChooser.showOpenDialog(fileChooserView);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        fileChooser.getSelectedFile();
                        zipExtractCommand.execute();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        /**Событие для кнопки "просмотреть содержимое архива"/*/
        viewArchiveContents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    fileChooser.setDialogTitle("Выбор файла");
                    fileChooser.setFileFilter(filter);
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int result = fileChooser.showOpenDialog(fileChooserView);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        fileChooser.getSelectedFile();
                        zipContentCommand.execute();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}

