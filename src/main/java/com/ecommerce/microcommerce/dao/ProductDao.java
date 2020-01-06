package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Api(description="Interface entre les objets Java et la base de données")
public interface ProductDao extends JpaRepository<Product, Integer> {

    @ApiOperation(value = "Récupère un produit par son ID passé en paramètre")
    Product findById(int id);

    @ApiOperation(value = "Récupère une liste de produits dont le prix est strictement supérieur au prix passé en paramètre")
    List<Product> findByPrixGreaterThan(int prixLimit);

    @ApiOperation(value = "Récupère une liste de produits dont le nom match la chaîne passée en paramètre")
	List<Product> findByNomLike(String recherche);

    @ApiOperation(value = "Récupère la liste des produits (ID, nom, prix) dont le prix est strictement supérieur au prix passé en paramètre")
    @Query("SELECT id, nom, prix FROM Product p WHERE p.prix > :prixLimit")
    List<Product>  chercherUnProduitCher(@Param("prixLimit") int prix);
    
    @ApiOperation(value = "Récupère la liste des produits (ID, nom, prix) par ordre alphabétique")
    @Query("SELECT id, nom, prix FROM Product p ORDER BY p.nom")
    List<Product>  trierProduitsParOrdreAlphabetiqueAdmin();

    @ApiOperation(value = "Récupère la liste des produits (ID, nom) par ordre alphabétique")
    @Query("SELECT id, nom FROM Product p ORDER BY p.nom")
    List<Product>  trierProduitsParOrdreAlphabetique();
    
}
