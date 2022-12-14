package engine;

public abstract class InitData {
   public String name;
   //methode set initdata as a name
   public InitData(String name) {

       this.name = name;
   }
   public String getName() {
        return name;
    }
}
