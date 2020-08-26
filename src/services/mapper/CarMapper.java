package services.mapper;

import repositories.BrandDAO;
import repositories.CarEntity;
import services.BrandModel;
import services.CarModel;

import java.time.LocalDate;

public class CarMapper {

    public static CarModel toModel(CarEntity entity) {

        BrandDAO dao = new BrandDAO();
        String id = entity.getId();
        BrandModel brand = BrandMapper.toModel(dao.findOneById(entity.getBrandId()));
        String[] date = entity.getPurchasingDate().split("/");
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        int day = Integer.parseInt(date[0]);
        LocalDate purchaseDate = LocalDate.of(year,month,day);
        String model = entity.getModel();

        return new CarModel(id, brand, purchaseDate, model);
    }

    public static CarEntity toEntity(CarModel model) {

        CarEntity entity = new CarEntity();

        entity.setModel(model.getModel());
        entity.setId(model.getId());
        entity.setBrandId(model.getBrandModel().getId());
        entity.setPurchasingDate(""+model.getPurchasingDate().getDayOfMonth()+
                                         "/"+model.getPurchasingDate().getMonthValue()+
                                         "/"+ model.getPurchasingDate().getYear());

        return entity;
    }
}
