import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterObjectFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterStreamingAPI {
    
    public static void main(String[] args){
        
        StatusListener listener = new StatusListener(){
            public void onStatus(Status status) {

            	String rawJSON = TwitterObjectFactory.getRawJSON(status);
            	//System.out.println(rawJSON);
            	try {
            	    Files.write(Paths.get("tweets.txt"), rawJSON.getBytes(), StandardOpenOption.APPEND);
            	}catch (IOException e) {
            	    e.printStackTrace();
            	}
            	
            }
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
            @Override
            public void onScrubGeo(long arg0, long arg1) {
                // TODO Auto-generated method stub
                
            }
            @Override
            public void onStallWarning(StallWarning arg0) {
                // TODO Auto-generated method stub
                
            }            
        };
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setJSONStoreEnabled(true)
          .setOAuthConsumerKey("pP1J7uY9Vyh7dCMAOy3r54czu")
          .setOAuthConsumerSecret("DxrlJ5hFgIsGBbVwtBDdy5v0KJddR275vxnT09lsbygXESJdAw")
          .setOAuthAccessToken("1150625820-Yl7MMVZy5YmTl8K619bKxh6eqKJuV5dHQL6fDzc")
          .setOAuthAccessTokenSecret("Oxthr5EdxqDtIWgKPTrkRZCHVvg42dCTmqWrPrcJCg4Wi");
        
        TwitterStreamFactory tf = new TwitterStreamFactory(cb.build());
        TwitterStream twitterStream = tf.getInstance(); 
        twitterStream.addListener(listener);
        
        FilterQuery filtre = new FilterQuery();
        String[] keywordsArray = { "Trump" };
        //String[] keywordsArray = { "cricket", "footbal" }; //filter based on your choice of keywords
        filtre.track(keywordsArray);
        twitterStream.filter(filtre);        
    }       
}