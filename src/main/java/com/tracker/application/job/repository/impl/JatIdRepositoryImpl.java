package com.tracker.application.job.repository.impl;

import com.tracker.application.job.model.Sequence;
import com.tracker.application.job.repository.JatIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class JatIdRepositoryImpl implements JatIdRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String createJatId() {
        // creating query to find specific document with given id
        Query query = new Query(Criteria.where("_id").is("jat_id"));

        // defining how the document should be updated
        Update update = new Update().inc("count", 1);

        // setting options such as return document after update,
        // if no document is found then create new document
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);

        // finds the document and modifies it as per passed update and options
        Sequence sequence = mongoTemplate.findAndModify(query, update, options, Sequence.class);

        // return JAT id as per business requirement
        return "JAT" + sequence.getCount();
    }

}
