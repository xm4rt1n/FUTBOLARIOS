package com.FUTBOLARIOS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoticiasRepository extends JpaRepository<noticias,Long> 
{

}
