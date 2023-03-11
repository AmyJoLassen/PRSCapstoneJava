package com.maxtrain.prsspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxtrain.prsspringboot.entities.RequestLine;

public interface RequestLineRepository extends JpaRepository <RequestLine, Integer> {

}
