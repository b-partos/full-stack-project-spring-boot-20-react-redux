package com.partosb.udemy.ppmtool.repositories;

import com.partosb.udemy.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByProjectIdentifier(String projectId);

    Iterable<Project> findAll();

    @Override
    Iterable<Project> findAllById(Iterable<Long> longs);


}
