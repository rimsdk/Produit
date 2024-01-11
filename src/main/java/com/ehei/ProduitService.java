package com.ehei;
import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }


    public void createProduit(Produit PROD) {
        if (!estUnique(PROD)) {
            System.out.println("produit deja existe.");
            return;
        }

        if (!sontDonneesValides(PROD)) {
            System.out.println("donnes non valides");
            return;
        }

        produits.add(PROD);
    }
    

    private boolean estUnique(Produit produit) {
        return produits.stream().noneMatch(p -> p.getId() == produit.getId() || p.getNom().equals(produit.getNom()));
    }



    private boolean sontDonneesValides(Produit produit) {
        if (produit.getPrix() <= 0 || produit.getQuantite() <= 0) {
            return false;
        }
        return true;
    }

}