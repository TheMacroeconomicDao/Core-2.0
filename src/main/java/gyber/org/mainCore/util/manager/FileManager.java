package gyber.org.mainCore.util.manager;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Locale;

@Component
public class FileManager {

    /**
     * Директория фотографий профиля.
     */
    @Value("${base.directory.path}")
    private String baseDirectoryPath;
    //   private File classFile;
    /**
     * Файл для...
     */
    private File fileToSave;

    /**
     * Не знаю за что отвечает метод(Aomisha).
     */
    @PostConstruct
    public void init() {

        try {
            if (!new File(baseDirectoryPath).exists()) {
                new File(baseDirectoryPath).mkdir();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @return получаем...
     */
    public String[] getDirectories() {


        return null;
    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @param id id...
     * @param nickName никнейм...
     * @param file файл...
     * @return возвращает...
     */
    public FileManager reserveNameByFile(Long id, String nickName, File file) {

        String reversedNameFile = "";


        if (nickName.indexOf('@') != -1) {
            nickName = nickName.replace("@", "").toLowerCase(Locale.ROOT);
            System.out.println("nickName replaced : " + nickName);

        }

        reversedNameFile = id + "_" + nickName + file.getName().substring(file.getName().indexOf('.'));
        fileToSave = new File(baseDirectoryPath.concat(reversedNameFile));

        return this;

    }


    // for test

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @param id id...
     * @param nickName никнейм...
     * @param x х...
     * @return возвращает...
     */
    public String reserveNameByFile(Long id, String nickName, int x) {


        String reversedNameFile = "";


        if (nickName.indexOf('@') != -1) {
            nickName = nickName.replace("@", "").toLowerCase(Locale.ROOT);
            System.out.println("nickName replaced : " + nickName);

        }

        reversedNameFile = id + "_" + nickName;
        fileToSave = new File(baseDirectoryPath.concat(reversedNameFile));

        return reversedNameFile;

    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @param id id...
     * @param nickName никнейм...
     */
    public void delete(Long id, String nickName) {

        if (nickName.indexOf('@') != -1) {
            nickName = nickName.replace("@", "").toLowerCase(Locale.ROOT);
            System.out.println("nickName replaced : " + nickName);

        }
        String pathToDelete = baseDirectoryPath
                .concat(id + "")
                .concat("_")
                .concat(nickName);


        if (!new File(pathToDelete).delete()) {
            System.err.println("FILE " + pathToDelete + "DON'T DELETED");
            return;
        }

        System.out.println("FILE DELETE SUCCESSFUL!");


    }
    /**
     * Не знаю за что отвечает метод(Aomisha).
     */
    public void save() throws IOException {

        if (this.fileToSave.exists()) {
            System.err.println("FILE TO SAVE EXIST");
            throw new FileAlreadyExistsException(this.fileToSave.getAbsolutePath());
        }

        if (this.fileToSave.createNewFile()) {
            System.out.println("FILE CREATED SUCCESSFUL!");
            return;
        }
        System.err.println("FILE " + this.fileToSave.getAbsolutePath() + " DON'T CREATE");

    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @param id id...
     * @param nickName никнейм...
     * @return возвращает...
     */
    public String getProfilePhoto(Long id, String nickName) {

        // reserveNameByFile(id , nickName);


        return !this.fileToSave.exists() ? "NONE AVATAR FILE" : this.fileToSave.getAbsolutePath();
    }
//
//    public File getProfilePhoto(){}


}
