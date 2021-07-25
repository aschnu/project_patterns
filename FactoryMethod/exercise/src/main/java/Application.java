import plant.Belladonna;
import plant.Lavender;

public class Application {
    private static Lavender lavender;
    private static Belladonna belladonna;

    public static void main(String[] args) throws Exception {

        String kindOfHerb = args[0];

        switch (kindOfHerb) {
            case "lavender" -> lavender = new Lavender();
            case "belladonna" -> belladonna = new Belladonna();
            default -> throw new Exception("Error! Unknown operating system.");
        }

        if(lavender != null){
            if(!lavender.isEdible()){
                System.out.println("Added warning.");
            }
            lavender.packing(lavender.countNumberOfPackage(Integer.parseInt(args[1])));
        }
        if(belladonna!=null){
            if(!belladonna.isEdible()){
                System.out.println("Added warning");
            }
            belladonna.packing(belladonna.countNumberOfPackage(Integer.parseInt(args[1])));
        }

    }
}
