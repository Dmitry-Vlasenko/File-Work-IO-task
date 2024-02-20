package app.config;

import app.utils.FilesUtil;

public class Config {
    private static final String FOLDER_NAME = "files";
    public static final String BASE_DIRECTORY = FilesUtil.createBaseDirectory(FOLDER_NAME);
    public static final String FILE_FORMAT = ".txt";

}
