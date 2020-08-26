package repositories;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class CarDAO extends EntityDAO<CarEntity> {

    public CarDAO() {
        super("C:\\Users\\Will\\Documents\\Cours informatique\\Iris-TechnoBel\\JAVA\\CarDAO\\car" +
                      ".db");
    }

    @Override
    public void create(CarEntity entity) {

        String newEntity = entity.getId() +
                "-" +
                entity.getBrandId() +
                "-" +
                entity.getModel() +
                "-" +
                entity.getPurchasingDate();


        try (PrintWriter pw = new PrintWriter(new FileWriter(getFile(), true))) {

            pw.println(newEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {

        List<CarEntity> tempEntity = findAll().stream()
                .filter(carEntity -> !carEntity
                        .getId()
                        .equals(id)).collect(Collectors.toList());

        rewriteFile(tempEntity);
    }

    @Override
    public void update(CarEntity entity) {

        List<CarEntity> tempEntity = findAll().stream().map(carEntity -> {
            if (carEntity.getId().equals(entity.getId()))
                return entity;
            else return carEntity;
        }).collect(Collectors.toList());

        rewriteFile(tempEntity);
    }


    @Override
    public CarEntity mapToEntity(String line) {

        String[] elements = line.split("-");

        CarEntity entity = new CarEntity();
        entity.setId(elements[0]);
        entity.setBrandId(elements[1]);
        entity.setModel(elements[2]);
        entity.setPurchasingDate(elements[3]);

        return entity;
    }


}
