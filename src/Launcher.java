import repositories.BrandDAO;
import repositories.BrandEntity;
import repositories.CarDAO;
import repositories.CarEntity;
import services.BrandService;
import services.CarModel;
import services.CarService;
import services.mapper.CarMapper;
import view.ConsoleInterface;

import java.time.LocalDate;

public class Launcher {

    public static void main(String[] args) {


        ConsoleInterface ci = new ConsoleInterface();

        ci.displayMenu();

    }
}
