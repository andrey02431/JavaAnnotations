package annotations_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

    private String filename = "C:\\Users\\andre\\Spring\\JavaAnnotations\\src\\properties_file";
    private FortuneService f;

    @Autowired
    public TennisCoach(@Qualifier("weirdFortune")FortuneService f){
        this.f = f;
    }


    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getFortune(){
        return f.getFortune();
    }

    @PostConstruct
    public void onInnit(){

        System.out.println("Initialised the Bean - Tennis");
    }

    @PreDestroy
    public void onDestroy() throws FileNotFoundException {
        System.out.println("Destroyed the bean - Tennis");
        System.out.println("Reading properties file ");
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        int x =1;
        while(scan.hasNext()){
            System.out.printf("%d %50s\n",x, scan.nextLine());
            x++;
        }
    }


}
