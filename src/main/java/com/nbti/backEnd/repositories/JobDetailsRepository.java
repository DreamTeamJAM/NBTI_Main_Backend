package com.nbti.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nbti.backEnd.model.JobDetails;

public interface JobDetailsRepository extends JpaRepository<JobDetails, Long> {

}
