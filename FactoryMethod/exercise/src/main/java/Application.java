import plant.Bush;
import plant.Herb;

public class Application {
    private static Herb herb;
    private static Bush bush;

    public static void main(String[] args) throws Exception {

        String kindOfHerb = args[0];

        switch (kindOfHerb) {
            case "herb" -> herb = new Herb();
            case "bush" -> bush = new Bush();
            default -> throw new Exception("Error! Unknown operating system.");
        }

        if(herb != null){
            if(!herb.isEdible()){
                System.out.println("Added warning.");
            }
            herb.packing(herb.countNumberOfPackage(Integer.parseInt(args[1])));
        }
        if(bush !=null){
            if(!bush.isEdible()){
                System.out.println("Added warning");
            }
            bush.packing(bush.countNumberOfPackage(Integer.parseInt(args[1])));
        }

    }
}
