package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VersionRepo;

@Component
public class StartupDataInit {

    @Autowired
    VersionRepo versionRepo;
    
    @Autowired
    CollegueRepo collegueRepo;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {

        if(this.versionRepo.count() <= 0) {
            this.versionRepo.save(new Version("v1"));
            this.versionRepo.save(new Version("v2"));
            this.versionRepo.save(new Version("v3"));
            this.versionRepo.save(new Version("v4"));
        }
        
        if(this.collegueRepo.count() <= 0) {
            this.collegueRepo.save(new Collegue("Bebert","https://media3.giphy.com/media/4j9XOYo6IVDK8/200w.gif?cid=3640f6095c014b58742f3734672e5218",  999));
            this.collegueRepo.save(new Collegue("pervers34","https://media1.giphy.com/media/Ja8ihKn1B3sA/200w.gif?cid=3640f6095c05262b494e73684d6320e6",  -999));
            this.collegueRepo.save(new Collegue("doggystyle","https://media2.giphy.com/media/d3Fym9OQ08o6agYE/200w.gif?cid=3640f6095c0527bb644d4579735f5cdf",  -100));
            this.collegueRepo.save(new Collegue("pupute","https://media1.giphy.com/media/xe9csf50g4SqY/200.gif?cid=3640f6095c052ae5315077353248ff7b",  0));
            this.collegueRepo.save(new Collegue("teen","https://media3.giphy.com/media/3ohjV9GMdGFsuWvPMI/200w.gif?cid=3640f6095c07c3e36153667155f16662",  -100));
            this.collegueRepo.save(new Collegue("bisounours","https://media1.giphy.com/media/laLCSA7UdHs1q/200w.gif?cid=3640f6095c05287a2e346344778dec5d",  -100));
            this.collegueRepo.save(new Collegue( "cathy","https://media0.giphy.com/media/I5R2abTxgU62c/200.gif?cid=3640f6095c0528bd573258356711d8ec", -100));
            this.collegueRepo.save(new Collegue("funnyface","https://media1.giphy.com/media/110gqI69qjVAkM/200w.gif?cid=3640f6095c0528564131394b32109805",  -100));
            this.collegueRepo.save(new Collegue( "cochonou","https://media1.giphy.com/media/8qABb3dgjun8PdNirg/200w.gif?cid=3640f6095c0529ca6579497863c2fb05", -100));
            this.collegueRepo.save(new Collegue("anonymouspresident","https://media1.giphy.com/media/fQQbWnU2g5OcU/200w.gif?cid=3640f6095c052a595a5379624d220236" , -100));
            this.collegueRepo.save(new Collegue( "calins69","https://media3.giphy.com/media/Pjs1kqtH1KTaU/200w.gif?cid=3640f6095c052ae5315077353248ff7b", -100));
            this.collegueRepo.save(new Collegue( "wanker","https://media3.giphy.com/media/MxRkVKrBvfzMY/200.gif?cid=3640f6095c054dfa41536a57591da7bd", -100));
        }
    }
}
