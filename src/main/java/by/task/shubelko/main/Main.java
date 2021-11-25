package by.task.shubelko.main;

import by.task.shubelko.comparator.BallComparator;
import by.task.shubelko.entity.Point;
import by.task.shubelko.entity.Warehouse;
import by.task.shubelko.exception.BallException;
import by.task.shubelko.filler.RepositoryFiller;
import by.task.shubelko.filler.WarehouseFiller;
import by.task.shubelko.observer.BallObserver;
import by.task.shubelko.observer.impl.BallObserverImpl;
import by.task.shubelko.parser.BallParser;
import by.task.shubelko.reader.Reader;
import by.task.shubelko.reader.impl.BallReaderImpl;
import by.task.shubelko.repository.impl.BallRepositoryImpl;
import by.task.shubelko.repository.impl.RadiusSpecification;

import java.util.List;

public class Main {
    private static final String path = "src/by.task.shubelko.main/resources/data/data.txt";

    public static void main(String[] args) throws BallException {
        Reader reader = new BallReaderImpl();
        BallParser parser = new BallParser();
        RepositoryFiller repositoryFiller = new RepositoryFiller();
        WarehouseFiller warehouseFiller = new WarehouseFiller();
        //путь из source root не работает даже после пересоздания
        List<String> list = reader.readFile("src/by.task.shubelko.main/resources/data/data.txt");
        List<double[]> array = parser.parseStringListToArray(list);
        for (double[] doubleData : array) {
            repositoryFiller.fillBallRepository(doubleData);
            warehouseFiller.fillBallWarehouse(doubleData);
        }

        repositoryFiller.fillBallRepository(new double[]{1, 1, 1, 1});
        warehouseFiller.fillBallWarehouse(new double[]{1, 1, 1, 1});
        Point point = new Point(0, 0, 0);
        repositoryFiller.fillBallRepository(point, 5.7);
        warehouseFiller.fillBallWarehouse(point, 5.7);
        Warehouse warehouse = Warehouse.getInstance();
        BallRepositoryImpl repository = BallRepositoryImpl.getInstance();
        System.out.println(warehouse.get(6L));
        BallObserver observer = new BallObserverImpl();
        repository.get(1).attach(observer);
        repository.get(1).setRadius(0.5);
        System.out.println(warehouse.get(repository.get(1).getBallId()));
        System.out.println(repository.sort(BallComparator.ID.getComparator()));
        System.out.println(repository.query(new RadiusSpecification()));
    }
}
