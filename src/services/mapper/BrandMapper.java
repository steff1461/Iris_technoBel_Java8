package services.mapper;

import repositories.BrandEntity;
import services.BrandModel;

public class BrandMapper {

    public static BrandModel toModel(BrandEntity entity){

        String id = entity.getId();
        String name = entity.getName();

        return new BrandModel(id,name);
    }

    public static BrandEntity toEntity(BrandModel model){

        BrandEntity entity = new BrandEntity();
        entity.setName(model.getName());
        entity.setId(model.getId());
        return entity;
    }
}
