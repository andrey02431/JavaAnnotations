package annotations_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class DanceCoach implements Coach{

    @Autowired
    @Value("${name}")
    private String name;
    @Autowired
    @Value("${email}")
    private String email;
    @Autowired
    @Qualifier("sadFortuneService")
    private FortuneService f;

    public DanceCoach(){
    }

    @Override
    public String getDailyWorkout() {
        return "Dance Striptease";
    }

    @Override
    public String getFortune() {
        return f.getFortune();
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }

    @PostConstruct
    public void onInnit(){

        System.out.println("Initialised the Bean - Dance");
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("You wont see this as the scope is prototype - Dance");
    }


}
