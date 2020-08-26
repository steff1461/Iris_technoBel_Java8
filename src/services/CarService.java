package services;

import repositories.CarDAO;
import services.mapper.CarMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    CarDAO dao = new CarDAO();

    public void createOne(CarModel model){

        dao.create(CarMapper.toEntity(model));
    }

    public List<CarModel> findAll() {

        return dao.findAll()
                .stream()
                .map(CarMapper::toModel)
                .collect(Collectors.toList());
    }

    public CarModel findOneById(String id) {

        return CarMapper.toModel(dao.findOneById(id));
    }

    public void update(CarModel model){

        dao.update(CarMapper.toEntity(model));
    }

    public void delete(String id){

        dao.delete(id);
    }
}
