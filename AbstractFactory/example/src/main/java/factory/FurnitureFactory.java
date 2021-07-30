package factory;

import furniture.Chair;
import furniture.CoffeeTable;
import furniture.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}
