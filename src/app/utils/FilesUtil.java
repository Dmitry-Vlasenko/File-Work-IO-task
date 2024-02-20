package app.utils;


import java.io.File;
import java.nio.file.FileSystems;
import java.util.Hashtable;

public class FilesUtil {
    public String path;

    public FilesUtil(String path) {
        this.path = path;
    }

    public String stringToPrintExistFiles() {
        StringBuilder listFilesBuffer = new StringBuilder();
        listFilesBuffer.append("------------ EXIST FILES --------------\n");
        directoryFiles().forEach(
                (fileName, filePath) -> listFilesBuffer
                        .append("File name: ").append(fileName).append("\n")
        );
        return listFilesBuffer.toString();
    }


    private String[] existsDirectoryFilesList(String path) {
        File directory = new File(path);
        String[] files = directory.list();
        return files != null ? files : new String[0];
    }

    private boolean isPathDirCheck(String path) {
        return new File(path).isDirectory();
    }

    private void addFilesFromDirectory(String path, Hashtable<String, String> filesTable) {
        for (String fileName : existsDirectoryFilesList(path)) {
            String fullPath = path + fileName;

            if (isPathDirCheck(fullPath)) {
                addFilesFromDirectory(fullPath, filesTable);
            } else {
                filesTable.put(fileName, fullPath);
            }
        }
    }

    public Hashtable<String, String> directoryFiles() {
        Hashtable<String, String> filesTable = new Hashtable<>();
        addFilesFromDirectory(this.path, filesTable);
        return filesTable;
    }

    public static String createBaseDirectory(String folder_name) {
        String systemSeparator = FileSystems.getDefault().getSeparator();
        String baseDirectory = System.getProperty("user.dir") + systemSeparator + folder_name + systemSeparator;
        File directory = new File(baseDirectory);
        if (!directory.exists()) {
            boolean wasSuccessful = directory.mkdirs();
            if (!wasSuccessful) {
                System.out.println("Failed to create directory");
            }
        }
        return baseDirectory;
    }
}
