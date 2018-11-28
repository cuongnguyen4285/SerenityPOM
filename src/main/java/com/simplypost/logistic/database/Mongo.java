package com.simplypost.logistic.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.simplypost.logistic.utilities.SerenityUtil;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.elemMatch;


/**
 * Created by scorpion on 25/6/17.
 */
public class Mongo {

    private String host;
    private int port ;
    private String dbName ;
    private String username ;
    private String password;

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public Mongo(){
        host = SerenityUtil.getMongoURL();
        port = Integer.parseInt(SerenityUtil.getMongoPort());
        dbName = SerenityUtil.getMongoDbName();
        username = SerenityUtil.getMongoUserName();
        password = SerenityUtil.getMongoPassword();
    }

    public Mongo(String host, int port, String dbName, String username, String password) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    public MongoDatabase getConnection() throws Exception {
        if (mongoClient == null) {
            if (!username.equals("") && !password.equals("")) {
                MongoCredential credential = MongoCredential.createCredential(username, dbName, password.toCharArray());
                mongoClient = new MongoClient(new ServerAddress(host, port), Arrays.asList(credential));
            } else {
                mongoClient = new MongoClient(host, port);
            }
            database = mongoClient.getDatabase(dbName);
            database.listCollectionNames().first(); //Force Exception hanlder
        }
        return database;
    }

    public MongoCollection<Document> getCollection(String collectionName) throws Exception {
        return getConnection().getCollection(collectionName);
    }

    public MongoCollection<Document> changeCollection(String collectionName) throws Exception {
        collection = getCollection(collectionName);
        return collection;
    }

    public Document getDocument(final String key, final Object value) {
        return new Document(key, value);
    }

    public FindIterable<Document> findEleMatch(String collectionName, String filterMainKey, String filterSubKey, Object filterValue) throws Exception {
        MongoCollection<Document> collection =  this.getCollection(collectionName);
        Bson projection = Projections.fields(elemMatch(filterMainKey,eq(filterSubKey,filterValue)));
        return collection.find(projection);
    }

    public FindIterable<Document> find(String collectionName, String filterKey, Object filterValue) throws Exception {
        MongoCollection<Document> collection =  this.getCollection(collectionName);
        return collection.find(Filters.eq(filterKey, filterValue));
    }

    public UpdateResult update(String filterKey, Object filterValue, String updateKey, Object updateValue) throws Exception {
        return update(collection, filterKey, filterValue, updateKey, updateValue);
    }

    public UpdateResult update(MongoCollection<Document> collection, String filterKey, Object filterValue,
                               String updateKey, Object updateValue) throws Exception {
        return collection.updateOne(getDocument(filterKey, filterValue),
                new Document("$set", getDocument(updateKey, updateValue)));
    }

    public void insert(String filterKey, Object filterValue, String updateKey, Object updateValue) throws Exception {
        insert(collection, filterKey, filterValue, updateKey, updateValue);
    }

    public void insert(MongoCollection<Document> collection, String filterKey, Object filterValue,
                       String updateKey, Object updateValue) throws Exception {
        collection.insertOne(getDocument(filterKey, filterValue));
    }

    public DeleteResult delete(String filterKey, Object filterValue) throws Exception {
        return this.delete(collection, filterKey, filterValue);
    }

    public DeleteResult delete(MongoCollection<Document> collection, String filterKey, Object filterValue) throws Exception {
        return collection.deleteOne(Filters.eq(filterKey, filterValue));
    }

    public void close() {
        mongoClient.close();
        mongoClient = null;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDbName() {
        return dbName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        return database;
    }

}
