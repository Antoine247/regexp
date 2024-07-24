package test.java;

import main.java.*;


public class TestMain {

    public void runTests(){
        

            try {
                
              Main main = new Main();
              main.logging();
              main.start("./");
                
            } catch (Exception e) {
                e.printStackTrace();
            }

            

            
         }
        


    }
    

