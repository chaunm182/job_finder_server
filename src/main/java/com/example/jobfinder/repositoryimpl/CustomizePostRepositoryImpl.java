package com.example.jobfinder.repositoryimpl;

import com.example.jobfinder.entity.post.Post;
import com.example.jobfinder.repository.CustomizePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class CustomizePostRepositoryImpl implements CustomizePostRepository {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Post> findByProperties(Map<String, String> properties) {
        List<Post> posts = null;
        StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Post p ");
        if(!properties.isEmpty()){
            queryBuilder.append("WHERE ");
            Set<String> propsName = properties.keySet();
            for(String propName : propsName){
                if(!propName.equals("jobName")){
                    if(propName.equals("jobCategory.id")){
                        queryBuilder.append("p.").append(propName).append(" = :jobCategoryId AND ");
                    }
                    else{
                        queryBuilder.append("p.").append(propName).append(" = :").append(propName).append(" AND ");
                    }

                }
                else{
                    //job name like value
                    queryBuilder.append("p.").append(propName).append(" LIKE :").append(propName).append(" AND ");
                }
            }
            queryBuilder.delete(queryBuilder.length()-4,queryBuilder.length()-1);
        }
        Query query = entityManager.createQuery(queryBuilder.toString().trim());

        //set parameter
        if(!properties.isEmpty()){
            Set<String> propsName = properties.keySet();
            for (String propName : propsName){
                if(propName.equals("jobName")){
                    query.setParameter(propName,"%"+properties.get(propName)+"%");
                }
                else if(propName.equals("jobCategory.id")){
                    query.setParameter("jobCategoryId",Integer.parseInt(properties.get(propName)));
                }
                else{
                    query.setParameter(propName,properties.get(propName));
                }

            }
        }
        posts = query.getResultList();
        return posts;
    }
}
