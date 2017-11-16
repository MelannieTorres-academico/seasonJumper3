public class Factory{

    private static Factory instance;

    private Factory(){
    }

    public static Factory getInstance(){
      if(instance==null){
        instance= new Factory();
      }
      return instance;
    }

    public GameState createState(String tag){
      if(tag.equalsIgnoreCase("menu")){
        return new MenuState();
      }
      if(tag.equalsIgnoreCase("help")){
        return new HelpState();
      }
      if(tag.equalsIgnoreCase("load")){
        return new LoadState();
      }
      if(tag.equalsIgnoreCase("winter")){
        return new WinterState();
      }
      if(tag.equalsIgnoreCase("spring")){
        return new SpringState();
      }
      if(tag.equalsIgnoreCase("summer")){
        return new SummerState();
      }
      if(tag.equalsIgnoreCase("autumn")){
        return new AutumnState();
      }
      if(tag.equalsIgnoreCase("lose")){
        return new LoseState();
      }
      if(tag.equalsIgnoreCase("win")){
        return new WinState();
      }
      if(tag.equalsIgnoreCase("end")){
        return new EndState();
      }
      return null;
    }



}
