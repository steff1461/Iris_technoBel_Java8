package services;

import repositories.BrandDAO;
import services.mapper.BrandMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BrandService {

    private final BrandDAO dao = new BrandDAO();

    public List<BrandModel> findAll(){

        return dao.findAll()
                .stream()
                .map(BrandMapper::toModel)
                .collect(Collectors.toList());
    }

    public BrandModel findOneById(String id){


        return BrandMapper.toModel(dao.findOneById(id));
    }

    public void delete(String id){

        dao.delete(id);
    }

}
