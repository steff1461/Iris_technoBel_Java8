package repositories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class EntityDAO<T> {

    private String dbPath;
    private File file;

    public EntityDAO(String dbPath) {

        setDbPath(dbPath);
        file = new File(getDbPath());
    }


    public List<T> findAll() {

        List<T> allEntities = new ArrayList<>();

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {

                allEntities.add(mapToEntity(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allEntities;
    }

    public T findOneById(String id) {

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {

                if (line.split("-")[0].equals(id)) return mapToEntity(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public abstract void create(T entity);

    public abstract void delete(String id);

    public abstract void update(T entity);

    public abstract T mapToEntity(String line);

    public void rewriteFile(List<T> tempEntity){

        getFile().delete();
        tempEntity.forEach(this::create);
    }

    public String getDbPath() {
        return dbPath;
    }

    public void setDbPath(String dbPath) {
        this.dbPath = dbPath;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
