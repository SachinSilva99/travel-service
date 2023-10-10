package com.sachin.travelservice.repo;

import com.sachin.travelservice.entity.PackageCategoryDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageCategoryDetailRepo  extends MongoRepository<PackageCategoryDetail, String>{
}
