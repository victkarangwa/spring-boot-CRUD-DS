package com.victorkarangwa.springbootcrud.Topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("12","Java", "Best programming language ever"),
                new Topic("23","Dart", "Used programming language ever"),
                new Topic("34","Python", "Loved programming language ever")
        ));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
       topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for(int i =0; i<topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals((id))){
                topics.set(i, topic);
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}
