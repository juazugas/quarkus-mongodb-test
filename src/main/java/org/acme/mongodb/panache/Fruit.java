package org.acme.mongodb.panache;

import java.time.LocalDate;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonProperty;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Fruit extends PanacheMongoEntity {

    public enum Status {
      GREEN, RIPE, ROTTEN;
    }
  
    public String name;
    
    @BsonProperty("delivery")
    public LocalDate deliveryDt;

    public Status status;

    public static Fruit findByName(String name){
        return find("name", name).firstResult();
    }

    public static List<Fruit> findRipe(){
        return list("status", Status.RIPE);
    }

    public static void deleteWasted(){
        delete("status", Status.ROTTEN);
    }
}