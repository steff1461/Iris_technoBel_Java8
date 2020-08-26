package repositories;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class BrandDAO extends EntityDAO<BrandEntity> {
    public BrandDAO( ) {
        super("C:\\Users\\Will\\Documents\\Cours " +
                      "informatique\\Iris-TechnoBel\\JAVA\\CarDAO\\marque.db");
    }


    @Override
    public void create(BrandEntity entity) {

        String newEntity = entity.getId()+"-"+entity.getName();

        try (PrintWriter pw = new PrintWriter(new FileWriter(getFile(), true))) {

            pw.println(newEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void delete(String id) {

        List<BrandEntity> tempEntity = findAll().stream()
                .filter(brandEntity -> !brandEntity
                        .getId()
                        .equals(id)).collect(Collectors.toList());

        rewriteFile(tempEntity);
    }



    @Override
    public BrandEntity mapToEntity(String line) {

        String[] elements = line.split("-");
        BrandEntity entity = new BrandEntity();
        entity.setId(elements[0]);
        entity.setName(elements[1]);

        return entity;
    }


    @Override
    public void update(BrandEntity entity) {}

}
