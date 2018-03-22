package application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.domain.Producto;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Integer>{
}
